package controllers;

import helper.Config;

import org.json.JSONObject;
import org.omg.CORBA.Request;

import play.Play;
import play.libs.WS;
import play.libs.F.Promise;
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
			
			String serverId = request().getQueryString("serverId1");
			String serverName = request().getQueryString("serverName1");
			JSONObject json = new JSONObject();
			json.put("serverId","12");
			json.put("serverName","serverName12");
			result  = json.toString();
		}
		catch(Exception ex){
			result = "error";
		}
		return ok(result);
	}	
	
	public static Result getCharacterAPI(String accountName,String gameCode,String serverId,String platform){
		String str = "";
		String url = Play.application().configuration().getString("apiCharacter.url").toString();
		Promise<WS.Response> result = WS.url(url)				
				.setQueryParameter("Auth", accountName)
				//.setQueryParameter("gameCode",gameCode )
				//.setQueryParameter("serverId",serverId )
				//.setQueryParameter("platform", platform)
				.get();
		str = result.get().getBody().toString();
		return ok ("done: "+str);
	}
}
