/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author ibung
 */
public class Util {
    public static boolean isNullOrSpaces(String str){
        if(str==null) return true;
        if(str.trim().equalsIgnoreCase("")) return true;
        
        return false;
    }
    
        public static Date strToDate(String str, String strFormat){
            try{
                return new SimpleDateFormat(strFormat, Locale.ENGLISH).parse(str);
            }   catch(Exception e){
                return null;
            }   
        }
        
        public static boolean isDateValid(String str, String strFormat){
            if(isNullOrSpaces(str)) return false;
            
            if(strToDate(str,strFormat)==null) return false;
            return true;
                
            
        }
    
}
