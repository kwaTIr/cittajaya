/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cittajaya;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author scumb46
 */
@Embeddable
public class TklienhistoryPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "klien")
    private String klien;
    @Basic(optional = false)
    @Column(name = "katalog")
    private String katalog;
    @Basic(optional = false)
    @Column(name = "nomer")
    private String nomer;

    public TklienhistoryPK() {
    }

    public TklienhistoryPK(String klien, String katalog, String nomer) {
        this.klien = klien;
        this.katalog = katalog;
        this.nomer = nomer;
    }

    public String getKlien() {
        return klien;
    }

    public void setKlien(String klien) {
        this.klien = klien;
    }

    public String getKatalog() {
        return katalog;
    }

    public void setKatalog(String katalog) {
        this.katalog = katalog;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (klien != null ? klien.hashCode() : 0);
        hash += (katalog != null ? katalog.hashCode() : 0);
        hash += (nomer != null ? nomer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TklienhistoryPK)) {
            return false;
        }
        TklienhistoryPK other = (TklienhistoryPK) object;
        if ((this.klien == null && other.klien != null) || (this.klien != null && !this.klien.equals(other.klien))) {
            return false;
        }
        if ((this.katalog == null && other.katalog != null) || (this.katalog != null && !this.katalog.equals(other.katalog))) {
            return false;
        }
        if ((this.nomer == null && other.nomer != null) || (this.nomer != null && !this.nomer.equals(other.nomer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kwa.cittajaya.TklienhistoryPK[ klien=" + klien + ", katalog=" + katalog + ", nomer=" + nomer + " ]";
    }
    
}
