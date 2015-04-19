package com.kwa.cj.pegawai;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        try {
                        JFrame f = new JFrame();  
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            
            JPanel p = new VPegawai();
            //JPanel p = new VKatalog();
            //JPanel p = new VTransaksi();
            f.getContentPane().add(p);  
            f.setSize(p.getPreferredSize());  
            f.setLocationRelativeTo(null);;  
            f.setVisible(true);  
 

        } catch (Exception e) {
               e.printStackTrace();
        }
    }
}
