/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cittajaya;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
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
    @NamedQuery(name = "Ttransbrgheader.findByPegawai", query = "SELECT t FROM Ttransbrgheader t WHERE t.pegawai = :pegawai"),
    @NamedQuery(name = "Ttransbrgheader.findByKeluarmasuk", query = "SELECT t FROM Ttransbrgheader t WHERE t.keluarmasuk = :keluarmasuk"),
    @NamedQuery(name = "Ttransbrgheader.findByKeterangan", query = "SELECT t FROM Ttransbrgheader t WHERE t.keterangan = :keterangan")})
public class Ttransbrgheader implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
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
    @Column(name = "pegawai")
    private String pegawai;
    @Basic(optional = false)
    @Column(name = "keluarmasuk")
    private String keluarmasuk;
    @Basic(optional = false)
    @Column(name = "keterangan")
    private String keterangan;

    public Ttransbrgheader() {
    }

    public Ttransbrgheader(String kode) {
        this.kode = kode;
    }

    public Ttransbrgheader(String kode, String tanggal, String klien, String pegawai, String keluarmasuk, String keterangan) {
        this.kode = kode;
        this.tanggal = tanggal;
        this.klien = klien;
        this.pegawai = pegawai;
        this.keluarmasuk = keluarmasuk;
        this.keterangan = keterangan;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        String oldKode = this.kode;
        this.kode = kode;
        changeSupport.firePropertyChange("kode", oldKode, kode);
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        String oldTanggal = this.tanggal;
        this.tanggal = tanggal;
        changeSupport.firePropertyChange("tanggal", oldTanggal, tanggal);
    }

    public String getKlien() {
        return klien;
    }

    public void setKlien(String klien) {
        String oldKlien = this.klien;
        this.klien = klien;
        changeSupport.firePropertyChange("klien", oldKlien, klien);
    }

    public String getPegawai() {
        return pegawai;
    }

    public void setPegawai(String pegawai) {
        String oldPegawai = this.pegawai;
        this.pegawai = pegawai;
        changeSupport.firePropertyChange("pegawai", oldPegawai, pegawai);
    }

    public String getKeluarmasuk() {
        return keluarmasuk;
    }

    public void setKeluarmasuk(String keluarmasuk) {
        String oldKeluarmasuk = this.keluarmasuk;
        this.keluarmasuk = keluarmasuk;
        changeSupport.firePropertyChange("keluarmasuk", oldKeluarmasuk, keluarmasuk);
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        String oldKeterangan = this.keterangan;
        this.keterangan = keterangan;
        changeSupport.firePropertyChange("keterangan", oldKeterangan, keterangan);
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
