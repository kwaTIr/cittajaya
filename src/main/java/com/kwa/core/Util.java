/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

/**
 *
 * @author ibung
 */
public class Util {

    public static boolean isNullOrSpaces(String str) {
        if (str == null) {
            return true;
        }
        if (str.trim().equalsIgnoreCase("")) {
            return true;
        }

        return false;
    }

    public static Date strToDate(String str, String strFormat) {
        try {
            Locale fmtLocale = Locale.getDefault();
            return new SimpleDateFormat(strFormat, fmtLocale).parse(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static String dateToStr(Date dt, String strFormat){
        return new SimpleDateFormat(strFormat).format(dt);

    }
    
    public static boolean isDateValid(String str, String strFormat) {
        if (isNullOrSpaces(str)) {
            return false;
        }

        if (strToDate(str, strFormat) == null) {
            return false;
        }
        return true;


    }

    public static ArrayList extractDisc(String str) {
        if (isNullOrSpaces(str)) {
            return null;
        }


        try {
            String strtmp = str.replace(",", ".");
            //System.out.println(str);
            String[] strDisc = strtmp.split("[+]");
            ArrayList valDisc = new ArrayList();
            for (int i = 0; i < strDisc.length; i++) {
                valDisc.add(Double.parseDouble(strDisc[i].trim()));
            }

            return valDisc;
        } catch (Exception e) {
            return null;
        }

    }
}
