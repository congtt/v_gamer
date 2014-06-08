/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.up.servlet;

import com.twmacinta.util.MD5;
import com.vng.sso.session.SessionResult;
import com.vng.sso.session.SessionServiceRead;
import java.io.IOException;
import java.io.PrintWriter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.json.simple.JSONObject;

/**
 *
 * @author tungdq
 */
public class auth extends HttpServlet {

    //protected static String privateKey = "Ax@f36$%723g+23df=!kp";
    //protected String host = "10.30.12.183"; //dev
    //protected String host = "10.30.8.202"; //real
    //protected int port = 9090;
    protected static String privateKey;
    protected String host;
    protected int port;
    protected TSocket socket;
    protected TTransport transport;
    protected TProtocol protocol;
    protected SessionServiceRead.Client client;
    public JSONObject obj = new JSONObject();
    public String vngauth;
    public String sign;
    public String ip;
    public String ts;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            Context context = new InitialContext();
            host = (String) context.lookup("pp_host");
            port = (int) context.lookup("pp_port");
            privateKey = (String) context.lookup("pp_privatekey");
            
            vngauth = request.getParameter("s");
            sign = request.getParameter("sign");
            ts = request.getParameter("ts");
            
            String checksum = signGenerate(privateKey, ts, vngauth);
            obj.clear();
            
            if (null == sign || !checksum.equals(sign) || null==vngauth) {
                obj.put("err_code", -1);
                obj.put("err_msg", "Sign not match");
                out.println(obj.toString());
            } else {
                socket = new TSocket(host, port);
                transport = new TFramedTransport(socket);
                protocol = new TBinaryProtocol(transport);

                transport.open();
                client = new SessionServiceRead.Client(protocol);
                SessionResult result = client.GetSession(vngauth);

                if (0 != result.resultCode || "".equals(result.session.accountName)) {
                    obj.put("err_code", -1);
                    obj.put("err_msg", "Session expired");
                    out.println(obj.toString());
                } else {
                    obj.put("err_code", 0);
                    obj.put("err_msg", "Session good");
                    obj.put("accountName", result.session.accountName);
                    obj.put("hostname", result.session.hostname);
                    obj.put("createTime", result.session.createTime);
                    obj.put("lastAccess", result.session.lastAccess);
                    obj.put("useragent", result.session.useragent);
                    out.println(obj.toString());
                }
                transport.close();
            }

        } catch (TException|NullPointerException|NamingException ex) {
            if (transport.isOpen()) {
                transport.close();
            }
            obj.put("err_code", -2);
            obj.put("err_msg", ex.getMessage());
            out.println(obj.toString());
            //Logger.getLogger(auth.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
         try {
         vngauth = request.getParameter("s");
         vngauth = URLDecoder.decode(vngauth);
            
         ip = request.getRemoteAddr();
            
         String jsonStr = authManager.getInstance().getSession(vngauth);
         out.println(jsonStr);
            
         if (ip.contains("127.")) {
         String jsonStr = authManager.getInstance().getSession(vngauth);
         //jsonStr = authManager.getInstance().getTest();
         out.println(jsonStr);
         } else {
         obj.put("err_code", -1);
         obj.put("err_msg", "Access denied");
         out.println(obj.toString());
         }
         } catch (Exception ex) {
         obj.put("err_code", -2);
         obj.put("err_msg", ex.getMessage());
         out.println(obj.toString());
         }
         */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            obj.put("err_code", -1);
            obj.put("err_msg", "Error");
            out.println(obj.toString());
        } catch (Exception ex) {
            obj.put("err_code", -2);
            obj.put("err_msg", ex.getMessage());
            out.println(obj.toString());
        }
    }

    @Override
    public String getServletInfo() {
        return "Authenticate SSO session";
    }
    
    protected String signGenerate(String privateKey, String ts, String vngauth) {
        MD5 md5 = new MD5();
        md5.Update(privateKey + ts + vngauth);
        return md5.asHex();
    }
}
