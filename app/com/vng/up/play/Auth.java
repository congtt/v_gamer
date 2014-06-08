/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.up.play;

import com.twmacinta.util.MD5;
import com.vng.sso.session.SessionResult;
import com.vng.sso.session.SessionServiceRead;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
 * @author congtt
 */
public class Auth {

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

    public Auth() {
    }

    public Auth(String host,int port,String privateKey,String vngauth,String sign,String ip,String ts) {
        this.host = host;
        Auth.privateKey = privateKey;
        this.vngauth = vngauth;
        this.sign = sign;
        this.ip= ip;
        this.ts = ts;
    }

    public String GetAuth() {
        try {
            Context context = new InitialContext();
            host = this.host;
            port = (int) this.port;
            privateKey = Auth.privateKey;

            vngauth = this.vngauth;
            sign = this.sign;
            ts = this.ts;
            
            String checksum = signGenerate(privateKey, ts, vngauth);
            sign = checksum;// debug checksum
            obj.clear();

            if (null == sign || !checksum.equals(sign) || null == vngauth) {
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

        } catch (TException | NullPointerException | NamingException ex) {
            if (transport.isOpen()) {
                transport.close();
            }
            obj.put("err_code", -2);
            obj.put("err_msg", ex.getMessage());
            out.println(obj.toString());
            
            //Logger.getLogger(auth.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj.toJSONString();
    }

    protected String signGenerate(String privateKey, String ts, String vngauth) {
        MD5 md5 = new MD5();
        md5.Update(privateKey + ts + vngauth);
        return md5.asHex();
    }
}
