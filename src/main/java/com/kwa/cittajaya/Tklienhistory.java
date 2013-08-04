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
 * @author scumb46
 */
@Entity
@Table(name = "tklienhistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tklienhistory.findAll", query = "SELECT t FROM Tklienhistory t"),
    @NamedQuery(name = "Tklienhistory.findByKlien", query = "SELECT t FROM Tklienhistory t WHERE t.tklienhistoryPK.klien = :klien"),
    @NamedQuery(name = "Tklienhistory.findByKatalog", query = "SELECT t FROM Tklienhistory t WHERE t.tklienhistoryPK.katalog = :katalog"),
    @NamedQuery(name = "Tklienhistory.findByNomer", query = "SELECT t FROM Tklienhistory t WHERE t.tklienhistoryPK.nomer = :nomer"),
    @NamedQuery(name = "Tklienhistory.findByTanggal", query = "SELECT t FROM Tklienhistory t WHERE t.tanggal = :tanggal"),
    @NamedQuery(name = "Tklienhistory.findByHarga", query = "SELECT t FROM Tklienhistory t WHERE t.harga = :harga"),
    @NamedQuery(name = "Tklienhistory.findByDiscount", query = "SELECT t FROM Tklienhistory t WHERE t.discount = :discount"),
    @NamedQuery(name = "Tklienhistory.findBySatuan", query = "SELECT t FROM Tklienhistory t WHERE t.satuan = :satuan")})
public class Tklienhistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TklienhistoryPK tklienhistoryPK;
    @Basic(optional = false)
    @Column(name = "tanggal")
    private String tanggal;
    @Basic(optional = false)
    @Column(name = "harga")
    private double harga;
    @Basic(optional = false)
    @Column(name = "discount")
    private String discount;
    @Basic(optional = false)
    @Column(name = "satuan")
    private String satuan;

    public Tklienhistory() {
    }

    public Tklienhistory(TklienhistoryPK tklienhistoryPK) {
        this.tklienhistoryPK = tklienhistoryPK;
    }

    public Tklienhistory(TklienhistoryPK tklienhistoryPK, String tanggal, double harga, String discount, String satuan) {
        this.tklienhistoryPK = tklienhistoryPK;
        this.tanggal = tanggal;
        this.harga = harga;
        this.discount = discount;
        this.satuan = satuan;
    }

    public Tklienhistory(String klien, String katalog, String nomer) {
        this.tklienhistoryPK = new TklienhistoryPK(klien, katalog, nomer);
    }

    public TklienhistoryPK getTklienhistoryPK() {
        return tklienhistoryPK;
    }

    public void setTklienhistoryPK(TklienhistoryPK tklienhistoryPK) {
        this.tklienhistoryPK = tklienhistoryPK;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tklienhistoryPK != null ? tklienhistoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tklienhistory)) {
            return false;
        }
        Tklienhistory other = (Tklienhistory) object;
        if ((this.tklienhistoryPK == null && other.tklienhistoryPK != null) || (this.tklienhistoryPK != null && !this.tklienhistoryPK.equals(other.tklienhistoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kwa.cittajaya.Tklienhistory[ tklienhistoryPK=" + tklienhistoryPK + " ]";
    }
    
}
