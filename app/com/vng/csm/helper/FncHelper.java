package com.vng.csm.helper;

public class FncHelper {

    public static String ymdToVNDate(String ymd) {
        String vnDate = "";
        String ch = "/";
        vnDate = ymd.substring(6, 8) + ch + ymd.substring(4, 6) + ch + ymd.substring(0, 4);
        return vnDate;
    }

    public static String ymdToVNDate(int ymd) {
        String vnDate = "";
        String ch = "/";
        String strYmd = String.valueOf(ymd);
        return ymdToVNDate(strYmd);
    }

    public static String ymdToDate(String ymd) {
        String vnDate = "";
        String ch = "/";
        vnDate = ymd.substring(0, 4) + ch + ymd.substring(4, 6) + ch + ymd.substring(6, 8);
        return vnDate;
    }

    public static String ymdToDate(int ymd) {
        String vnDate = "";
        String strYmd = String.valueOf(ymd);
        return ymdToDate(strYmd);
    }
    
    
}
