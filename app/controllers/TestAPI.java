package controllers;

import org.json.JSONObject;
import org.omg.CORBA.Request;

import play.mvc.Controller;
import play.mvc.Result;

public class TestAPI extends Controller{
/*
	public static Result getCharacteṛ(String serverId,String serverName){
		JSONObject json = new JSONObject();
		json.put("serverId",serverId);
		json.put("serverName",serverName);
		String result  = json.toString();
		return ok(result);
	}
	*/
	public static Result getCharacter(){
		String result = "1231";
		try{
			
			String serverId = request().getQueryString("serverId");
			String serverName = request().getQueryString("serverName");
			JSONObject json = new JSONObject();
			json.put("serverId","12");
			json.put("serverName","serverName");
			result  = json.toString();
		}
		catch(Exception ex){
			result = "error";
		}
		return ok(result);
	}
	
}
