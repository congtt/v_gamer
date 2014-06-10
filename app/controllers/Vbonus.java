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

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import play.*;
import play.libs.Json;
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
		configInfo
				.put("inviteFromDate", DateHelper.ymdToVNDate(inviteFromDate));
		configInfo.put("inviteToDate", DateHelper.ymdToVNDate(inviteToDate));
		configInfo.put("token", token);
		configInfo.put("gamerCode", gameCode);

		List<HashMap<String, String>> serverList = getServerList(
				Integer.valueOf(configId), gameCode);
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
		Html inpServerList = FormHelper.addSelectList("server", serverList,
				"Chọn server", arrtList, "");
		arrtList.put("onchange", "showInfoCharacter();");
		 Html inpCharacterList = FormHelper.addSelectList("character", null,
		 "Chọn Character", arrtList, "");

		HashMap<String, Html> listInput = new HashMap<String, Html>();
		listInput.put("server", inpServerList);
		listInput.put("character", inpCharacterList);
		
		Html content = views.html.vbonus.register.render("", configInfo,
				Login.getUserInfoLogin(), listInput);

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
	public static List<HashMap<String, String>> getServerList(int configId,
			String gameCode) {

		List<HashMap<String, String>> serverList = new ArrayList<>();
		try {
			HashMap<String, String> server = new HashMap<String, String>();
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

					String serverId = eElement.getElementsByTagName("server_id").item(0).getTextContent();
					String serverName = eElement.getElementsByTagName("server_name").item(0).getTextContent();
					String token = helper.Fnc.md5Sum(configId+serverId+serverName);
					server.put("value",serverId);
					server.put("name",serverName);
					server.put("token",token);				
				}
			}
			serverList.add(server);

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
	public static Result ajaxVbonusRegister(int configId,String vbonusCode,
			String captchaCode, String serverId, String serverName,String characterName,int level,String firstLogin, String token) {
		
		if(helper.Fnc.md5Check(String.valueOf(configId)+serverId+serverName+characterName+level+firstLogin, token)){
			String username = Login.getUserLogin();
			String memberId = helper.Fnc.vBonusIdDecode(vbonusCode);	
			models.Vbonus.register(configId,username, memberId, vbonusCode, serverId, serverName, characterName, level, firstLogin);				
			return ok("1");
		}
		return ok("-100");
		//return ok("result call ajax: " + vbonusCode + " - " + captchaCode	+ " - " + serverId + " - " + " - " + serverName + " - "+ characterName + " - " + level + " - "+ " - " + firstLogin + " - "+ " - " + token + " - ");
	}

	@Security.Authenticated(Secured.class)
	public static Result javascriptRoutes() {
		response().setContentType("text/javascript");
		return ok(Routes.javascriptRouter(
				"jsVbonusRoutes",
				// Routes
				controllers.routes.javascript.Vbonus.ajaxVbonusTest(),
				controllers.routes.javascript.Vbonus.ajaxVbonusGetCharacter(),
				controllers.routes.javascript.Vbonus.ajaxVbonusRegister()));

	}
	
	@Security.Authenticated(Secured.class)
	public static Result ajaxVbonusGetCharacter(int configId,String serverId,String serverName, String token) {		
		if(helper.Fnc.md5Check(configId+serverId+serverName, token)){
			List<HashMap<String,String>> characterList = getListCharacter(configId,serverId,serverName);	
			String result = com.vng.csm.helper.FncHelper.listHashMapToJsonString(characterList);
			return ok(result);
		}
		return ok("-101");
	}
	
	@Security.Authenticated(Secured.class)
	public static List<HashMap<String,String>> getListCharacter(int configId,String serverId,String serverName){
		HashMap<String,String>userInfo = Login.getUserInfoLogin();		
		List<HashMap<String,String>> characterList = new ArrayList<>();
		HashMap<String,String> paramCallApi = new HashMap<String,String>();
		paramCallApi.put("configId", "configId");	
		paramCallApi.put("zingId", userInfo.get("zingId"));
		paramCallApi.put("passportId", userInfo.get("passportId"));
		paramCallApi.put("serverId", serverId);		
		paramCallApi.put("serverName", serverName);		
		paramCallApi.put("api_gamecode", "api_gamecode");
		paramCallApi.put("api_type", "api_type");
		paramCallApi.put("api_esb_new", "api_esb_new");
		paramCallApi.put("api_level", "5");
		String result = api.ApiHelper.getCharacterName(paramCallApi);
		Logger.info("call api result: "+result);
		int apiLevel = 5;
		for(int i = 1 ; i <= 10 ; i++){
			
			String characterName = "Nhân vật "+String.valueOf(i);
			int level = i;
			String firstLogin = "firstLogin"+String.valueOf(i);
			
			HashMap<String,String> character = new HashMap<String,String>();
			String token = helper.Fnc.md5Sum(String.valueOf(configId)+serverId+serverName+characterName+level+firstLogin);
			String isRegister = "0";
			if(level >= apiLevel){
				isRegister = "1";
			}
			character.put("id", characterName);
			character.put("name", characterName);
			character.put("level", String.valueOf(level));
			character.put("firstLogin",firstLogin);
			character.put("isRegister",isRegister);	
			character.put("token", token);
			characterList.add(character);
		}		
		
		return characterList;
	}

}
