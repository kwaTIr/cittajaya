package com.kwa.cittajaya;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            T010 t010 = new T010("TMRK","ANDO1","test");
            T010JpaController t010p = new T010JpaController(null,null);
            t010p.initTrx();
            t010p.create(t010);
            System.out.println(t010p.getPmesg().getMesg());
            t010p.commitTrx();
                        t010p.getEm().close();
            t010p.getEmf().close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
