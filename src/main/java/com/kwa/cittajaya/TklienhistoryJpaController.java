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
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author scumb46
 */
public class TklienhistoryJpaController extends GenericController {

    public TklienhistoryJpaController(EntityManagerFactory emf, EntityManager em) throws Exception {
        super(emf, em);
    }

    public KWAMesg create(Tklienhistory tklienhistory) throws Exception {
        
                checkConnection();
        setError("unknown", "unknownError");
        
        if(tklienhistory==null){
            return setError("PK", "Entity is null");
        }
               
                if(Util.isNullOrSpaces(tklienhistory.getTklienhistoryPK().getKlien())){
            return setError("PK", "Entity is null");
        }
                       if(Util.isNullOrSpaces(tklienhistory.getTklienhistoryPK().getKatalog())){
            return setError("PK", "Entity is null");
        } 
                    
                       TkodegeneratorJpaController tkgj = new TkodegeneratorJpaController(this.getEmf(),this.getEm());
                       tklienhistory.setTanggal(Util.dateToStr(new Date(), "YYMMDD"));
                       
                       Tkodegenerator tkg = new Tkodegenerator("TKHX",tklienhistory.getTklienhistoryPK().getKlien() +tklienhistory.getTklienhistoryPK().getKatalog(),0 );
     tklienhistory.getTklienhistoryPK().setNomer(tkgj.getNumber(tkg));
     
     
        getEm().persist(tklienhistory);
        return setOK("Entry created");
    }

    public List<Tklienhistory> findTklienhistoryEntities() {
        return findTklienhistoryEntities(true, -1, -1);
    }

    public List<Tklienhistory> findTklienhistoryEntities(int maxResults, int firstResult) {
        return findTklienhistoryEntities(false, maxResults, firstResult);
    }

    private List<Tklienhistory> findTklienhistoryEntities(boolean all, int maxResults, int firstResult) {

            CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tklienhistory.class));
            Query q = getEm().createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();

    }

    public Tklienhistory findTklienhistory(TklienhistoryPK id) throws Exception {

                       TkodegeneratorJpaController tkgj = new TkodegeneratorJpaController(this.getEmf(),this.getEm());
                       Tkodegenerator tkg = new Tkodegenerator("TKHX",id.getKlien()+id.getKatalog());
                       Tkodegenerator tmp = tkgj.findTkodegenerator(tkg.getTkodegeneratorPK());
                       //id.setNomer(tmp.getLast());
            return getEm().find(Tklienhistory.class, id);

    }

    public int getTklienhistoryCount() {

            CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
            Root<Tklienhistory> rt = cq.from(Tklienhistory.class);
            cq.select(getEm().getCriteriaBuilder().count(rt));
            Query q = getEm().createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();

    }
    
}
