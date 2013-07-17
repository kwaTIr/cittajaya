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
@Table(name = "tklien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tklien.findAll", query = "SELECT t FROM Tklien t"),
    @NamedQuery(name = "Tklien.findByKode", query = "SELECT t FROM Tklien t WHERE t.kode = :kode"),
    @NamedQuery(name = "Tklien.findByNama", query = "SELECT t FROM Tklien t WHERE t.nama = :nama"),
    @NamedQuery(name = "Tklien.findByAlamat", query = "SELECT t FROM Tklien t WHERE t.alamat = :alamat"),
    @NamedQuery(name = "Tklien.findByKota", query = "SELECT t FROM Tklien t WHERE t.kota = :kota"),
    @NamedQuery(name = "Tklien.findByKodepos", query = "SELECT t FROM Tklien t WHERE t.kodepos = :kodepos"),
    @NamedQuery(name = "Tklien.findByNamakontak", query = "SELECT t FROM Tklien t WHERE t.namakontak = :namakontak"),
    @NamedQuery(name = "Tklien.findByTelp", query = "SELECT t FROM Tklien t WHERE t.telp = :telp")})
public class Tklien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "kode")
    private String kode;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Column(name = "alamat")
    private String alamat;
    @Basic(optional = false)
    @Column(name = "kota")
    private String kota;
    @Basic(optional = false)
    @Column(name = "kodepos")
    private String kodepos;
    @Basic(optional = false)
    @Column(name = "namakontak")
    private String namakontak;
    @Basic(optional = false)
    @Column(name = "telp")
    private String telp;

    public Tklien() {
    }

    public Tklien(String kode) {
        this.kode = kode;
    }

    public Tklien(String kode, String nama, String alamat, String kota, String kodepos, String namakontak, String telp) {
        this.kode = kode;
        this.nama = nama;
        this.alamat = alamat;
        this.kota = kota;
        this.kodepos = kodepos;
        this.namakontak = namakontak;
        this.telp = telp;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getKodepos() {
        return kodepos;
    }

    public void setKodepos(String kodepos) {
        this.kodepos = kodepos;
    }

    public String getNamakontak() {
        return namakontak;
    }

    public void setNamakontak(String namakontak) {
        this.namakontak = namakontak;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
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
        if (!(object instanceof Tklien)) {
            return false;
        }
        Tklien other = (Tklien) object;
        if ((this.kode == null && other.kode != null) || (this.kode != null && !this.kode.equals(other.kode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kwa.cittajaya.Tklien[ kode=" + kode + " ]";
    }
    
}
