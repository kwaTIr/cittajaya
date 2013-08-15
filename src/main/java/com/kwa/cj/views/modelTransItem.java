/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cj.views;

import com.kwa.cittajaya.Tkatalog;
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
    
    private String[] columnNames = {"Kode","Deskripsi","Harga", "Jumlah","Satuan","Discount","Total"};
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
                


                
                switch(columnIndex){
                        case 0 : return item.getTtransbrgitemPK().getKodekatalog();
                        case 1 : return getKatalogDetail(item.getTtransbrgitemPK().getKodekatalog());    
                        case 2 : return item.getHarga();
                        case 3 : return item.getJumlah();
                        case 4 : return item.getSatuan();
                        case 5 : return item.getDiscount();
                        case 6 : return item.getTotal();
                      
                }
                return null;
    }
    
    public String getKatalogDetail(String kode){
        TkatalogJpaController katalogp;
        try {
            katalogp = new TkatalogJpaController(this.transitemp.getEmf(),this.transitemp.getEm());
              Tkatalog katalog = katalogp.findTkatalog(kode);
              return katalog.getLongdesc();
        } catch (Exception ex) {
            Logger.getLogger(modelTransItem.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return "";
        
        
    }
    
}
