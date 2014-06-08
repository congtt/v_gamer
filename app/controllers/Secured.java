package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;

import models.*;

public class Secured extends Security.Authenticator {

    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("is_login");
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(controllers.routes.Login.login());
    }
}