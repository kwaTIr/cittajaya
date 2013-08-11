/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cittajaya;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**
 *
 * @author arinegara
 */
@Embeddable
public class TtransbrgitemPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "kode")
    private String kode;
    @Basic(optional = false)
    @Column(name = "kodekatalog")
    private String kodekatalog;

    

    public TtransbrgitemPK() {
    }

    public TtransbrgitemPK(String kode, String kodekatalog) {
        this.kode = kode;
        this.kodekatalog = kodekatalog;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
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
        hash += (kode != null ? kode.hashCode() : 0);
        hash += (kodekatalog != null ? kodekatalog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TtransbrgitemPK)) {
            return false;
        }
        TtransbrgitemPK other = (TtransbrgitemPK) object;
        if ((this.kode == null && other.kode != null) || (this.kode != null && !this.kode.equals(other.kode))) {
            return false;
        }
        if ((this.kodekatalog == null && other.kodekatalog != null) || (this.kodekatalog != null && !this.kodekatalog.equals(other.kodekatalog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kwa.cittajaya.TtransbrgitemPK[ kode=" + kode + ", kodekatalog=" + kodekatalog + " ]";
    }
    
}
