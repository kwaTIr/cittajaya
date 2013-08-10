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
@Table(name = "tkartustok")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tkartustok.findAll", query = "SELECT t FROM Tkartustok t"),
    @NamedQuery(name = "Tkartustok.findByNourut", query = "SELECT t FROM Tkartustok t WHERE t.tkartustokPK.nourut = :nourut"),
    @NamedQuery(name = "Tkartustok.findByKodekatalog", query = "SELECT t FROM Tkartustok t WHERE t.tkartustokPK.kodekatalog = :kodekatalog"),
    @NamedQuery(name = "Tkartustok.findByKodetrans", query = "SELECT t FROM Tkartustok t WHERE t.kodetrans = :kodetrans"),
    @NamedQuery(name = "Tkartustok.findByAwal", query = "SELECT t FROM Tkartustok t WHERE t.awal = :awal"),
    @NamedQuery(name = "Tkartustok.findByTransaksi", query = "SELECT t FROM Tkartustok t WHERE t.transaksi = :transaksi"),
    @NamedQuery(name = "Tkartustok.findByAkhir", query = "SELECT t FROM Tkartustok t WHERE t.akhir = :akhir")})
public class Tkartustok implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TkartustokPK tkartustokPK;
    @Basic(optional = false)
    @Column(name = "kodetrans")
    private String kodetrans;
    @Basic(optional = false)
    @Column(name = "awal")
    private int awal;
    @Basic(optional = false)
    @Column(name = "transaksi")
    private int transaksi;
    @Basic(optional = false)
    @Column(name = "akhir")
    private int akhir;

    public Tkartustok() {
    }

    public Tkartustok(TkartustokPK tkartustokPK) {
        this.tkartustokPK = tkartustokPK;
    }

    public Tkartustok(TkartustokPK tkartustokPK, String kodetrans, int awal, int transaksi, int akhir) {
        this.tkartustokPK = tkartustokPK;
        this.kodetrans = kodetrans;
        this.awal = awal;
        this.transaksi = transaksi;
        this.akhir = akhir;
    }

    public Tkartustok(long nourut, String kodekatalog) {
        this.tkartustokPK = new TkartustokPK(nourut, kodekatalog);
    }

    public TkartustokPK getTkartustokPK() {
        return tkartustokPK;
    }

    public void setTkartustokPK(TkartustokPK tkartustokPK) {
        this.tkartustokPK = tkartustokPK;
    }

    public String getKodetrans() {
        return kodetrans;
    }

    public void setKodetrans(String kodetrans) {
        this.kodetrans = kodetrans;
    }

    public int getAwal() {
        return awal;
    }

    public void setAwal(int awal) {
        this.awal = awal;
    }

    public int getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(int transaksi) {
        this.transaksi = transaksi;
    }

    public int getAkhir() {
        return akhir;
    }

    public void setAkhir(int akhir) {
        this.akhir = akhir;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tkartustokPK != null ? tkartustokPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tkartustok)) {
            return false;
        }
        Tkartustok other = (Tkartustok) object;
        if ((this.tkartustokPK == null && other.tkartustokPK != null) || (this.tkartustokPK != null && !this.tkartustokPK.equals(other.tkartustokPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kwa.cittajaya.Tkartustok[ tkartustokPK=" + tkartustokPK + " ]";
    }
    
}
