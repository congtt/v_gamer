/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static play.data.Form.form;
import helper.Fnc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;

import play.Play;
import play.Routes;
import play.api.templates.Html;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import com.vng.csm.helper.DateHelper;
import com.vng.csm.helper.FormHelper;

/**
 * 
 * @author congtt
 */
public class Vbonus extends Application {

	final static Form<controllers.Vbonus> registerForm = form(controllers.Vbonus.class);

	public static Result add() {

		Form<controllers.Vbonus> filledForm = registerForm.bindFromRequest();
		if (!filledForm.hasErrors()) {
			return ok(filledForm.field("name").value());
		}
		
		return ok("e");
	}
	
	@Security.Authenticated(Secured.class)
	public static Result register(String configId, String fromDate,
			String toDate, String inviteFromDate, String inviteToDate,
			String token, String gameCode) {
		// helper.Helper.debug("param: ",
		// configId+"-"+fromDate+"-"+toDate+"-"+inviteFromDate+"-"+inviteToDate+"-"+token+"-"+gameCode
		// );
		// HashMap<String, String> configInfo = models.Vbonus.GetConfigInfo();
		HashMap<String, String> configInfo = new HashMap<String, String>();
		configInfo.put("configId", configId);
		configInfo.put("fromDate", DateHelper.ymdToVNDate(fromDate));
		configInfo.put("toDate", DateHelper.ymdToVNDate(toDate));
		configInfo.put("inviteFromDate", DateHelper.ymdToVNDate(inviteFromDate));
		configInfo.put("inviteToDate", DateHelper.ymdToVNDate(inviteToDate));
		configInfo.put("token", token);
		configInfo.put("gamerCode", gameCode);

		HashMap<String, String> serverList = getServerList(Integer.valueOf(configId), gameCode);
		HashMap<String, HashMap<String, String>> configVbonus = getConfigVbonus(
				Integer.valueOf(configId), gameCode);

		if (configVbonus != null && !configVbonus.isEmpty()) {
			HashMap<String, String> info = configVbonus.get("info");
			helper.Helper.debug("info ", info.toString());

			if (serverList != null && !serverList.isEmpty()) {
				helper.Helper.debug("server ", serverList.toString());
			}
		}
		HashMap<String, String> arrtList = new HashMap<>();
		arrtList.put("onchange", "getCharacter();");
		Html inpServerList = FormHelper.addSelectList("server", serverList, "Chọn server", arrtList, "");
		Html inpCharacterList = FormHelper.addSelectList("character", null, "Chọn Character", null, "");

		HashMap<String, Html> listInput = new HashMap<String, Html>();
		listInput.put("server", inpServerList);
		listInput.put("character", inpCharacterList);

		Html content = views.html.vbonus.register.render("", configInfo,
				Login.getUserLogin(), listInput);

		return ok(Application.getContentPage("Register vbonus", content));
	}

	@Security.Authenticated(Secured.class)
	public static HashMap<String, HashMap<String, String>> getConfigVbonus(
			int configId, String gameCode) {

		HashMap<String, HashMap<String, String>> config = new HashMap<String, HashMap<String, String>>();
		HashMap configInfo = new HashMap<String, String>();
		try {
			File fXmlFile = new File(Play.application().configuration()
					.getString("site.configPath").toString()
					+ "vbonus\\config\\" + gameCode + ".xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			// System.out.println("Root element :" +
			// doc.getDocumentElement().getNodeName());

			NodeList nListRoot = doc.getElementsByTagName("vbonus_config");
			Element nodeRoot = (Element) nListRoot.item(0);
			String configIdRoot = nodeRoot.getAttribute("id");
			NodeList nList = doc.getElementsByTagName("info");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					configInfo.put("configId",
							eElement.getElementsByTagName("config_id").item(0)
									.getTextContent());
					configInfo.put("api_gamecode", eElement
							.getElementsByTagName("api_gamecode").item(0)
							.getTextContent());
					configInfo.put("apiLevel",
							eElement.getElementsByTagName("api_level").item(0)
									.getTextContent());
					configInfo.put("apiType",
							eElement.getElementsByTagName("api_type").item(0)
									.getTextContent());
					configInfo.put("apiEsbNew",
							eElement.getElementsByTagName("api_esb_new")
									.item(0).getTextContent());

				}
			}
			config.put("info", configInfo);

		} catch (Exception ex) {
			helper.Helper.debug("error load config vbonus " + configId,
					ex.getMessage());
		}
		return config;
	}

	@Security.Authenticated(Secured.class)
	public static HashMap<String, String> getServerList(
			int configId, String gameCode) {

		HashMap<String, String> serverList = new HashMap<String, String>();
		try {
			File fXmlFile = new File(Play.application().configuration()
					.getString("site.configPath").toString()
					+ "vbonus\\server\\" + gameCode + ".xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			// System.out.println("Root element :" +
			// doc.getDocumentElement().getNodeName());

			NodeList nListRoot = doc.getElementsByTagName("vbonus_config");
			NodeList nListServer = doc.getElementsByTagName("server_list");
			for (int temp = 0; temp < nListServer.getLength(); temp++) {
				Node nNode = nListServer.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					serverList.put(eElement.getElementsByTagName("server_id").item(0).getTextContent()
							, eElement.getElementsByTagName("server_name").item(0).getTextContent());
				}
			}

		} catch (Exception ex) {
			helper.Helper.debug("error load config vbonus " + configId,
					ex.getMessage());
		}
		return serverList;
	}

	@Security.Authenticated(Secured.class)
	public static Result ajaxVbonusTest(String str) {
		return ok("result call ajax: " + str);
	}

	@Security.Authenticated(Secured.class)
	public static Result ajaxVbonusRegister(String vbonusCode,
			String captcha_code, String serverId, String character, String token) {
		return ok("result call ajax: " + vbonusCode + " - " + captcha_code
				+ " - " + serverId + " - " + character + " - " + token + " - ");
	}

	@Security.Authenticated(Secured.class)
	public static Result javascriptRoutes() {
		response().setContentType("text/javascript");
		return ok(Routes.javascriptRouter("jsVbonusRoutes",
				// Routes
				controllers.routes.javascript.Vbonus.ajaxVbonusTest(),
				controllers.routes.javascript.Vbonus.ajaxVbonusGetCharacter(),
				controllers.routes.javascript.Vbonus.ajaxVbonusRegister()));

	}

	@Security.Authenticated(Secured.class)
	public static Result ajaxVbonusGetCharacter(String serverId,String token) {
		return ok("list character: "+serverId +" token: "+token);
	}

}
