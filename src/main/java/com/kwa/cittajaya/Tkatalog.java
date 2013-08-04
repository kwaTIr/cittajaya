/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cittajaya;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arinegara
 */
@Entity
@Table(name = "tkatalog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tkatalog.findAll", query = "SELECT t FROM Tkatalog t"),
    @NamedQuery(name = "Tkatalog.findByKode", query = "SELECT t FROM Tkatalog t WHERE t.kode = :kode"),
    @NamedQuery(name = "Tkatalog.findByMerk", query = "SELECT t FROM Tkatalog t WHERE t.merk = :merk"),
    @NamedQuery(name = "Tkatalog.findByArtikel", query = "SELECT t FROM Tkatalog t WHERE t.artikel = :artikel"),
    @NamedQuery(name = "Tkatalog.findByWarna", query = "SELECT t FROM Tkatalog t WHERE t.warna = :warna"),
    @NamedQuery(name = "Tkatalog.findByUkuran", query = "SELECT t FROM Tkatalog t WHERE t.ukuran = :ukuran"),
    @NamedQuery(name = "Tkatalog.findByLongdesc", query = "SELECT t FROM Tkatalog t WHERE t.longdesc = :longdesc"),
    @NamedQuery(name = "Tkatalog.findByTipe", query = "SELECT t FROM Tkatalog t WHERE t.tipe = :tipe")})
public class Tkatalog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "kode")
    private String kode;
    @Basic(optional = false)
    @Column(name = "merk")
    private String merk;
    @Basic(optional = false)
    @Column(name = "artikel")
    private String artikel;
    @Basic(optional = false)
    @Column(name = "warna")
    private String warna;
    @Basic(optional = false)
    @Column(name = "ukuran")
    private String ukuran;
    @Basic(optional = false)
    @Column(name = "longdesc")
    private String longdesc;
    @Basic(optional = false)
    @Column(name = "tipe")
    private String tipe;

    public Tkatalog() {
    }

    public Tkatalog(String kode) {
        this.kode = kode;
    }

    public Tkatalog(String kode, String merk, String artikel,  String ukuran, String warna, String tipe , String longdesc ) {
        this.kode = kode;
        this.merk = merk;
        this.artikel = artikel;
        this.warna = warna;
        this.ukuran = ukuran;
        this.longdesc = longdesc;
        this.tipe = tipe;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getArtikel() {
        return artikel;
    }

    public void setArtikel(String artikel) {
        this.artikel = artikel;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public String getLongdesc() {
        return longdesc;
    }

    public void setLongdesc(String longdesc) {
        this.longdesc = longdesc;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kode != null ? kode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tkatalog)) {
            return false;
        }
        Tkatalog other = (Tkatalog) object;
        if ((this.kode == null && other.kode != null) || (this.kode != null && !this.kode.equals(other.kode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kwa.cittajaya.Tkatalog[ kode=" + kode + " ]";
    }
    
}
