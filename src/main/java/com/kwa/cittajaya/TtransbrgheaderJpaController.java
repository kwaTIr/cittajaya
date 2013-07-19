/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cittajaya;

import com.kwa.cittajaya.exceptions.NonexistentEntityException;
import com.kwa.cittajaya.exceptions.PreexistingEntityException;
import com.kwa.core.GenericController;
import com.kwa.core.KWAMesg;
import com.kwa.core.Util;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author arinegara
 */
public class TtransbrgheaderJpaController extends GenericController {

    public TtransbrgheaderJpaController(EntityManagerFactory emf, EntityManager em) throws Exception {
        super(emf, em);
    }


    public KWAMesg create(Ttransbrgheader ttransbrgheader) throws PreexistingEntityException, Exception {
        checkConnection();
        setError("unknown", "unknownError");

        if (Util.isNullOrSpaces(ttransbrgheader.getKode())) {
            return setError("Kode", "Entity is null or spaces");
        }
        
        if(!Util.isDateValid(ttransbrgheader.getTanggal(),"YYMMDD")){
            return setError("tanggal", "Entity is invalid");
        }
        
                TklienJpaController tklienp = new TklienJpaController(getEmf(), getEm());
        Tklien tklien = tklienp.findTklien(ttransbrgheader.getKlien());
        if (tklien == null) {
            return setError("Klien", "Entity is invalid");
        }
        char[] io = {'I', 'O'};
        if(!Arrays.asList(io).contains(ttransbrgheader.getInout())){
            return setError("Inout", "Entity is null or spaces");
        }
         
                if (Util.isNullOrSpaces(ttransbrgheader.getKeterangan())) {
            return setError("Deskripsi", "Entity is null or spaces");
        }
                
         getEm().persist(ttransbrgheader);
        return setOK("Entry Created");
    }

    public KWAMesg edit(Ttransbrgheader ttransbrgheader) throws NonexistentEntityException, Exception {
          checkConnection();
        setError("unknown", "unknownError");

        if (Util.isNullOrSpaces(ttransbrgheader.getKode())) {
            return setError("Kode", "Entity is null or spaces");
        }

        if (findTtransbrgheader(ttransbrgheader.getKode()) == null) {
            return setError("Primary Key", "Entry doesn't exist");
        }
  
               if(!Util.isDateValid(ttransbrgheader.getTanggal(),"YYMMDD")){
            return setError("tanggal", "Entity is invalid");
        }
        
                TklienJpaController tklienp = new TklienJpaController(getEmf(), getEm());
        Tklien tklien = tklienp.findTklien(ttransbrgheader.getKlien());
        if (tklien == null) {
            return setError("Klien", "Entity is invalid");
        }
        char[] io = {'I', 'O'};
        if(!Arrays.asList(io).contains(ttransbrgheader.getInout())){
            return setError("Inout", "Entity is null or spaces");
        }
         
                if (Util.isNullOrSpaces(ttransbrgheader.getKeterangan())) {
            return setError("Deskripsi", "Entity is null or spaces");
        }
                getEm().merge(ttransbrgheader);
        return setOK("Entry Modified");
        
    }

    public KWAMesg destroy(String id) throws NonexistentEntityException {

                checkConnection();
        setError("unknown", "unknownError");
        if (Util.isNullOrSpaces(id)) {
            return setError("kode", "Entity is null or spaces");
        }
        if (findTtransbrgheader(id) == null) {
            return setError("Primary Key", "Entry doesn't exist");
        }
        Ttransbrgheader tbh = getEm().getReference(Ttransbrgheader.class, id);
        getEm().remove(tbh);

        return setOK("Entry Deleted");
    }

    public List<Ttransbrgheader> findTtransbrgheaderEntities() {
        return findTtransbrgheaderEntities(true, -1, -1);
    }

    public List<Ttransbrgheader> findTtransbrgheaderEntities(int maxResults, int firstResult) {
        return findTtransbrgheaderEntities(false, maxResults, firstResult);
    }

    private List<Ttransbrgheader> findTtransbrgheaderEntities(boolean all, int maxResults, int firstResult) {
 
            CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ttransbrgheader.class));
            Query q = getEm().createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
       
    }

    public Ttransbrgheader findTtransbrgheader(String id) {

            return getEm().find(Ttransbrgheader.class, id);

    }

    public int getTtransbrgheaderCount() {

            CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
            Root<Ttransbrgheader> rt = cq.from(Ttransbrgheader.class);
            cq.select(getEm().getCriteriaBuilder().count(rt));
            Query q = getEm().createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();

    }
    
}
