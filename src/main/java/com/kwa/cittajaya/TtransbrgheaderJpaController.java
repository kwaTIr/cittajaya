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
public class TtransbrgheaderJpaController extends GenericController {

    public TtransbrgheaderJpaController(EntityManagerFactory emf, EntityManager em) throws Exception {
        super(emf,em);
    }


    public KWAMesg create(Ttransbrgheader ttransbrgheader) throws Exception {
                checkConnection();
        setError("unknown", "unknownError");
        
                if(Util.isNullOrSpaces(ttransbrgheader.getKode())){
            return setError("kode","Entity is null or spaces");
        }
                
                if(Util.isNullOrSpaces(ttransbrgheader.getKode())){
            return setError("kode","Entity is null or spaces");
        }                
                
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ttransbrgheader);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTtransbrgheader(ttransbrgheader.getKode()) != null) {
                throw new PreexistingEntityException("Ttransbrgheader " + ttransbrgheader + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ttransbrgheader ttransbrgheader) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ttransbrgheader = em.merge(ttransbrgheader);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ttransbrgheader.getKode();
                if (findTtransbrgheader(id) == null) {
                    throw new NonexistentEntityException("The ttransbrgheader with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ttransbrgheader ttransbrgheader;
            try {
                ttransbrgheader = em.getReference(Ttransbrgheader.class, id);
                ttransbrgheader.getKode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ttransbrgheader with id " + id + " no longer exists.", enfe);
            }
            em.remove(ttransbrgheader);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ttransbrgheader> findTtransbrgheaderEntities() {
        return findTtransbrgheaderEntities(true, -1, -1);
    }

    public List<Ttransbrgheader> findTtransbrgheaderEntities(int maxResults, int firstResult) {
        return findTtransbrgheaderEntities(false, maxResults, firstResult);
    }

    private List<Ttransbrgheader> findTtransbrgheaderEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ttransbrgheader.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Ttransbrgheader findTtransbrgheader(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ttransbrgheader.class, id);
        } finally {
            em.close();
        }
    }

    public int getTtransbrgheaderCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ttransbrgheader> rt = cq.from(Ttransbrgheader.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
