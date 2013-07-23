/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cittajaya;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arinegara
 */
@Entity
@Table(name = "t010")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "T010.findAll", query = "SELECT t FROM T010 t"),
    @NamedQuery(name = "T010.findByTipe", query = "SELECT t FROM T010 t WHERE t.t010PK.tipe = :tipe"),
    @NamedQuery(name = "T010.findByKode", query = "SELECT t FROM T010 t WHERE t.t010PK.kode = :kode"),
    @NamedQuery(name = "T010.findByDeksripsi", query = "SELECT t FROM T010 t WHERE t.deksripsi = :deksripsi")})
public class T010 implements Serializable {
    @Basic(optional = false)
    @Column(name = "assocval")
    private String assocval;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected T010PK t010PK;
    @Basic(optional = false)
    @Column(name = "deksripsi")
    private String deksripsi;

    public T010() {
    }

    public T010(T010PK t010PK) {
        this.t010PK = t010PK;
    }

    public T010(String tipe, String kode, String deskripsi){
        T010PK t010pk = new T010PK(tipe,kode);
        this.t010PK = t010pk;
        this.deksripsi = deskripsi;
    }
    public T010(T010PK t010PK, String deksripsi) {
        this.t010PK = t010PK;
        this.deksripsi = deksripsi;
    }

    public T010(String tipe, String kode) {
        this.t010PK = new T010PK(tipe, kode);
    }

    public T010PK getT010PK() {
        return t010PK;
    }

    public void setT010PK(T010PK t010PK) {
        this.t010PK = t010PK;
    }

    public String getDeksripsi() {
        return deksripsi;
    }

    public void setDeksripsi(String deksripsi) {
        this.deksripsi = deksripsi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (t010PK != null ? t010PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T010)) {
            return false;
        }
        T010 other = (T010) object;
        if ((this.t010PK == null && other.t010PK != null) || (this.t010PK != null && !this.t010PK.equals(other.t010PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kwa.cittajaya.T010[ t010PK=" + t010PK + " ]";
    }

    public String getAssocval() {
        return assocval;
    }

    public void setAssocval(String assocval) {
        this.assocval = assocval;
    }
    
}
