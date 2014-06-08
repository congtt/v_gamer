/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author congtt
 */
public class Helper {

    public static List<HashMap<String,String>> ResultSetToHashMap(ResultSet rs) {

        List<HashMap<String,String>> rows = new ArrayList<>();
        try {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            while (rs.next()) {
                HashMap row = new HashMap();
                for (int i = 1; i <= columns; i++) {
                    row.put(md.getColumnName(i), rs.getObject(i));
                }
                rows.add(row);
            }
        } catch (Exception ex) {
             Helper.debug("Helper class: ", ex.getMessage());
        }
        return rows;

    }
    
  
    public static void debug(String title, String value){
        System.out.println("=================== debug =====================");
        System.out.println(title+ ": "+value);
        System.out.println("=================== debug =====================");
    }
}
