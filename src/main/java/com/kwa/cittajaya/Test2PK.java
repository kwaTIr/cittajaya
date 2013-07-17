/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cittajaya;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author arinegara
 */
@Embeddable
public class Test2PK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idtest2")
    private int idtest2;
    @Basic(optional = false)
    @Column(name = "test2col")
    private String test2col;

    public Test2PK() {
    }

    public Test2PK(int idtest2, String test2col) {
        this.idtest2 = idtest2;
        this.test2col = test2col;
    }

    public int getIdtest2() {
        return idtest2;
    }

    public void setIdtest2(int idtest2) {
        this.idtest2 = idtest2;
    }

    public String getTest2col() {
        return test2col;
    }

    public void setTest2col(String test2col) {
        this.test2col = test2col;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtest2;
        hash += (test2col != null ? test2col.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test2PK)) {
            return false;
        }
        Test2PK other = (Test2PK) object;
        if (this.idtest2 != other.idtest2) {
            return false;
        }
        if ((this.test2col == null && other.test2col != null) || (this.test2col != null && !this.test2col.equals(other.test2col))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kwa.cittajaya.Test2PK[ idtest2=" + idtest2 + ", test2col=" + test2col + " ]";
    }
    
}
