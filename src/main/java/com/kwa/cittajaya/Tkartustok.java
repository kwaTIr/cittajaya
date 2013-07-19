/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cittajaya;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tkartustok")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tkartustok.findAll", query = "SELECT t FROM Tkartustok t"),
    @NamedQuery(name = "Tkartustok.findByNourut", query = "SELECT t FROM Tkartustok t WHERE t.nourut = :nourut"),
    @NamedQuery(name = "Tkartustok.findByKodekatalog", query = "SELECT t FROM Tkartustok t WHERE t.kodekatalog = :kodekatalog"),
    @NamedQuery(name = "Tkartustok.findByKodetrans", query = "SELECT t FROM Tkartustok t WHERE t.kodetrans = :kodetrans"),
    @NamedQuery(name = "Tkartustok.findByAwal", query = "SELECT t FROM Tkartustok t WHERE t.awal = :awal"),
    @NamedQuery(name = "Tkartustok.findByTransaksi", query = "SELECT t FROM Tkartustok t WHERE t.transaksi = :transaksi"),
    @NamedQuery(name = "Tkartustok.findByAkhir", query = "SELECT t FROM Tkartustok t WHERE t.akhir = :akhir")})
public class Tkartustok implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nourut")
    private Long nourut;
    @Basic(optional = false)
    @Column(name = "kodekatalog")
    private String kodekatalog;
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

    public Tkartustok(Long nourut) {
        this.nourut = nourut;
    }

    public Tkartustok(Long nourut, String kodekatalog, String kodetrans, int awal, int transaksi, int akhir) {
        this.nourut = nourut;
        this.kodekatalog = kodekatalog;
        this.kodetrans = kodetrans;
        this.awal = awal;
        this.transaksi = transaksi;
        this.akhir = akhir;
    }

    public Long getNourut() {
        return nourut;
    }

    public void setNourut(Long nourut) {
        this.nourut = nourut;
    }

    public String getKodekatalog() {
        return kodekatalog;
    }

    public void setKodekatalog(String kodekatalog) {
        this.kodekatalog = kodekatalog;
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
        hash += (nourut != null ? nourut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tkartustok)) {
            return false;
        }
        Tkartustok other = (Tkartustok) object;
        if ((this.nourut == null && other.nourut != null) || (this.nourut != null && !this.nourut.equals(other.nourut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kwa.cittajaya.Tkartustok[ nourut=" + nourut + " ]";
    }
    
}
