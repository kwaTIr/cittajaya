/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cittajaya;

import com.kwa.cittajaya.exceptions.NonexistentEntityException;
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
public class TkartustokJpaController implements Serializable {

    public TkartustokJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tkartustok tkartustok) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tkartustok);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tkartustok tkartustok) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tkartustok = em.merge(tkartustok);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = tkartustok.getNourut();
                if (findTkartustok(id) == null) {
                    throw new NonexistentEntityException("The tkartustok with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tkartustok tkartustok;
            try {
                tkartustok = em.getReference(Tkartustok.class, id);
                tkartustok.getNourut();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tkartustok with id " + id + " no longer exists.", enfe);
            }
            em.remove(tkartustok);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tkartustok> findTkartustokEntities() {
        return findTkartustokEntities(true, -1, -1);
    }

    public List<Tkartustok> findTkartustokEntities(int maxResults, int firstResult) {
        return findTkartustokEntities(false, maxResults, firstResult);
    }

    private List<Tkartustok> findTkartustokEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tkartustok.class));
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

    public Tkartustok findTkartustok(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tkartustok.class, id);
        } finally {
            em.close();
        }
    }

    public int getTkartustokCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tkartustok> rt = cq.from(Tkartustok.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
