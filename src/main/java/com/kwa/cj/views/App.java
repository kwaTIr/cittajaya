package com.kwa.cj.views;

import com.kwa.core.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
            
            //JPanel p = new VPegawai();
            //JPanel p = new VKatalog();
            JPanel p = new VKlien();
            f.getContentPane().add(p);  
            f.setSize(p.getPreferredSize());  
            f.setLocationRelativeTo(null);;  
            f.setVisible(true);  
 

        } catch (Exception e) {
               e.printStackTrace();
        }
    }
}
