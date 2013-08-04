/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cj.views;

import com.kwa.cittajaya.Tkatalog;
import com.kwa.cittajaya.TkatalogJpaController;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author arinegara
 */
public class modelKatalog extends AbstractTableModel {
    
    private String[] columnNames = {"Kode","Merk", "Artikel","Ukuran","Warna","Tipe"};
    private List<Tkatalog> data ;
    private TkatalogJpaController katalogp;
    
    public modelKatalog(TkatalogJpaController katalogp){
        this.katalogp = katalogp;
    }
    
    public void searchAll(){
        data = katalogp.findTkatalogEntities();
    }
    
    public List<Tkatalog> getData(){
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
                Tkatalog katalog = data.get(rowIndex);
                if(katalog==null) return null;
                
                switch(columnIndex){
                        case 0 : return katalog.getKode();
                        case 1 : return katalog.getMerk();
                        case 2 : return katalog.getArtikel();
                        case 3 : return katalog.getUkuran();
                        case 4 : return katalog.getWarna();
                        case 5 : return katalog.getTipe();
                      
                }
                return null;
    }
    
}
