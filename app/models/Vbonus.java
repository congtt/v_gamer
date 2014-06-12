/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.Login;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import scala.collection.generic.BitOperations.Int;

/**
 *
 * @author congtt
 */
public class Vbonus {

    private static String sql;

    public static HashMap<String, String> GetConfigInfo() {
        HashMap<String, String> configInfo = new HashMap<String, String>();
        configInfo.put("name", "Tên chương trình");
        configInfo.put("from_date", "10/11/1990");
        configInfo.put("to_date", "30/06/2014");
        configInfo.put("invite_from_date", "04/06/2014");
        configInfo.put("invite_to_date", "30/06/2014");
        configInfo.put("id", "37");
        return configInfo;
    }

    public static List<HashMap<String,String>> GetMenu() {
        List<HashMap<String,String>> menu = new ArrayList<>();
        CallableStatement cs = null;
        Connection connection = null;
        ResultSet result = null;
        try {
            connection = play.db.DB.getConnection();
            cs = connection.prepareCall("{call WINWIN.GRLV.dbo.usp_grlv_menu_root_v2 (?,?,?)}");
            cs.setInt(1, 2);
            cs.setString(2, Login.getUserInfoLogin().get("username"));
            cs.setInt(3, 1);
            result = cs.executeQuery();
            menu = helper.Helper.ResultSetToHashMapList(result);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Vbonus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return menu;
    }

    public static HashMap<String,String> register(int configId,String username,int memberId,int vbonusId,String serverId,String serverName,String characterName, int level, String firstLogin) {
         CallableStatement cs = null;
        Connection connection = null;
        ResultSet rs = null;
        HashMap<String,String> result = null;
        try {
        	
        	HashMap<String,String> userInfo = Login.getUserInfoLogin();
        	
            connection = play.db.DB.getConnection();
            cs = connection.prepareCall("{call usp_pmtt_fe_gamer_register_vbonus_v3 (?,?,?,?,?,?,?,?,?,?,?,?)}");
           // $sSQL = "exec usp_pmtt_fe_gamer_register_vbonus_v3 ".(int)$config_id."
            /*,".(int)$memberid.",'".$member_account."','".$register_date."'
            ,".(int)$vbonus_code.",'".$passport_id."',".$first_login.",".$server_id.",".$server_name."
            ,".$character_name.",".$level.",'".$multi_platform_gamecode."'";	//die($sSQL);*/
			String multiPlatform = "";            
            cs.setInt(1, configId);
            cs.setInt(2, memberId);            
            cs.setString(3, username);
            cs.setString(4,com.vng.csm.helper.DateHelper.vnDateToDate(userInfo.get("registerDate"),false)); 
            cs.setInt(5,vbonusId);
            cs.setString(6, userInfo.get("passportId"));
            cs.setString(7,com.vng.csm.helper.DateHelper.vnDateToDate(firstLogin,false));
            cs.setString(8,serverId);
            cs.setString(9,serverName);
            cs.setString(10,characterName);
            cs.setInt(11, level);
            cs.setString(12, multiPlatform);           
            rs = cs.executeQuery();
            System.out.println("result call sp register: "+ rs.toString());
            result = helper.Helper.ResultSetToHashMap(rs);
            System.out.println("result call sp register hm: "+ result.toString());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Vbonus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    public static void TestDB() {
        String sql = "select top 1 * from pmtt_member ";

        Connection conn = play.db.DB.getConnection();
        try {
            Statement stmt = conn.createStatement();
            try {
                boolean execute = stmt.execute(sql);
                if (execute) {
                    System.console().writer().print("sql connect thanh cong!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Vbonus.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Vbonus.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vbonus.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Vbonus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
