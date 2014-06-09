package controllers;

//import com.google.common.collect.Lists;
import java.sql.Timestamp;

import com.vng.up.play.Auth;

import play.mvc.*;
import play.api.libs.iteratee.*;
import views.html.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import play.*;
import play.api.templates.Html;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	public static String username;

	public static Result index() {

		// Html h = com.vng.csm.helper.FormHelper.addInput("text", "name",
		// "congtt", "add name", "clsss", "color:red;");
		//
		// List<HashMap<String, String>> options = new ArrayList<HashMap<String,
		// String>>();
		//
		// HashMap<String, String> m1 = new HashMap<String, String>();
		// HashMap<String, String> m2 = new HashMap<String, String>();
		// HashMap<String, String> m3 = new HashMap<String, String>();
		// m1.put("key", "1");
		// m1.put("value", "loai 1");
		// options.add(m1);
		// m2.put("key", "2");
		// m2.put("value", "loai 2");
		// options.add(m2);
		// m3.put("key", "3");
		// m3.put("value", "loai 3");
		// options.add(m3);
		//
		// Html h2 = com.vng.csm.helper.FormHelper.addSelectList("namese",
		// "1", "chon title", "className", "color:red;", options);
		//
		// return ok("data: " + h + "<br>" + h2);
		// HashMap<String, HashMap<String, String>> config =
		// helper.Config.getConfigVbonus("jx1", 37);
		// if (config != null && !config.isEmpty() ) {
		// HashMap<String, String> info = config.get("info");
		// HashMap<String, String> serverList = config.get("serverList");
		// helper.Helper.debug("info ", info.toString());
		// helper.Helper.debug("server ", serverList.toString());
		// } else {
		// System.out.println("NULL ");
		// }
		// return ok("12");

		// Map<String,String> m = null;
		// m = helper.Fnc.ReadXmlFile("");
		// helper.Helper.debug("XML result ", m.toString());
		// return
		// ok(Play.application().configuration().getString("site.siteUrl").toString());

		// Auth au = new Auth();
		// au.GetAuth();
		// models.Vbonus.TestDB();
		// return ok("done");

		// List<HashMap> menus;
		// menus = models.Vbonus.GetMenu();
		// String str = null;
		// for(int i = 0 ; i < menus.size(); i ++){
		// HashMap menu;
		// menu = menus.get(i);
		// str+= menu.get("name").toString()+" - "+menu.get("page").toString();
		// str+= "\n ==== \n";
		//
		// }
		// str+= session().get("username");
		// return ok(str);
		//

		HashMap<String, String> attrList = new HashMap<String, String>();
		
		attrList.put("onchange", "getCharacter();");
		attrList.put("placeholder", "-placeholder-");

		List<HashMap<String, String>> options = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			HashMap<String, String> option = new HashMap<String, String>();

			option.put("value", String.valueOf(i));
			option.put("name", " Loại "+String.valueOf(i));
			option.put("attr", "2");
			option.put("item", "item");
			option.put("gamecode", "ZG");
			options.add(option);
		}

		HashMap<String, String> option = new HashMap<String, String>();
		for (int i = 1; i < 10; i++) {
			option.put(String.valueOf(i),"loai "+ String.valueOf(i));
		}
		HashMap<String, String> value = new HashMap<String, String>();
		value.put("2", "2");
		value.put("5", "5");

		Html html = com.vng.csm.helper.FormHelper.addTextarea("note",5,30,"note",attrList);
		
		html = html.$plus$eq(com.vng.csm.helper.FormHelper.addInput("text", "inputname","",attrList));
		
		html =html.$plus$eq(com.vng.csm.helper.FormHelper.addSelectListItems("name", options, "--chon--", attrList, value,6)); 
//		Html html = com.vng.csm.helper.FormHelper.addSelectList("name", options, "-- chon --", m, "1");
		
		//return ok(com.vng.csm.helper.FncHelper.dateToVNDate("2014-10-24 10:20:30 ","yyyymmdd ss","dd/mm/yyyy hh:mm:ss"));
		
		
		//return ok(com.vng.csm.helper.FncHelper.dateToVNDate("15/12/2014 10","dd/MM/yyyy HH","yyyy-MM-dd HH:mm:ss"));
		
