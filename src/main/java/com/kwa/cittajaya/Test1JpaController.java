/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cittajaya;

import com.kwa.cittajaya.exceptions.IllegalOrphanException;
import com.kwa.cittajaya.exceptions.NonexistentEntityException;
import com.kwa.cittajaya.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author arinegara
 */
public class Test1JpaController implements Serializable {

    public Test1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Test1 test1) throws PreexistingEntityException, Exception {
        if (test1.getTest2Collection() == null) {
            test1.setTest2Collection(new ArrayList<Test2>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Test2> attachedTest2Collection = new ArrayList<Test2>();
            for (Test2 test2CollectionTest2ToAttach : test1.getTest2Collection()) {
                test2CollectionTest2ToAttach = em.getReference(test2CollectionTest2ToAttach.getClass(), test2CollectionTest2ToAttach.getTest2PK());
                attachedTest2Collection.add(test2CollectionTest2ToAttach);
            }
            test1.setTest2Collection(attachedTest2Collection);
            em.persist(test1);
            for (Test2 test2CollectionTest2 : test1.getTest2Collection()) {
                Test1 oldTest1OfTest2CollectionTest2 = test2CollectionTest2.getTest1();
                test2CollectionTest2.setTest1(test1);
                test2CollectionTest2 = em.merge(test2CollectionTest2);
                if (oldTest1OfTest2CollectionTest2 != null) {
                    oldTest1OfTest2CollectionTest2.getTest2Collection().remove(test2CollectionTest2);
                    oldTest1OfTest2CollectionTest2 = em.merge(oldTest1OfTest2CollectionTest2);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTest1(test1.getIdtest1()) != null) {
                throw new PreexistingEntityException("Test1 " + test1 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Test1 test1) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Test1 persistentTest1 = em.find(Test1.class, test1.getIdtest1());
            Collection<Test2> test2CollectionOld = persistentTest1.getTest2Collection();
            Collection<Test2> test2CollectionNew = test1.getTest2Collection();
            List<String> illegalOrphanMessages = null;
            for (Test2 test2CollectionOldTest2 : test2CollectionOld) {
                if (!test2CollectionNew.contains(test2CollectionOldTest2)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Test2 " + test2CollectionOldTest2 + " since its test1 field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Test2> attachedTest2CollectionNew = new ArrayList<Test2>();
            for (Test2 test2CollectionNewTest2ToAttach : test2CollectionNew) {
                test2CollectionNewTest2ToAttach = em.getReference(test2CollectionNewTest2ToAttach.getClass(), test2CollectionNewTest2ToAttach.getTest2PK());
                attachedTest2CollectionNew.add(test2CollectionNewTest2ToAttach);
            }
            test2CollectionNew = attachedTest2CollectionNew;
            test1.setTest2Collection(test2CollectionNew);
            test1 = em.merge(test1);
            for (Test2 test2CollectionNewTest2 : test2CollectionNew) {
                if (!test2CollectionOld.contains(test2CollectionNewTest2)) {
                    Test1 oldTest1OfTest2CollectionNewTest2 = test2CollectionNewTest2.getTest1();
                    test2CollectionNewTest2.setTest1(test1);
                    test2CollectionNewTest2 = em.merge(test2CollectionNewTest2);
                    if (oldTest1OfTest2CollectionNewTest2 != null && !oldTest1OfTest2CollectionNewTest2.equals(test1)) {
                        oldTest1OfTest2CollectionNewTest2.getTest2Collection().remove(test2CollectionNewTest2);
                        oldTest1OfTest2CollectionNewTest2 = em.merge(oldTest1OfTest2CollectionNewTest2);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = test1.getIdtest1();
                if (findTest1(id) == null) {
                    throw new NonexistentEntityException("The test1 with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Test1 test1;
            try {
                test1 = em.getReference(Test1.class, id);
                test1.getIdtest1();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The test1 with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Test2> test2CollectionOrphanCheck = test1.getTest2Collection();
            for (Test2 test2CollectionOrphanCheckTest2 : test2CollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Test1 (" + test1 + ") cannot be destroyed since the Test2 " + test2CollectionOrphanCheckTest2 + " in its test2Collection field has a non-nullable test1 field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(test1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Test1> findTest1Entities() {
        return findTest1Entities(true, -1, -1);
    }

    public List<Test1> findTest1Entities(int maxResults, int firstResult) {
        return findTest1Entities(false, maxResults, firstResult);
    }

    private List<Test1> findTest1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Test1.class));
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

    public Test1 findTest1(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Test1.class, id);
        } finally {
            em.close();
        }
    }

    public int getTest1Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Test1> rt = cq.from(Test1.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
