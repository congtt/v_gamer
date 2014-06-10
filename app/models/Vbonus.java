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
            menu = helper.Helper.ResultSetToHashMap(result);
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

    public static int register(int configId,String username,String memberId,String vbonusId,String serverId,String serverName,String characterName, int level, String firstLogin) {
//         CallableStatement cs = null;
//        Connection connection = null;
//        ResultSet result = null;
//        try {
//            connection = play.db.DB.getConnection();
//            cs = connection.prepareCall("{call usp_pmtt_fe_gamer_register_vbonus_v3 (?,?,?,?,?,?,?,?,?,?,?,?)}");
//            //$sSQL = "exec  ".(int)$config_id.",".(int)$memberid.",'".$member_account."','"
//           // .$register_date."',".(int)$vbonus_code.",'".$passport_id."',".$first_login.""
//            	//	+ "//,".$server_id.",".$server_name.",".$character_name.",".$level.",'".$multi_platform_gamecode."'";	//die($sSQL);			
//            cs.setInt(1, configId);
//            cs.setInt(1, memberId);            
//            cs.setString(2, username);
//            cs.setString(3, characterName);
//            cs.setInt(4, level);
//            cs.setInt(5, level);
//            cs.setString(6, serverId);
//            cs.setString(7, serverName);
//            cs.setInt(3, 1);
//            result = cs.executeQuery();
//            menu = helper.Helper.ResultSetToHashMap(result);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (cs != null) {
//                    cs.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//
//            } catch (SQLException ex) {
//                Logger.getLogger(Vbonus.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        return 1;
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
