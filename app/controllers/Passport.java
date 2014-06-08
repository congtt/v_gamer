/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import com.vng.up.play.Auth;
import play.mvc.Controller;
import play.mvc.Result;

/**
 *
 * @author congtt
 */
public class Passport extends Controller{
    
     public static Result test(String host,String port,String privateKey,String vngauth,String sign,String ip,String ts) {
         
         Auth auth = new Auth(host, Integer.valueOf(port), privateKey, vngauth, sign, ip, ts);
         String strDebug = "Param Call: ";
         strDebug+="\nhost= "+host;
         strDebug+="\nport= "+port;
         strDebug+="\nprivateKey= "+privateKey;
         strDebug+="\nvngauth= "+vngauth;
         strDebug+="\nsign= "+sign;
         strDebug+="\nip= "+ip;
         strDebug+="\nts= "+ts;
         strDebug+="\nresult:  ";
         strDebug+= auth.GetAuth();               
         return ok(strDebug);         
         
     }
}
