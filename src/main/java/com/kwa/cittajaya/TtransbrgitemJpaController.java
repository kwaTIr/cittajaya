/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cittajaya;

import com.kwa.cittajaya.exceptions.NonexistentEntityException;
import com.kwa.cittajaya.exceptions.PreexistingEntityException;
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
public class TtransbrgitemJpaController implements Serializable {

    public TtransbrgitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ttransbrgitem ttransbrgitem) throws PreexistingEntityException, Exception {
        if (ttransbrgitem.getTtransbrgitemPK() == null) {
            ttransbrgitem.setTtransbrgitemPK(new TtransbrgitemPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ttransbrgitem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTtransbrgitem(ttransbrgitem.getTtransbrgitemPK()) != null) {
                throw new PreexistingEntityException("Ttransbrgitem " + ttransbrgitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ttransbrgitem ttransbrgitem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ttransbrgitem = em.merge(ttransbrgitem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                TtransbrgitemPK id = ttransbrgitem.getTtransbrgitemPK();
                if (findTtransbrgitem(id) == null) {
                    throw new NonexistentEntityException("The ttransbrgitem with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(TtransbrgitemPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ttransbrgitem ttransbrgitem;
            try {
                ttransbrgitem = em.getReference(Ttransbrgitem.class, id);
                ttransbrgitem.getTtransbrgitemPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ttransbrgitem with id " + id + " no longer exists.", enfe);
            }
            em.remove(ttransbrgitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ttransbrgitem> findTtransbrgitemEntities() {
        return findTtransbrgitemEntities(true, -1, -1);
    }

    public List<Ttransbrgitem> findTtransbrgitemEntities(int maxResults, int firstResult) {
        return findTtransbrgitemEntities(false, maxResults, firstResult);
    }

    private List<Ttransbrgitem> findTtransbrgitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ttransbrgitem.class));
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

    public Ttransbrgitem findTtransbrgitem(TtransbrgitemPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ttransbrgitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getTtransbrgitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ttransbrgitem> rt = cq.from(Ttransbrgitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
