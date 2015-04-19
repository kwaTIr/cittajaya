/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cj.pegawai;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author arinegara
 */
public class modelPegawai extends AbstractTableModel {
    
    private String[] columnNames = {"Kode","Nama", "Status"};
    private List<Tpegawai> data ;
    private TpegawaiJpaController pegp;
    
    public modelPegawai(TpegawaiJpaController pegp){
        this.pegp = pegp;
    }
    
    public void searchAll(){
        data = pegp.findTpegawaiEntities();
    }
    
    public List<Tpegawai> getData(){
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
                Tpegawai peg = data.get(rowIndex);
                if(peg==null) return null;
                
                switch(columnIndex){
                        case 0 : return peg.getKode();
                        case 1 : return peg.getNama();
                        case 2 : return peg.getStatus();
                      
                }
                return null;
    }
    
}
