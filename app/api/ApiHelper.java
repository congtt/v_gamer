package api;

import java.util.HashMap;

import play.Play;
import play.libs.F.Function;
import play.libs.F.Promise;
import play.libs.WS;
import play.mvc.*;
import play.Logger;
public class ApiHelper {

	public static String getCharacterName(HashMap<String, String> param) {

		String url = "http://localhost:9000/gamer/testapi/getCharacter";

		Promise<WS.Response> result = WS.url(url).setQueryParameter("server_id", param.get("serverId")).setQueryParameter("server_name", param.get("serverName")).get();

		return result.get().getBody().toString();

		// Promise<WS.Response> result =
		// WS.url("http://localhost:9001").post("content");

		/*
		 * WS.url("http://localhost:9001") .setQueryParameter("param1", "foo")
		 * .setQueryParameter("param2", "bar") .post("content");
		 */
		// return result.toString();
		// return async(
		// WS.url(url).get().map(
		// new Function<WS.Response, Result>() {
		// public Result apply(WS.Response response) {
		// return response.getBody().toString();
		// }
		// }
		// )
		// );

	}

	public static String getServerList(HashMap<String, String> paramCall) {
		if (Play.application().configuration().getString("is_dev").equals("1")) {
			String strTest = "{\"0\":1,\"1\":[{\"server_id\":\"gamo\",\"serverId\":\"gamo\",\"zoneName\":\"GĂ  Má»\",\"zone_name\":\"GĂ  Má»\",\"server_name\":\"GĂ  Má»\",\"serverName\":\"GĂ  Má»\",\"serverIp\":\"10.30.37.27\",\"site_id\":\"01\",\"port\":\"01\",\"active\":1},{\"server_id\":\"gacon\",\"serverId\":\"gacon\",\"zoneName\":\"GĂ  Con\",\"zone_name\":\"GĂ  Con\",\"server_name\":\"GĂ  Con\",\"serverName\":\"GĂ  Con\",\"serverIp\":\"10.30.37.28\",\"site_id\":\"02\",\"port\":\"02\",\"active\":1},{\"server_id\":\"gachoi\",\"serverId\":\"gachoi\",\"zoneName\":\"GĂ  Chá»i\",\"zone_name\":\"GĂ  Chá»i\",\"server_name\":\"GĂ  Chá»i\",\"serverName\":\"GĂ  Chá»i\",\"serverIp\":\"10.30.37.29\",\"site_id\":\"03\",\"port\":\"03\",\"active\":1},{\"server_id\":\"gavuon\",\"serverId\":\"gavuon\",\"zoneName\":\"GĂ  VÆ°á»n & BĂ©o\",\"zone_name\":\"GĂ  VÆ°á»n & BĂ©o\",\"server_name\":\"GĂ  VÆ°á»n & BĂ©o\",\"serverName\":\"GĂ  VÆ°á»n & BĂ©o\",\"serverIp\":\"10.30.37.39\",\"site_id\":\"04\",\"port\":\"04\",\"active\":1},{\"server_id\":\"gachip\",\"serverId\":\"gachip\",\"zoneName\":\"GĂ  Chip & Chiáº¿n\",\"zone_name\":\"GĂ  Chip & Chiáº¿n\",\"server_name\":\"GĂ  Chip & Chiáº¿n\",\"serverName\":\"GĂ  Chip & Chiáº¿n\",\"serverIp\":\"10.30.37.47\",\"site_id\":\"06\",\"port\":\"06\",\"active\":1},{\"server_id\":\"garung\",\"serverId\":\"garung\",\"zoneName\":\"GĂ  Rá»«ng\",\"zone_name\":\"GĂ  Rá»«ng\",\"server_name\":\"GĂ  Rá»«ng\",\"serverName\":\"GĂ  Rá»«ng\",\"serverIp\":\"10.30.37.51\",\"site_id\":\"07\",\"port\":\"07\",\"active\":1},{\"server_id\":\"gatre\",\"serverId\":\"gatre\",\"zoneName\":\"GĂ  Tre & Ta\",\"zone_name\":\"GĂ  Tre & Ta\",\"server_name\":\"GĂ  Tre & Ta\",\"serverName\":\"GĂ  Tre & Ta\",\"serverIp\":\"10.30.37.59\",\"site_id\":\"09\",\"port\":\"09\",\"active\":1},{\"server_id\":\"gagay\",\"serverId\":\"gagay\",\"zoneName\":\"GĂ  GĂ¡y & TĂ¢y\",\"zone_name\":\"GĂ  GĂ¡y & TĂ¢y\",\"server_name\":\"GĂ  GĂ¡y & TĂ¢y\",\"serverName\":\"GĂ  GĂ¡y & TĂ¢y\",\"serverIp\":\"10.30.37.66\",\"site_id\":\"10\",\"port\":\"10\",\"active\":1},{\"server_id\":\"gaac\",\"serverId\":\"gaac\",\"zoneName\":\"GĂ  Ăc\",\"zone_name\":\"GĂ  Ăc\",\"server_name\":\"GĂ  Ăc\",\"serverName\":\"GĂ  Ăc\",\"serverIp\":\"10.30.37.70\",\"site_id\":\"11\",\"port\":\"11\",\"active\":1},{\"server_id\":\"galua\",\"serverId\":\"galua\",\"zoneName\":\"GĂ  Lá»­a & Sao\",\"zone_name\":\"GĂ  Lá»­a & Sao\",\"server_name\":\"GĂ  Lá»­a & Sao\",\"serverName\":\"GĂ  Lá»­a & Sao\",\"serverIp\":\"10.30.37.84\",\"site_id\":\"15\",\"port\":\"15\",\"active\":1},{\"server_id\":\"gachinhphuc\",\"serverId\":\"gachinhphuc\",\"zoneName\":\"GĂ  Chinh Phá»¥c\",\"zone_name\":\"GĂ  Chinh Phá»¥c\",\"server_name\":\"GĂ  Chinh Phá»¥c\",\"serverName\":\"GĂ  Chinh Phá»¥c\",\"serverIp\":\"10.30.37.90\",\"site_id\":\"17\",\"port\":\"17\",\"active\":1},{\"server_id\":\"gatia\",\"serverId\":\"gatia\",\"zoneName\":\"GĂ  TĂ­a & GĂ´\",\"zone_name\":\"GĂ  TĂ­a & GĂ´\",\"server_name\":\"GĂ  TĂ­a & GĂ´\",\"serverName\":\"GĂ  TĂ­a & GĂ´\",\"serverIp\":\"10.30.37.103\",\"site_id\":\"20\",\"port\":\"20\",\"active\":1},{\"server_id\":\"gavip\",\"serverId\":\"gavip\",\"zoneName\":\"GĂ  Vip & Tuyáº¿t\",\"zone_name\":\"GĂ  Vip & Tuyáº¿t\",\"server_name\":\"GĂ  Vip & Tuyáº¿t\",\"serverName\":\"GĂ  Vip & Tuyáº¿t\",\"serverIp\":\"10.30.37.112\",\"site_id\":\"23\",\"port\":\"23\",\"active\":1},{\"server_id\":\"gateen\",\"serverId\":\"gateen\",\"zoneName\":\"GĂ  Teen & VĂ ng\",\"zone_name\":\"GĂ  Teen & VĂ ng\",\"server_name\":\"GĂ  Teen & VĂ ng\",\"serverName\":\"GĂ  Teen & VĂ ng\",\"serverIp\":\"10.30.37.115\",\"site_id\":\"24\",\"port\":\"24\",\"active\":1},{\"server_id\":\"gabay\",\"serverId\":\"gabay\",\"zoneName\":\"GĂ  Bay & Boss\",\"zone_name\":\"GĂ  Bay & Boss\",\"server_name\":\"GĂ  Bay & Boss\",\"serverName\":\"GĂ  Bay & Boss\",\"serverIp\":\"10.30.37.124\",\"site_id\":\"27\",\"port\":\"27\",\"active\":1},{\"server_id\":\"ganoi\",\"serverId\":\"ganoi\",\"zoneName\":\"GĂ  NĂ²i & Kool\",\"zone_name\":\"GĂ  NĂ²i & Kool\",\"server_name\":\"GĂ  NĂ²i & Kool\",\"serverName\":\"GĂ  NĂ²i & Kool\",\"serverIp\":\"10.30.37.133\",\"site_id\":\"30\",\"port\":\"30\",\"active\":1},{\"server_id\":\"gahaitac\",\"serverId\":\"gahaitac\",\"zoneName\":\"GĂ  Háº£i Táº·c\",\"zone_name\":\"GĂ  Háº£i Táº·c\",\"server_name\":\"GĂ  Háº£i Táº·c\",\"serverName\":\"GĂ  Háº£i Táº·c\",\"serverIp\":\"10.30.37.93\",\"site_id\":\"32\",\"port\":\"32\",\"active\":1},{\"server_id\":\"gabaccuc\",\"serverId\":\"gabaccuc\",\"zoneName\":\"GĂ  Báº¯c Cá»±c\",\"zone_name\":\"GĂ  Báº¯c Cá»±c\",\"server_name\":\"GĂ  Báº¯c Cá»±c\",\"serverName\":\"GĂ  Báº¯c Cá»±c\",\"serverIp\":\"10.30.37.148\",\"site_id\":\"38\",\"port\":\"38\",\"active\":1},{\"server_id\":\"gahuyenthoai\",\"serverId\":\"gahuyenthoai\",\"zoneName\":\"GĂ  Huyá»n Thoáº¡i\",\"zone_name\":\"GĂ  Huyá»n Thoáº¡i\",\"server_name\":\"GĂ  Huyá»n Thoáº¡i\",\"serverName\":\"GĂ  Huyá»n Thoáº¡i\",\"serverIp\":\"10.30.37.106\",\"site_id\":\"41\",\"port\":\"41\",\"active\":1},{\"server_id\":\"gadua\",\"serverId\":\"gadua\",\"zoneName\":\"GĂ  Äua & School\",\"zone_name\":\"GĂ  Äua & School\",\"server_name\":\"GĂ  Äua & School\",\"serverName\":\"GĂ  Äua & School\",\"serverIp\":\"10.30.37.118\",\"site_id\":\"43\",\"port\":\"43\",\"active\":1},{\"server_id\":\"gala\",\"serverId\":\"gala\",\"zoneName\":\"GĂ  LĂ¡ & Ngon\",\"zone_name\":\"GĂ  LĂ¡ & Ngon\",\"server_name\":\"GĂ  LĂ¡ & Ngon\",\"serverName\":\"GĂ  LĂ¡ & Ngon\",\"serverIp\":\"10.30.37.154\",\"site_id\":\"44\",\"port\":\"44\",\"active\":1},{\"server_id\":\"gathan\",\"serverId\":\"gathan\",\"zoneName\":\"GĂ  Tháº§n & TÆ°á»›ng\",\"zone_name\":\"GĂ  Tháº§n & TÆ°á»›ng\",\"server_name\":\"GĂ  Tháº§n & TÆ°á»›ng\",\"serverName\":\"GĂ  Tháº§n & TÆ°á»›ng\",\"serverIp\":\"10.30.37.157\",\"site_id\":\"45\",\"port\":\"45\",\"active\":1},{\"server_id\":\"garong\",\"serverId\":\"garong\",\"zoneName\":\"GĂ  Rá»“ng\",\"zone_name\":\"GĂ  Rá»“ng\",\"server_name\":\"GĂ  Rá»“ng\",\"serverName\":\"GĂ  Rá»“ng\",\"serverIp\":\"10.30.37.33\",\"site_id\":\"51\",\"port\":\"51\",\"active\":1},{\"server_id\":\"gaviet\",\"serverId\":\"gaviet\",\"zoneName\":\"GĂ  Viá»‡t\",\"zone_name\":\"GĂ  Viá»‡t\",\"server_name\":\"GĂ  Viá»‡t\",\"serverName\":\"GĂ  Viá»‡t\",\"serverIp\":\"10.30.37.136\",\"site_id\":\"53\",\"port\":\"53\",\"active\":1},{\"server_id\":\"gahiepkhach\",\"serverId\":\"gahiepkhach\",\"zoneName\":\"GĂ  Hiá»‡p KhĂ¡ch\",\"zone_name\":\"GĂ  Hiá»‡p KhĂ¡ch\",\"server_name\":\"GĂ  Hiá»‡p KhĂ¡ch\",\"serverName\":\"GĂ  Hiá»‡p KhĂ¡ch\",\"serverIp\":\"10.30.37.109\",\"site_id\":\"09\",\"port\":\"09\",\"active\":1},{\"server_id\":\"gacaothu\",\"serverId\":\"gacaothu\",\"zoneName\":\"GĂ  Cao Thá»§\",\"zone_name\":\"GĂ  Cao Thá»§\",\"server_name\":\"GĂ  Cao Thá»§\",\"serverName\":\"GĂ  Cao Thá»§\",\"serverIp\":\"10.30.37.160\",\"site_id\":\"59\",\"port\":\"59\",\"active\":1},{\"server_id\":\"gahiepsi\",\"serverId\":\"gahiepsi\",\"zoneName\":\"GĂ  Hiá»‡p SÄ©\",\"zone_name\":\"GĂ  Hiá»‡p SÄ©\",\"server_name\":\"GĂ  Hiá»‡p SÄ©\",\"serverName\":\"GĂ  Hiá»‡p SÄ©\",\"serverIp\":\"10.30.37.178\",\"site_id\":\"69\",\"port\":\"69\",\"active\":1},{\"server_id\":\"gavuinhon\",\"serverId\":\"gavuinhon\",\"zoneName\":\"GĂ  Vui Nhá»™n\",\"zone_name\":\"GĂ  Vui Nhá»™n\",\"server_name\":\"GĂ  Vui Nhá»™n\",\"serverName\":\"GĂ  Vui Nhá»™n\",\"serverIp\":\"10.30.37.127\",\"site_id\":\"76\",\"port\":\"76\",\"active\":1},{\"server_id\":\"gasatlong\",\"serverId\":\"gasatlong\",\"zoneName\":\"GĂ  SĂ¡t Long\",\"zone_name\":\"GĂ  SĂ¡t Long\",\"server_name\":\"GĂ  SĂ¡t Long\",\"serverName\":\"GĂ  SĂ¡t Long\",\"serverIp\":\"10.30.37.190\",\"site_id\":\"78\",\"port\":\"78\",\"active\":1},{\"server_id\":\"gadungmanh\",\"serverId\":\"gadungmanh\",\"zoneName\":\"GĂ  DÅ©ng MĂ£nh\",\"zone_name\":\"GĂ  DÅ©ng MĂ£nh\",\"server_name\":\"GĂ  DÅ©ng MĂ£nh\",\"serverName\":\"GĂ  DÅ©ng MĂ£nh\",\"serverIp\":\"10.30.37.196\",\"site_id\":\"81\",\"port\":\"81\",\"active\":1},{\"server_id\":\"gasieucap\",\"serverId\":\"gasieucap\",\"zoneName\":\"GĂ  SiĂªu Cáº¥p\",\"zone_name\":\"GĂ  SiĂªu Cáº¥p\",\"server_name\":\"GĂ  SiĂªu Cáº¥p\",\"serverName\":\"GĂ  SiĂªu Cáº¥p\",\"serverIp\":\"10.30.37.43\",\"site_id\":\"82\",\"port\":\"82\",\"active\":1},{\"server_id\":\"gasieuquay\",\"serverId\":\"gasieuquay\",\"zoneName\":\"GĂ  SiĂªu Quáº­y\",\"zone_name\":\"GĂ  SiĂªu Quáº­y\",\"server_name\":\"GĂ  SiĂªu Quáº­y\",\"serverName\":\"GĂ  SiĂªu Quáº­y\",\"serverIp\":\"10.30.37.148\",\"site_id\":\"38\",\"port\":\"38\",\"active\":1},{\"server_id\":\"gadenhat\",\"serverId\":\"gadenhat\",\"zoneName\":\"GĂ  Äá»‡ Nháº¥t\",\"zone_name\":\"GĂ  Äá»‡ Nháº¥t\",\"server_name\":\"GĂ  Äá»‡ Nháº¥t\",\"serverName\":\"GĂ  Äá»‡ Nháº¥t\",\"serverIp\":\"10.30.37.121\",\"site_id\":\"91\",\"port\":\"91\",\"active\":1},{\"server_id\":\"gacuonglong\",\"serverId\":\"gacuonglong\",\"zoneName\":\"GĂ  Cuá»“ng Long\",\"zone_name\":\"GĂ  Cuá»“ng Long\",\"server_name\":\"GĂ  Cuá»“ng Long\",\"serverName\":\"GĂ  Cuá»“ng Long\",\"serverIp\":\"10.30.37.151\",\"site_id\":\"92\",\"port\":\"92\",\"active\":1},{\"server_id\":\"gasuthi\",\"serverId\":\"gasuthi\",\"zoneName\":\"GĂ  Sá»­ Thi\",\"zone_name\":\"GĂ  Sá»­ Thi\",\"server_name\":\"GĂ  Sá»­ Thi\",\"serverName\":\"GĂ  Sá»­ Thi\",\"serverIp\":\"10.30.37.193\",\"site_id\":\"92\",\"port\":\"92\",\"active\":1},{\"server_id\":\"gathulinh\",\"serverId\":\"gathulinh\",\"zoneName\":\"GĂ  Thá»§ LÄ©nh\",\"zone_name\":\"GĂ  Thá»§ LÄ©nh\",\"server_name\":\"GĂ  Thá»§ LÄ©nh\",\"serverName\":\"GĂ  Thá»§ LÄ©nh\",\"serverIp\":\"10.30.37.205\",\"site_id\":\"92\",\"port\":\"92\",\"active\":1},{\"server_id\":\"gachaua\",\"serverId\":\"gachaua\",\"zoneName\":\"GĂ  ChĂ¢u Ă\",\"zone_name\":\"GĂ  ChĂ¢u Ă\",\"server_name\":\"GĂ  ChĂ¢u Ă\",\"serverName\":\"GĂ  ChĂ¢u Ă\",\"serverIp\":\"10.30.37.31\",\"site_id\":\"96\",\"port\":\"96\",\"active\":1},{\"server_id\":\"gakhaihoan\",\"serverId\":\"gakhaihoan\",\"zoneName\":\"GĂ  Kháº£i HoĂ n\",\"zone_name\":\"GĂ  Kháº£i HoĂ n\",\"server_name\":\"GĂ  Kháº£i HoĂ n\",\"serverName\":\"GĂ  Kháº£i HoĂ n\",\"serverIp\":\"10.30.37.166\",\"site_id\":\"97\",\"port\":\"97\",\"active\":1},{\"server_id\":\"gachienthan\",\"serverId\":\"gachienthan\",\"zoneName\":\"GĂ  Chiáº¿n Tháº§n\",\"zone_name\":\"GĂ  Chiáº¿n Tháº§n\",\"server_name\":\"GĂ  Chiáº¿n Tháº§n\",\"serverName\":\"GĂ  Chiáº¿n Tháº§n\",\"serverIp\":\"10.30.37.169\",\"site_id\":\"99\",\"port\":\"99\",\"active\":1},{\"server_id\":\"gatailoc\",\"serverId\":\"gatailoc\",\"zoneName\":\"GĂ  TĂ i Lá»™c\",\"zone_name\":\"GĂ  TĂ i Lá»™c\",\"server_name\":\"GĂ  TĂ i Lá»™c\",\"serverName\":\"GĂ  TĂ i Lá»™c\",\"serverIp\":\"10.30.37.142\",\"site_id\":\"103\",\"port\":\"103\",\"active\":1},{\"server_id\":\"gaso1\",\"serverId\":\"gaso1\",\"zoneName\":\"GĂ  Sá»‘ 1\",\"zone_name\":\"GĂ  Sá»‘ 1\",\"server_name\":\"GĂ  Sá»‘ 1\",\"serverName\":\"GĂ  Sá»‘ 1\",\"serverIp\":\"10.30.37.163\",\"site_id\":\"104\",\"port\":\"104\",\"active\":1},{\"server_id\":\"gathienxa\",\"serverId\":\"gathienxa\",\"zoneName\":\"GĂ  Thiá»‡n Xáº¡\",\"zone_name\":\"GĂ  Thiá»‡n Xáº¡\",\"server_name\":\"GĂ  Thiá»‡n Xáº¡\",\"serverName\":\"GĂ  Thiá»‡n Xáº¡\",\"serverIp\":\"10.30.37.202\",\"site_id\":\"105\",\"port\":\"105\",\"active\":1},{\"server_id\":\"gathienxa2\",\"serverId\":\"gathienxa2\",\"zoneName\":\"GĂ  Thiá»‡n Xáº¡ 2\",\"zone_name\":\"GĂ  Thiá»‡n Xáº¡ 2\",\"server_name\":\"GĂ  Thiá»‡n Xáº¡ 2\",\"serverName\":\"GĂ  Thiá»‡n Xáº¡ 2\",\"serverIp\":\"10.30.37.109\",\"site_id\":\"106\",\"port\":\"106\",\"active\":1},{\"server_id\":\"gathienxa3\",\"serverId\":\"gathienxa3\",\"zoneName\":\"GĂ  Thiá»‡n Xáº¡ 3\",\"zone_name\":\"GĂ  Thiá»‡n Xáº¡ 3\",\"server_name\":\"GĂ  Thiá»‡n Xáº¡ 3\",\"serverName\":\"GĂ  Thiá»‡n Xáº¡ 3\",\"serverIp\":\"10.30.37.87\",\"site_id\":\"107\",\"port\":\"107\",\"active\":1},{\"server_id\":\"gathienxa4\",\"serverId\":\"gathienxa4\",\"zoneName\":\"GĂ  Thiá»‡n Xáº¡ 4\",\"zone_name\":\"GĂ  Thiá»‡n Xáº¡ 4\",\"server_name\":\"GĂ  Thiá»‡n Xáº¡ 4\",\"serverName\":\"GĂ  Thiá»‡n Xáº¡ 4\",\"serverIp\":\"10.30.37.199\",\"site_id\":\"108\",\"port\":\"108\",\"active\":1},{\"server_id\":\"gaphaluoi\",\"serverId\":\"gaphaluoi\",\"zoneName\":\"GĂ  PhĂ¡ LÆ°á»›i\",\"zone_name\":\"GĂ  PhĂ¡ LÆ°á»›i\",\"server_name\":\"GĂ  PhĂ¡ LÆ°á»›i\",\"serverName\":\"GĂ  PhĂ¡ LÆ°á»›i\",\"serverIp\":\"10.30.37.130\",\"site_id\":\"109\",\"port\":\"109\",\"active\":1},{\"server_id\":\"gachiuchoi\",\"serverId\":\"gachiuchoi\",\"zoneName\":\"GĂ  Chá»‹u ChÆ¡i\",\"zone_name\":\"GĂ  Chá»‹u ChÆ¡i\",\"server_name\":\"GĂ  Chá»‹u ChÆ¡i\",\"serverName\":\"GĂ  Chá»‹u ChÆ¡i\",\"serverIp\":\"10.30.37.181\",\"site_id\":\"110\",\"port\":\"110\",\"active\":1},{\"server_id\":\"gasoidong\",\"serverId\":\"gasoidong\",\"zoneName\":\"GĂ  SĂ´i Äá»™ng\",\"zone_name\":\"GĂ  SĂ´i Äá»™ng\",\"server_name\":\"GĂ  SĂ´i Äá»™ng\",\"serverName\":\"GĂ  SĂ´i Äá»™ng\",\"serverIp\":\"10.30.37.187\",\"site_id\":\"111\",\"port\":\"111\",\"active\":1}]}";
			return strTest;
		} else {
			String result = "";
			String url = Play.application().configuration().getString("api.vbonus.getServerList.url").toString();
			int i = 0;

			for (String key : paramCall.keySet()) {
				if (i > 0) {
					url += "&";
				}
				url += key + "=" + paramCall.get(key);
				i++;
			}
			try {
				Promise<WS.Response> re = WS.url(url).get();
				result = re.get().getBody().toString();
			} catch (Exception ex) {
			}
			return result;
		}
	}
	
	public static String getCharacterList(HashMap<String, String> paramCall) {
		if (Play.application().configuration().getString("is_dev").equals("1")) {
			String strTest = "{\"0\":1,\"1\":[{\"accountName\":\"dongtanpro113\",\"level\":\"112\",\"characterName\":\"wrtGw5/Dr8Kjw5Zow6vDlnF1w6XCpcKr\",\"registerDate\":\"2013-10-18 21:28:36\",\"pointActive\":\"10\",\"guild\":\"0\"}]}";
			return strTest;
		} else {
			String result = "";
			String url = Play.application().configuration().getString("api.vbonus.getCharater.url").toString();
			int i = 0;
			for (String key : paramCall.keySet()) {
				if (i > 0) {
					url += "&";
				}
				url += key + "=" + paramCall.get(key);
				i++;
			}
			Logger.info("call url : "+ url);
			try {
				Promise<WS.Response> re = WS.url(url).get();
				result = re.get().getBody().toString();
			} catch (Exception ex) {
			}
			return result;
		}
	}

}
