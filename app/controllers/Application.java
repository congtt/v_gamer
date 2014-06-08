package controllers;

//import com.google.common.collect.Lists;
import com.vng.up.play.Auth;
import play.mvc.*;
import play.api.libs.iteratee.*;
import views.html.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//    	HashMap<String,String> m = new HashMap<String,String>();
//    	m.put("style", "color:red;size:30;");
//    	m.put("onchange", "getCharacter();");
//    	
//    	HashMap<String,String> p = new HashMap<String,String>();
//    	
//    	p.put("1", "loai 1");
//    	p.put("2", "loai 2");
//    	
//    	return ok(com.vng.csm.helper.FormHelper.addSelectList2("text",p,null,m,"121"));	 
    	
		if (!Login.checkLogin()) {
			return redirect(controllers.routes.Login.login());
		} else {
			return redirect(controllers.routes.Application.welcome());
		}
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
