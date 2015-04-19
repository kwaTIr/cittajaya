package com.kwa.test;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class Diskon 
{
    public static void main( String[] args )
    {
                String sentence = "Define, Mea+sure, Analyze, Design and Verify";

        String str = sentence.replace("+", ".");
        String[] xx = sentence.split("[+]");
        System.out.println(xx[0]);
        
        String s = "1114.5";
        
        Double d = Double.parseDouble(s);
        
        System.out.println( "Hello World! " + d.toString() );
        
        

        str = "10+10,5+2000";

        try {
            String strtmp = str.replace(",", ".");
            //System.out.println(str);
            String[] strDisc = strtmp.split("[+]");
            ArrayList valDisc = new ArrayList();
            for (int i = 0; i < strDisc.length; i++) {
                valDisc.add(Double.parseDouble(strDisc[i].trim()));
            }

        } catch (Exception e) {
               e.printStackTrace();
        }
    }
}
