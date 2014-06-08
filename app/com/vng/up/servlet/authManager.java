/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.up.servlet;

import com.vng.sso.session.SessionResult;
import com.vng.sso.session.SessionServiceRead;
import java.util.HashMap;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.json.simple.JSONObject;

/**
 *
 * @author tungdq
 */
public class authManager {

    //protected String host = "10.30.12.183"; //dev
    //protected String host = "10.30.8.202"; //real
    //protected int port = 9090;
    protected String host;
    protected int port;
    protected TSocket socket;
    protected TTransport transport;
    protected TProtocol protocol;
    protected SessionServiceRead.Client client;
    private static authManager instance = null;
    private static final Object mutex = new Object();
    public JSONObject obj = new JSONObject();
    public InitialContext ic;

    private authManager() throws Exception {
        try {
            Context context = new InitialContext();
            
            //host = (String) context.lookup("JNDI_host");
            //port = (int) context.lookup("JNDI_port");
            //System.out.println(host);
            //System.out.println(port);
            
            //String host = "10.30.12.183";
            //int port = 9090;
            
            //socket = new TSocket(host, port);
            socket = new TSocket("10.30.12.183", 9090);
            transport = new TFramedTransport(socket);
            transport.open();
            protocol = new TBinaryProtocol(transport);
            client = new SessionServiceRead.Client(protocol);
        } catch (TTransportException ex) {
            throw new Exception(ex.getMessage());
        } finally {
            if (transport.isOpen()) transport.close();
        }
    }

    public static authManager getInstance() throws Exception {
        if (null == instance) {
            synchronized (mutex) {
                if (null == instance) {
                    instance = new authManager();
                }
            }
        }
        return instance;
    }

    protected String getSession(String vngauth) throws Exception {
        //System.out.println("getSession: " + vngauth);
        
        try {
            if (vngauth != null) {
                SessionResult result = client.GetSession(vngauth);
                if (result.resultCode != 0 || "".equals(result.session.accountName)) {
                    obj.put("err_code", -1);
                    obj.put("err_msg", "vngauth is expired or not existed");
                } else {
                    obj.put("err_code", 1);
                    obj.put("err_msg", "Session vngauth is good");

                    Map sessData = new HashMap();
                    sessData.put("accountName", result.session.accountName);
                    sessData.put("hostname", result.session.hostname);
                    sessData.put("createTime", result.session.createTime);
                    sessData.put("lastAccess", result.session.lastAccess);
                    sessData.put("useragent", result.session.useragent);
                    obj.put("data", sessData);
                }
            } else {
                obj.put("err_code", -1);
                obj.put("err_msg", "vngauth is invalid");
            }
            return obj.toString();
        } catch (TException ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    protected String getTest() {
        obj.put("err_code", 1);
        obj.put("err_msg", "Success");
        obj.put("data", "Hollli sheat");
        return obj.toString();
    }
}