//		String str = ""; 
//		java.util.Date d = com.vng.csm.helper.DateHelper.getDateFromDate("1990-12-12 10:10:10", false);		
//		str += "t1: "+com.vng.csm.helper.DateHelper.getTimeStamp(d)+"\n";
//		str += "d1: "+com.vng.csm.helper.DateHelper.timeToVNDate(com.vng.csm.helper.DateHelper.getTimeStamp(d),true)+"\n";
//		
//		java.util.Date d2 = com.vng.csm.helper.DateHelper.getDateFromDate("2014-11-12 10:25:35", false);		
//		str += "t2: "+com.vng.csm.helper.DateHelper.getTimeStamp(d2)+"\n";
//		str += "d2: "+com.vng.csm.helper.DateHelper.timeToVNDate(com.vng.csm.helper.DateHelper.getTimeStamp(d2),true)+"\n";
//		
//		str += "d3: "+com.vng.csm.helper.DateHelper.vnDateToDate("25/12/2000 10:12:23",false)+"\n";
//		str += "d4: "+com.vng.csm.helper.DateHelper.dateToVNDate("2014-08-25 12:34:23",true)+"\n";
//		
//		str += "d5: "+com.vng.csm.helper.DateHelper.ymdToDate("20130605")+"\n";
//		str += "d6: "+com.vng.csm.helper.DateHelper.ymdToVNDate("20140502")+"\n";
//		
//		str += "d7: "+com.vng.csm.helper.DateHelper.dateToYmd("2014-08-25")+"\n";
//		str += "d8: "+com.vng.csm.helper.DateHelper.vnDateToYmd("25/12/2000")+"\n";
//		
//		
//		str += "d8: "+com.vng.csm.helper.DateHelper.dateFormat("12/05/2000 10:17:50", "dd/MM/yyyy HH:mm:ss", "dd/MM/yyyy HH:mm:ss");
//		
//		
//		
//		Map<String,String> hm = new HashMap<String,String>();
//		hm.put("2", "ten chi phi 311");
//		hm.put("4", "bon chi phi ten chi phi 3");
//		hm.put("nam", "zui cac phan");
//		
//		
//		Map<String, String> unsortMap = new HashMap<String, String>();
//		unsortMap.put("2", "B");
//		unsortMap.put("1", "A");
//		unsortMap.put("4", "D");
//		unsortMap.put("3", "B");
//		unsortMap.put("10", "C");
//		unsortMap.put("5", "z");
//		unsortMap.put("6", "b");
//		unsortMap.put("8", "a");
// 
//		System.out.println("Unsort Map......");
//		printMap(unsortMap);
// 
//		System.out.println("Sorted Map......");
//		Map<String, String> treeMap = new TreeMap<String, String>(unsortMap);
//		printMap(treeMap);
//		
//		return ok(hm.toString());
		//return ok(str);
		
		//return ok(com.vng.csm.helper.FncHelper.dateToVNDate("2014-10-24 10:15:45","yyyy-MM-dd HH:mm:ss","dd/MM/yyyy HH:mm:ss"));
		//return ok(html);
		
		if (!Login.checkLogin()) {
			return redirect(controllers.routes.Login.login());
		} else {
			return redirect(controllers.routes.Application.welcome());
		}
	}

	
	public static void printMap(Map<String, String> map) {
		System.out.println("================================================\n");
		for (Map.Entry entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : "
				+ entry.getValue());
		}
		System.out.println("================================================\n");
	}
	
	public static Html getMenuLeft() {
		Html menuLeft = null;
		if (Login.checkLogin()) {
			List<HashMap<String, String>> menus = models.Vbonus.GetMenu();
			// helper.Helper.debug("menu left", menus.toString());
			menuLeft = views.html.vbonus.menuLeft.render(helper.Config
					.getConfig().get("siteConfig"), "", 1, menus);
		} else {
			menuLeft = views.html.vbonus.menuLeft.render(helper.Config
					.getConfig().get("siteConfig"), "", 0, null);
		}

		return menuLeft;
	}
	@Security.Authenticated(Secured.class)
	public static Result welcome() {
		Login.CheckLoginRedirec();
		Html content = views.html.vbonus.welcome.render("");
		Html menuLeft = Application.getMenuLeft();
		return ok(getContentPage("WELCOMEPAGE", content));
	}

	public static Html getContentPage(String title, Html content) {
		Html menuLeft = Application.getMenuLeft();
		return views.html.vbonus.layout.render(
				helper.Config.getConfig().get("siteConfig"),
				Login.getUserLogin(), title, menuLeft, content);
	}

	//
	// public static Result login() {
	// Html content = views.html.vbonus.login.render("");
	// Html menuLeft = Application.getMenuLeft();
	// return ok(views.html.vbonus.layout.render("login", menuLeft, content));
	// }
	//
	// public static Result redirec() {
	// return ok("redirec");
	// }
	//
	//
	// public static boolean checkLogin() {
	// if (session("gamer_is_login").equals("1")) {
	// return true;
	// }
	// return false;
	// }
}
