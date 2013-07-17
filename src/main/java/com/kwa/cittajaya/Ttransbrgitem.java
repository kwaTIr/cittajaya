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
@Table(name = "ttransbrgitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ttransbrgitem.findAll", query = "SELECT t FROM Ttransbrgitem t"),
    @NamedQuery(name = "Ttransbrgitem.findByKode", query = "SELECT t FROM Ttransbrgitem t WHERE t.ttransbrgitemPK.kode = :kode"),
    @NamedQuery(name = "Ttransbrgitem.findByKodekatalog", query = "SELECT t FROM Ttransbrgitem t WHERE t.ttransbrgitemPK.kodekatalog = :kodekatalog"),
    @NamedQuery(name = "Ttransbrgitem.findByJumlah", query = "SELECT t FROM Ttransbrgitem t WHERE t.jumlah = :jumlah"),
    @NamedQuery(name = "Ttransbrgitem.findBySatuan", query = "SELECT t FROM Ttransbrgitem t WHERE t.satuan = :satuan"),
    @NamedQuery(name = "Ttransbrgitem.findByHarga", query = "SELECT t FROM Ttransbrgitem t WHERE t.harga = :harga"),
    @NamedQuery(name = "Ttransbrgitem.findByDiscount", query = "SELECT t FROM Ttransbrgitem t WHERE t.discount = :discount"),
    @NamedQuery(name = "Ttransbrgitem.findByTotal", query = "SELECT t FROM Ttransbrgitem t WHERE t.total = :total")})
public class Ttransbrgitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TtransbrgitemPK ttransbrgitemPK;
    @Basic(optional = false)
    @Column(name = "jumlah", nullable = false)
    private double jumlah;
    @Basic(optional = false)
    @Column(name = "satuan", nullable = false, length = 4)
    private String satuan;
    @Basic(optional = false)
    @Column(name = "harga", nullable = false)
    private double harga;
    @Basic(optional = false)
    @Column(name = "discount", nullable = false, length = 20)
    private String discount;
    @Basic(optional = false)
    @Column(name = "total", nullable = false)
    private double total;

    public Ttransbrgitem() {
    }

    public Ttransbrgitem(TtransbrgitemPK ttransbrgitemPK) {
        this.ttransbrgitemPK = ttransbrgitemPK;
    }

    public Ttransbrgitem(TtransbrgitemPK ttransbrgitemPK, double jumlah, String satuan, double harga, String discount, double total) {
        this.ttransbrgitemPK = ttransbrgitemPK;
        this.jumlah = jumlah;
        this.satuan = satuan;
        this.harga = harga;
        this.discount = discount;
        this.total = total;
    }

    public Ttransbrgitem(String kode, String kodekatalog) {
        this.ttransbrgitemPK = new TtransbrgitemPK(kode, kodekatalog);
    }

    public TtransbrgitemPK getTtransbrgitemPK() {
        return ttransbrgitemPK;
    }

    public void setTtransbrgitemPK(TtransbrgitemPK ttransbrgitemPK) {
        this.ttransbrgitemPK = ttransbrgitemPK;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ttransbrgitemPK != null ? ttransbrgitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ttransbrgitem)) {
            return false;
        }
        Ttransbrgitem other = (Ttransbrgitem) object;
        if ((this.ttransbrgitemPK == null && other.ttransbrgitemPK != null) || (this.ttransbrgitemPK != null && !this.ttransbrgitemPK.equals(other.ttransbrgitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kwa.cittajaya.Ttransbrgitem[ ttransbrgitemPK=" + ttransbrgitemPK + " ]";
    }
    
}
