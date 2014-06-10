package api;

import java.util.HashMap;

import play.libs.F.Function;
import play.libs.F.Promise;
import play.libs.WS;
import play.mvc.*;

public class ApiHelper {
	
	public static String getCharacterName(HashMap<String,String> param){
		
		String url = "http://localhost:9000/gamer/testapi/getCharacter";
		
		Promise<WS.Response> result = WS.url(url)				
				.setQueryParameter("server_id", param.get("serverId"))
				.setQueryParameter("server_name", param.get("serverName"))
				.get();
		
		return result.get().getBody().toString();
		
		//Promise<WS.Response> result = WS.url("http://localhost:9001").post("content");
		
		/*
		WS.url("http://localhost:9001")
			.setQueryParameter("param1", "foo")
			.setQueryParameter("param2", "bar")
			.post("content");
		*/
		//return result.toString();
//		return async(
//		        WS.url(url).get().map(
//			    new Function<WS.Response, Result>() {
//			        public Result apply(WS.Response response) {
//			            return  response.getBody().toString();
//			        }
//			    }
//			)
//		    );
		
		
	} 
}
