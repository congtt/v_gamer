/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.HashMap;
import play.api.templates.Html;
import static play.mvc.Controller.session;
import play.mvc.Result;
import views.html.*;

/**
 *
 * @author congtt
 */
public class Login extends Application {

    public static Result login() {
    	String message ="";
    	if(flash().get("error_login_msg")!= null){
    		message = flash().get("error_login_msg");
    	}
        Html content = views.html.vbonus.login.render(message,helper.Config
		    .getConfig().get("siteConfig"));
        Html menuLeft = Login.getMenuLeft();
        return ok(Application.getContentPage("login", content));
    }

    public static Result logout() {
        // clear session
        session().clear();
        // end clear session
        return redirect(controllers.routes.Login.login());
    }
    // http://localhost:9000/gamer/login/redirec?mess=succ&u=minhngo324

    public static Result redirec() {
        session().clear();
        String result = request().getQueryString("mess");
        String username = request().getQueryString("u");
        if (result.equals("succ")) {
            session("is_login", "1");
            session("username", username);
            return redirect(controllers.routes.Application.welcome());
        } else {
        	flash("error_login_msg","Tên đăng nhập hoặc mật khẩu không tồn tại.");
            return redirect(controllers.routes.Login.login());
        }

    }

    public static Result CheckLoginRedirec() {
        try {
            if (session("is_login").isEmpty() || !session("is_login").equals("1")) {
                return redirect(controllers.routes.Login.login());
            }
        } catch (Exception ex) {
        }
        return ok("");
    }

    public static boolean checkLogin() {
        try {
            if (!session("is_login").isEmpty() && session("is_login").equals("1")) {
                return true;
            }
        } catch (Exception ex) {
        }
        return false;
    }

    public static HashMap<String, String> getUserLogin() {
        // return "minhngo324";
        if (checkLogin()) {
            HashMap<String, String> userInfo = new HashMap<String, String>();
            userInfo.put("username", session().get("username"));
            userInfo.put("registerDate", "10/11/1990");
            return userInfo;
        }
        return null;
    }
}
