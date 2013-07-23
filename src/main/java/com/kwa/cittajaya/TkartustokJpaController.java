/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cittajaya;

import com.kwa.cittajaya.exceptions.NonexistentEntityException;
import com.kwa.cittajaya.exceptions.PreexistingEntityException;
import com.kwa.core.GenericController;
import com.kwa.core.KWAMesg;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.commons.lang.NumberUtils;

/**
 *
 * @author arinegara
 */
public class TkartustokJpaController extends GenericController {

    public TkartustokJpaController(EntityManagerFactory emf, EntityManager em) throws Exception {
        super(emf, em);
    }

    public KWAMesg create(Tkartustok tkartustok) throws PreexistingEntityException, Exception {
        checkConnection();
        setError("unknown", "unknownError");
        
                TkatalogJpaController tkatalogp = new TkatalogJpaController(getEmf(), getEm());
        Tkatalog tk = tkatalogp.findTkatalog( tkartustok.getKodekatalog());
        if (tk == null) {
            return setError("Katalog", "Entity is invalid");
        }
        
                 TtransbrgheaderJpaController tbhp = new TtransbrgheaderJpaController(getEmf(), getEm());
        Ttransbrgheader tbh = tbhp.findTtransbrgheader( tkartustok.getKodetrans());
        if (tbh == null) {
            return setError("Transaksi", "Entity is invalid");
        }       

        getEm().persist(tkartustok);
        return setOK("Entry Created");
    }


    public List<Tkartustok> findTkartustokEntities() {
        return findTkartustokEntities(true, -1, -1);
    }

    public List<Tkartustok> findTkartustokEntities(int maxResults, int firstResult) {
        return findTkartustokEntities(false, maxResults, firstResult);
    }

    private List<Tkartustok> findTkartustokEntities(boolean all, int maxResults, int firstResult) {

            CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tkartustok.class));
            Query q = getEm().createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();

    }

    public Tkartustok findTkartustok(Long id) {

            return getEm().find(Tkartustok.class, id);

    }

    public int getTkartustokCount() {

            CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
            Root<Tkartustok> rt = cq.from(Tkartustok.class);
            cq.select(getEm().getCriteriaBuilder().count(rt));
            Query q = getEm().createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();

    }
    
}
