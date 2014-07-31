/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cj.views;

import com.kwa.cittajaya.T010;
import com.kwa.cittajaya.T010JpaController;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author arinegara
 */
public class T010CBModel extends DefaultComboBoxModel {

    private T010JpaController t010p;
    private String tipe;

    public T010CBModel(T010JpaController t010p, String tipe, String addFirstEntry, String selectedId) {
        this.t010p = t010p;
        this.tipe = tipe;
        boolean isExist = false;
        try {
            if (addFirstEntry != null) {
                addElement(addFirstEntry);
                if (addFirstEntry.trim().equalsIgnoreCase(selectedId.trim())) {
                    isExist = true;
                }
            }

            List<T010> t010l = t010p.findT010Kode(this.tipe);
            for (int i = 0; i < t010l.size(); i++) {
                T010 t010 = t010l.get(i);
                addElement(t010.getT010PK().getKode().trim());
                if (selectedId != null) {
                    if (t010.getT010PK().getKode().trim().equalsIgnoreCase(selectedId.trim())) {
                        isExist = true;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
