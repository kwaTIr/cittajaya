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
public class Test2JpaController implements Serializable {

    public Test2JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Test2 test2) throws PreexistingEntityException, Exception {
        if (test2.getTest2PK() == null) {
            test2.setTest2PK(new Test2PK());
        }
        test2.getTest2PK().setIdtest2(test2.getTest1().getIdtest1());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Test1 test1 = test2.getTest1();
            if (test1 != null) {
                test1 = em.getReference(test1.getClass(), test1.getIdtest1());
                test2.setTest1(test1);
            }
            em.persist(test2);
            if (test1 != null) {
                test1.getTest2Collection().add(test2);
                test1 = em.merge(test1);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTest2(test2.getTest2PK()) != null) {
                throw new PreexistingEntityException("Test2 " + test2 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Test2 test2) throws NonexistentEntityException, Exception {
        test2.getTest2PK().setIdtest2(test2.getTest1().getIdtest1());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Test2 persistentTest2 = em.find(Test2.class, test2.getTest2PK());
            Test1 test1Old = persistentTest2.getTest1();
            Test1 test1New = test2.getTest1();
            if (test1New != null) {
                test1New = em.getReference(test1New.getClass(), test1New.getIdtest1());
                test2.setTest1(test1New);
            }
            test2 = em.merge(test2);
            if (test1Old != null && !test1Old.equals(test1New)) {
                test1Old.getTest2Collection().remove(test2);
                test1Old = em.merge(test1Old);
            }
            if (test1New != null && !test1New.equals(test1Old)) {
                test1New.getTest2Collection().add(test2);
                test1New = em.merge(test1New);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Test2PK id = test2.getTest2PK();
                if (findTest2(id) == null) {
                    throw new NonexistentEntityException("The test2 with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Test2PK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Test2 test2;
            try {
                test2 = em.getReference(Test2.class, id);
                test2.getTest2PK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The test2 with id " + id + " no longer exists.", enfe);
            }
            Test1 test1 = test2.getTest1();
            if (test1 != null) {
                test1.getTest2Collection().remove(test2);
                test1 = em.merge(test1);
            }
            em.remove(test2);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Test2> findTest2Entities() {
        return findTest2Entities(true, -1, -1);
    }

    public List<Test2> findTest2Entities(int maxResults, int firstResult) {
        return findTest2Entities(false, maxResults, firstResult);
    }

    private List<Test2> findTest2Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Test2.class));
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

    public Test2 findTest2(Test2PK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Test2.class, id);
        } finally {
            em.close();
        }
    }

    public int getTest2Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Test2> rt = cq.from(Test2.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
