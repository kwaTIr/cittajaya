/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cj.views;

import com.kwa.cittajaya.TkatalogJpaController;
import com.kwa.cittajaya.Ttransbrgitem;
import com.kwa.cittajaya.TtransbrgitemJpaController;
import com.kwa.cittajaya.TtransbrgitemPK;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author arinegara
 */
public class modelTransItem extends AbstractTableModel {
    
    private String[] columnNames = {"Kode","Deskripsi", "Jumlah","Satuan","Harga","Discount","Total"};
    private List<Ttransbrgitem> data ;
    private TtransbrgitemJpaController transitemp;
    
    public modelTransItem(TtransbrgitemJpaController transitemp){
        this.transitemp = transitemp;
    }
    
    public void searchAll(String id){
        data = transitemp.findTtransbrgitem(id);
    }
    
    public List<Ttransbrgitem> getData(){
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
                Ttransbrgitem item = data.get(rowIndex);
                if(item==null) return null;
                
        TkatalogJpaController katalog;
        try {
            katalog = new TkatalogJpaController(transitemp.getEmf(),transitemp.getEm());
        } catch (Exception ex) {
            Logger.getLogger(modelTransItem.class.getName()).log(Level.SEVERE, null, ex);
        }

                
                switch(columnIndex){
                        case 0 : return item.getTtransbrgitemPK().getKodekatalog();
                        case 1 : return     
                        case 1 : return katalog.getMerk();
                        case 2 : return katalog.getArtikel();
                        case 3 : return katalog.getUkuran();
                        case 4 : return katalog.getWarna();
                        case 5 : return katalog.getTipe();
                      
                }
                return null;
    }
    
}
