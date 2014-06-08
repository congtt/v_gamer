/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import java.util.HashMap;

//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
import play.Play;

/**
 *
 * @author congtt
 */
public class Config {

    public static HashMap<String, HashMap<String, String>> getConfig() {

        HashMap<String, HashMap<String, String>> config = new HashMap<String, HashMap<String, String>>();
        HashMap siteConfig = new HashMap<String, String>();
        siteConfig.put("siteUrl", Play.application().configuration().getString("site.siteUrl").toString());// have flash
//        HashMap dbConfig = new HashMap<String, String>();
//        dbConfig.put("db_host_name", "10.30.6.205");
//        dbConfig.put("db_host_instance", "");
//        dbConfig.put("db_user_name", "sugarcrm");
//        dbConfig.put("db_password", "123456");
//        dbConfig.put("db_name", "epmtt");
//        dbConfig.put("db_type", "mssql");
//        config.put("dbConfig", dbConfig);
        config.put("siteConfig", siteConfig);

        return config;

    }

}
