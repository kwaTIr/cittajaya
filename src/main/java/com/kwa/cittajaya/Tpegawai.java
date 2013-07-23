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
@Table(name = "tpegawai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tpegawai.findAll", query = "SELECT t FROM Tpegawai t"),
    @NamedQuery(name = "Tpegawai.findByKode", query = "SELECT t FROM Tpegawai t WHERE t.kode = :kode"),
    @NamedQuery(name = "Tpegawai.findByNama", query = "SELECT t FROM Tpegawai t WHERE t.nama = :nama"),
    @NamedQuery(name = "Tpegawai.findByStatus", query = "SELECT t FROM Tpegawai t WHERE t.status = :status")})
public class Tpegawai implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "kode")
    private String kode;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;

    public Tpegawai() {
    }

    public Tpegawai(String kode) {
        this.kode = kode;
    }

    public Tpegawai(String kode, String nama, String status) {
        this.kode = kode;
        this.nama = nama;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(object instanceof Tpegawai)) {
            return false;
        }
        Tpegawai other = (Tpegawai) object;
        if ((this.kode == null && other.kode != null) || (this.kode != null && !this.kode.equals(other.kode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kwa.cittajaya.Tpegawai[ kode=" + kode + " ]";
    }
    
}
