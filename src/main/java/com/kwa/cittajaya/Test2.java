/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cittajaya;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arinegara
 */
@Entity
@Table(name = "test2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Test2.findAll", query = "SELECT t FROM Test2 t"),
    @NamedQuery(name = "Test2.findByIdtest2", query = "SELECT t FROM Test2 t WHERE t.test2PK.idtest2 = :idtest2"),
    @NamedQuery(name = "Test2.findByTest2col", query = "SELECT t FROM Test2 t WHERE t.test2PK.test2col = :test2col")})
public class Test2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Test2PK test2PK;
    @JoinColumn(name = "idtest2", referencedColumnName = "idtest1", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Test1 test1;

    public Test2() {
    }

    public Test2(Test2PK test2PK) {
        this.test2PK = test2PK;
    }

    public Test2(int idtest2, String test2col) {
        this.test2PK = new Test2PK(idtest2, test2col);
    }

    public Test2PK getTest2PK() {
        return test2PK;
    }

    public void setTest2PK(Test2PK test2PK) {
        this.test2PK = test2PK;
    }

    public Test1 getTest1() {
        return test1;
    }

    public void setTest1(Test1 test1) {
        this.test1 = test1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (test2PK != null ? test2PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test2)) {
            return false;
        }
        Test2 other = (Test2) object;
        if ((this.test2PK == null && other.test2PK != null) || (this.test2PK != null && !this.test2PK.equals(other.test2PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kwa.cittajaya.Test2[ test2PK=" + test2PK + " ]";
    }
    
}
