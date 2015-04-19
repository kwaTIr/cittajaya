/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.test;

import com.kwa.core.KWAMesg;
import com.kwa.cj.modules.t010.T010;
import com.kwa.cj.modules.t010.T010JpaController;
import com.kwa.cj.modules.t010.T010PK;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author scumb46
 */
public class t010Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        KWAMesg mesg = new KWAMesg();
        T010 t010 = new T010(new T010PK("K1","T1"),"D1","A1");
        try {
            T010JpaController t010p = new T010JpaController(null,null);
            System.out.println(t010p.create(t010));
            
        } catch (Exception ex) {
            Logger.getLogger(t010Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
