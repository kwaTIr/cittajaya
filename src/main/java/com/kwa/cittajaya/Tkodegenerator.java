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
@Table(name = "tkodegenerator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tkodegenerator.findAll", query = "SELECT t FROM Tkodegenerator t"),
    @NamedQuery(name = "Tkodegenerator.findByTipe", query = "SELECT t FROM Tkodegenerator t WHERE t.tkodegeneratorPK.tipe = :tipe"),
    @NamedQuery(name = "Tkodegenerator.findByKode", query = "SELECT t FROM Tkodegenerator t WHERE t.tkodegeneratorPK.kode = :kode"),
    @NamedQuery(name = "Tkodegenerator.findByLast", query = "SELECT t FROM Tkodegenerator t WHERE t.last = :last")})
public class Tkodegenerator implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TkodegeneratorPK tkodegeneratorPK;
    @Basic(optional = false)
    @Column(name = "last")
    private int last;

    public Tkodegenerator() {
    }

    public Tkodegenerator(TkodegeneratorPK tkodegeneratorPK) {
        this.tkodegeneratorPK = tkodegeneratorPK;
    }
    

    
    public Tkodegenerator(TkodegeneratorPK tkodegeneratorPK, int last) {
        this.tkodegeneratorPK = tkodegeneratorPK;
        this.last = last;
    }

    public Tkodegenerator(String tipe, String kode) {
        this.tkodegeneratorPK = new TkodegeneratorPK(tipe, kode);
    }
   public Tkodegenerator(String tipe, String kode, int last) {
        this.tkodegeneratorPK = new TkodegeneratorPK(tipe, kode);
        this.last = last;
    }
    public TkodegeneratorPK getTkodegeneratorPK() {
        return tkodegeneratorPK;
    }

    public void setTkodegeneratorPK(TkodegeneratorPK tkodegeneratorPK) {
        this.tkodegeneratorPK = tkodegeneratorPK;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tkodegeneratorPK != null ? tkodegeneratorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tkodegenerator)) {
            return false;
        }
        Tkodegenerator other = (Tkodegenerator) object;
        if ((this.tkodegeneratorPK == null && other.tkodegeneratorPK != null) || (this.tkodegeneratorPK != null && !this.tkodegeneratorPK.equals(other.tkodegeneratorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kwa.cittajaya.Tkodegenerator[ tkodegeneratorPK=" + tkodegeneratorPK + " ]";
    }
    
}
