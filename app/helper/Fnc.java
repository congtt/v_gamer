/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.twmacinta.util.MD5;

import play.Play;
import com.vng.csm.helper.FncHelper;
/**
 *
 * @author congtt
 */
public class Fnc {
  
	
	public static String md5Vbonus(String value){
		return FncHelper.md5(("@grc#!vBonus2012"+FncHelper.md5(value)));		
	}
	public static boolean md5VbonusCheck(String value,String token){
		return FncHelper.md5(("@grc#!vBonus2012"+FncHelper.md5(value))).equals(token);			
	}
	public static String vBonusId(String memberId){
		return "13215456";
	}
	
	public static String vBonusIdDecode(String vBonusId){
		return "423";
	}
	
	public static String md5Sum(String value){
		String result = "";
		result = value+Play.application().configuration().getString("application.secret").toString()+value;
		result = com.vng.csm.helper.FncHelper.md5(result);
		return result;
	}
	
	public static boolean md5Check(String value,String token){
		String tokenCheck = md5Sum(value);
		if(tokenCheck.equals(token)){
			return true;
		}
		return false;
	}
	
    public static Map<String,String> ReadXmlFile(String fileName){
            
        Map<String,String> map = null;
        
        try{
        File fXmlFile = new File("D:\\VNG\\GSD\\01-Project\\00PLAY\\workspace\\gamer\\config\\config.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);
        helper.Helper.debug("xml str", doc.toString());
        
        map = convertNodesFromXml(doc.toString());
        }catch(Exception ex){
            helper.Helper.debug("xml error", ex.getMessage());
                    
        }
        return map;
    }
    public static Map<String, String> convertNodesFromXml(String xml) throws Exception {

        InputStream is = new ByteArrayInputStream(xml.getBytes());
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        org.w3c.dom.Document document = db.parse(is);
        return createMap(document.getDocumentElement());
    }

    public static Map<String, String> createMap(Node node) {
        Map<String, String> map = new HashMap<String, String>();
        NodeList nodeList = (NodeList) node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.hasAttributes()) {
                for (int j = 0; j < currentNode.getAttributes().getLength(); j++) {
                    Node item = currentNode.getAttributes().item(i);
                    map.put(item.getNodeName(), item.getTextContent());
                }
            }
            if (node.getFirstChild() != null && node.getFirstChild().getNodeType() == Node.ELEMENT_NODE) {
                map.putAll(createMap(currentNode));
            } else if (node.getFirstChild().getNodeType() == Node.TEXT_NODE) {
                map.put(node.getLocalName(), node.getTextContent());
            }
        }
        return map;
    }
    
    
    

}
