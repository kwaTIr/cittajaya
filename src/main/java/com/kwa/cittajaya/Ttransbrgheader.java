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
@Table(name = "ttransbrgheader")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ttransbrgheader.findAll", query = "SELECT t FROM Ttransbrgheader t"),
    @NamedQuery(name = "Ttransbrgheader.findByKode", query = "SELECT t FROM Ttransbrgheader t WHERE t.kode = :kode"),
    @NamedQuery(name = "Ttransbrgheader.findByTanggal", query = "SELECT t FROM Ttransbrgheader t WHERE t.tanggal = :tanggal"),
    @NamedQuery(name = "Ttransbrgheader.findByKlien", query = "SELECT t FROM Ttransbrgheader t WHERE t.klien = :klien"),
    @NamedQuery(name = "Ttransbrgheader.findByInout", query = "SELECT t FROM Ttransbrgheader t WHERE t.inout = :inout"),
    @NamedQuery(name = "Ttransbrgheader.findByKeterangan", query = "SELECT t FROM Ttransbrgheader t WHERE t.keterangan = :keterangan")})
public class Ttransbrgheader implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "kode")
    private String kode;
    @Basic(optional = false)
    @Column(name = "tanggal")
    private String tanggal;
    @Basic(optional = false)
    @Column(name = "klien")
    private String klien;
    @Basic(optional = false)
    @Column(name = "inout")
    private char inout;
    @Basic(optional = false)
    @Column(name = "keterangan")
    private String keterangan;

    public Ttransbrgheader() {
    }

    public Ttransbrgheader(String kode) {
        this.kode = kode;
    }

    public Ttransbrgheader(String kode, String tanggal, String klien, char inout, String keterangan) {
        this.kode = kode;
        this.tanggal = tanggal;
        this.klien = klien;
        this.inout = inout;
        this.keterangan = keterangan;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKlien() {
        return klien;
    }

    public void setKlien(String klien) {
        this.klien = klien;
    }

    public char getInout() {
        return inout;
    }

    public void setInout(char inout) {
        this.inout = inout;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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
        if (!(object instanceof Ttransbrgheader)) {
            return false;
        }
        Ttransbrgheader other = (Ttransbrgheader) object;
        if ((this.kode == null && other.kode != null) || (this.kode != null && !this.kode.equals(other.kode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kwa.cittajaya.Ttransbrgheader[ kode=" + kode + " ]";
    }
    
}
