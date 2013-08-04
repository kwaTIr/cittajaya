/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cj.views;

import com.kwa.cittajaya.Tklien;
import com.kwa.cittajaya.TklienJpaController;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author arinegara
 */
public class modelKlien extends AbstractTableModel {
    
    private String[] columnNames = {"Kode","Nama", "Alamat","Kota","KodePos","Kontak","Telp"};
    private List<Tklien> data ;
    private TklienJpaController klienp;
    
    public modelKlien(TklienJpaController klienp){
        this.klienp = klienp;
    }
    
    public void searchAll(){
        data = klienp.findTklienEntities();
    }
    
    public List<Tklien> getData(){
        return data;
    }
    public int getRowCount() {
        if(data==null) return 0;
        return data.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }
    public String getColumnName(int col) {
        return (String)columnNames[col];
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        		if(data==null)	return null;
		if(data.size()==0) return null;
                Tklien klien = data.get(rowIndex);
                if(klien==null) return null;
                
                switch(columnIndex){
                        case 0 : return klien.getKode();
                        case 1 : return klien.getNama();
                        case 2 : return klien.getAlamat();
                        case 3 : return klien.getKota();
                        case 4 : return klien.getKodepos();
                        case 5 : return klien.getNamakontak();
                        case 6 : return klien.getTelp();
                      
                }
                return null;
    }
    
}
