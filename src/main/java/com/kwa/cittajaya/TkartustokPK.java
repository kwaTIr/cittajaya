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
public class TkartustokPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "nourut")
    private long nourut;
    @Basic(optional = false)
    @Column(name = "kodekatalog")
    private String kodekatalog;

    public TkartustokPK() {
    }

    public TkartustokPK(long nourut, String kodekatalog) {
        this.nourut = nourut;
        this.kodekatalog = kodekatalog;
    }

    public long getNourut() {
        return nourut;
    }

    public void setNourut(long nourut) {
        this.nourut = nourut;
    }

    public String getKodekatalog() {
        return kodekatalog;
    }

    public void setKodekatalog(String kodekatalog) {
        this.kodekatalog = kodekatalog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nourut;
        hash += (kodekatalog != null ? kodekatalog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TkartustokPK)) {
            return false;
        }
        TkartustokPK other = (TkartustokPK) object;
        if (this.nourut != other.nourut) {
            return false;
        }
        if ((this.kodekatalog == null && other.kodekatalog != null) || (this.kodekatalog != null && !this.kodekatalog.equals(other.kodekatalog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kwa.cittajaya.TkartustokPK[ nourut=" + nourut + ", kodekatalog=" + kodekatalog + " ]";
    }
    
}
