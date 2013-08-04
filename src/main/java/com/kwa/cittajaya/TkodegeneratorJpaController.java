/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cittajaya;

import com.kwa.core.GenericController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author scumb46
 */
public class TkodegeneratorJpaController extends GenericController {

    public TkodegeneratorJpaController(EntityManagerFactory emf, EntityManager em) throws Exception {
        super(emf, em);
    }

    public String getNumber(Tkodegenerator tkodegenerator) throws  Exception {
        
                checkConnection();
        setError("unknown", "unknownError");
        Tkodegenerator tmp =  findTkodegenerator(tkodegenerator.tkodegeneratorPK);
        if(tmp==null){
            tkodegenerator.setLast(1);
            getEm().persist(tkodegenerator);
        }else{
            tkodegenerator.setLast(tmp.getLast()+1);
            getEm().merge(tkodegenerator);
        }
        
        return String.format("%010d",tkodegenerator.getLast());
    }

    public List<Tkodegenerator> findTkodegeneratorEntities() {
        return findTkodegeneratorEntities(true, -1, -1);
    }

    public List<Tkodegenerator> findTkodegeneratorEntities(int maxResults, int firstResult) {
        return findTkodegeneratorEntities(false, maxResults, firstResult);
    }

    private List<Tkodegenerator> findTkodegeneratorEntities(boolean all, int maxResults, int firstResult) {

            CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tkodegenerator.class));
            Query q = getEm().createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();

    }

    public Tkodegenerator findTkodegenerator(TkodegeneratorPK id) {
 
            return getEm().find(Tkodegenerator.class, id);
 
    }

    public int getTkodegeneratorCount() {

            CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
            Root<Tkodegenerator> rt = cq.from(Tkodegenerator.class);
            cq.select(getEm().getCriteriaBuilder().count(rt));
            Query q = getEm().createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();

    }
    
}
