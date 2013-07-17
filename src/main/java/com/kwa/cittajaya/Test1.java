/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cittajaya;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author arinegara
 */
@Entity
@Table(name = "test1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Test1.findAll", query = "SELECT t FROM Test1 t"),
    @NamedQuery(name = "Test1.findByIdtest1", query = "SELECT t FROM Test1 t WHERE t.idtest1 = :idtest1"),
    @NamedQuery(name = "Test1.findByTest1col", query = "SELECT t FROM Test1 t WHERE t.test1col = :test1col"),
    @NamedQuery(name = "Test1.findByTest1col1", query = "SELECT t FROM Test1 t WHERE t.test1col1 = :test1col1")})
public class Test1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtest1")
    private Integer idtest1;
    @Basic(optional = false)
    @Column(name = "test1col")
    private String test1col;
    @Basic(optional = false)
    @Column(name = "test1col1")
    private String test1col1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test1")
    private Collection<Test2> test2Collection;

    public Test1() {
    }

    public Test1(Integer idtest1) {
        this.idtest1 = idtest1;
    }

    public Test1(Integer idtest1, String test1col, String test1col1) {
        this.idtest1 = idtest1;
        this.test1col = test1col;
        this.test1col1 = test1col1;
    }

    public Integer getIdtest1() {
        return idtest1;
    }

    public void setIdtest1(Integer idtest1) {
        this.idtest1 = idtest1;
    }

    public String getTest1col() {
        return test1col;
    }

    public void setTest1col(String test1col) {
        this.test1col = test1col;
    }

    public String getTest1col1() {
        return test1col1;
    }

    public void setTest1col1(String test1col1) {
        this.test1col1 = test1col1;
    }

    @XmlTransient
    public Collection<Test2> getTest2Collection() {
        return test2Collection;
    }

    public void setTest2Collection(Collection<Test2> test2Collection) {
        this.test2Collection = test2Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtest1 != null ? idtest1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test1)) {
            return false;
        }
        Test1 other = (Test1) object;
        if ((this.idtest1 == null && other.idtest1 != null) || (this.idtest1 != null && !this.idtest1.equals(other.idtest1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kwa.cittajaya.Test1[ idtest1=" + idtest1 + " ]";
    }
    
}
