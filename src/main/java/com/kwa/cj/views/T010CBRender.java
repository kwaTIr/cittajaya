/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cj.views;

import com.kwa.cittajaya.T010;
import com.kwa.cittajaya.T010JpaController;
import com.kwa.cittajaya.T010PK;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author arinegara
 */
public class T010CBRender extends BasicComboBoxRenderer {

    private T010JpaController t010p;
    private String tipe;
    private String description;
    private String assocval;

    public T010CBRender(T010JpaController t010p, String tipe) {
        this.t010p = t010p;
        this.tipe = tipe;
        this.description = "";
        this.assocval = "";
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
            if (-1 < index) {
                String strtmp = list.getSelectedValue().toString();
                if (strtmp.trim().equalsIgnoreCase("")) {
                    strtmp = "";
                } else {
                    T010PK pk = new T010PK(this.tipe, strtmp);
                    T010 t010 = t010p.findT010(pk);
                    strtmp = t010.getDeksripsi();
                    this.description = t010.getDeksripsi();
                    this.assocval = t010.getAssocval();

                }
                list.setToolTipText(strtmp);
            }
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setFont(list.getFont());
        setText((value == null) ? "" : value.toString());
        return this;
    }
}
