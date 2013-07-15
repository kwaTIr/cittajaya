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
public class TkatalogJpaController extends GenericController {

    public TkatalogJpaController(EntityManagerFactory emf, EntityManager em) throws Exception {
        super(emf,em);
    }


    public KWAMesg create(Tkatalog tkatalog) throws PreexistingEntityException, Exception {
        checkConnection();
        setError("unknown", "unknownError");
        String longdesc = "";
        
        if (Util.isNullOrSpaces(tkatalog.getKode())) {
            return setError("Kode", "Entity is null or spaces");
        }
        
        if (Util.isNullOrSpaces(tkatalog.getMerk())) {
            return setError("Merk", "Entity is null or spaces");
        } 
        T010JpaController t010p = new T010JpaController(getEmf(),getEm());
        T010 t010 = t010p.findT010("TKMR",tkatalog.getMerk());
        if(t010 == null){
            return setError("Merk", "Entity is invalid");
        }
        longdesc = t010.getDeksripsi();
        
        if (Util.isNullOrSpaces(tkatalog.getArtikel())) {
            return setError("Artikel", "Entity is null or spaces");
        }
        longdesc = longdesc + " " + tkatalog.getArtikel();

        if (Util.isNullOrSpaces(tkatalog.getWarna())) {
            return setError("Warna", "Entity is null or spaces");
        } 
        longdesc = longdesc + " " + tkatalog.getWarna();        
        
        if (Util.isNullOrSpaces(tkatalog.getUkuran())) {
            return setError("Ukuran", "Entity is null or spaces");
        }
        longdesc = longdesc + " " + tkatalog.getUkuran();
        
        if (Util.isNullOrSpaces(tkatalog.getTipe())) {
            return setError("Tipe", "Entity is null or spaces");
        }  
        t010 = t010p.findT010("TKAT",tkatalog.getTipe());
        if(t010 == null){
            return setError("Tipe", "Entity is invalid");
        }              
                
        tkatalog.setLongdesc(longdesc);

        getEm().persist(tkatalog);
        return setOK("Entry Created");

    }

    public KWAMesg edit(Tkatalog tkatalog) throws NonexistentEntityException, Exception {
        checkConnection();
        setError("unknown", "unknownError");
                String longdesc = "";
                
        if (Util.isNullOrSpaces(tkatalog.getKode())) {
            return setError("Kode", "Entity is null or spaces");
        }
        
        if (Util.isNullOrSpaces(tkatalog.getMerk())) {
            return setError("Merk", "Entity is null or spaces");
        } 
        T010JpaController t010p = new T010JpaController(getEmf(),getEm());
        T010 t010 = t010p.findT010("TKMR",tkatalog.getMerk());
        if(t010 == null){
            return setError("Merk", "Entity is invalid");
        }
        longdesc = t010.getDeksripsi();
        
        if (Util.isNullOrSpaces(tkatalog.getArtikel())) {
            return setError("Artikel", "Entity is null or spaces");
        }
        longdesc = longdesc + " " + tkatalog.getArtikel();

        if (Util.isNullOrSpaces(tkatalog.getWarna())) {
            return setError("Warna", "Entity is null or spaces");
        } 
        longdesc = longdesc + " " + tkatalog.getWarna();        
        
        if (Util.isNullOrSpaces(tkatalog.getUkuran())) {
            return setError("Ukuran", "Entity is null or spaces");
        }
        longdesc = longdesc + " " + tkatalog.getUkuran();
        
        if (Util.isNullOrSpaces(tkatalog.getTipe())) {
            return setError("Tipe", "Entity is null or spaces");
        }  
        t010 = t010p.findT010("TKAT",tkatalog.getTipe());
        if(t010 == null){
            return setError("Tipe", "Entity is invalid");
        }              
                
        tkatalog.setLongdesc(longdesc);
        
        getEm().persist(tkatalog);
        return setOK("Entry Modified");
    }

    public KWAMesg destroy(String id) throws NonexistentEntityException {
        checkConnection();
        setError("unknown", "unknownError");
        if (Util.isNullOrSpaces(id)) {
            return setError("kode", "Entity is null or spaces");
        }
        if (findTkatalog(id) == null) {
            return setError("Primary Key", "Entry doesn't exist");
        }
        Tkatalog tkatalog = getEm().getReference(Tkatalog.class, id);
        getEm().remove(tkatalog);

        return setOK("Entry Deleted");
    }

    public List<Tkatalog> findTkatalogEntities() {
        return findTkatalogEntities(true, -1, -1);
    }

    public List<Tkatalog> findTkatalogEntities(int maxResults, int firstResult) {
        return findTkatalogEntities(false, maxResults, firstResult);
    }

    private List<Tkatalog> findTkatalogEntities(boolean all, int maxResults, int firstResult) {
checkConnection();
            CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tkatalog.class));
            Query q = getEm().createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();

    }

    public Tkatalog findTkatalog(String id) {
checkConnection();
            return getEm().find(Tkatalog.class, id);

    }

    public int getTkatalogCount() {
checkConnection();
            CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
            Root<Tkatalog> rt = cq.from(Tkatalog.class);
            cq.select(getEm().getCriteriaBuilder().count(rt));
            Query q = getEm().createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();

    }
    
}
