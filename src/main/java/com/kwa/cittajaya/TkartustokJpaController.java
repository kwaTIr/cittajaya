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
 * @author scumb46
 */
public class TkartustokJpaController extends GenericController {

    public TkartustokJpaController(EntityManagerFactory emf, EntityManager em) throws Exception {
        super(emf, em);
    }

    public KWAMesg create(Tkartustok tkartustok) throws Exception {
        checkConnection();
        setError("unknown", "unknownError");

        if (tkartustok == null) {
            return setError("PK", "Entity is null or spaces");
        }
        if (tkartustok.getTkartustokPK() == null) {
            return setError("PK", "Entity is null or spaces");
        }
        if (Util.isNullOrSpaces(tkartustok.getTkartustokPK().getKodekatalog())) {
            return setError("Katalog", "Entity is null or spaces");
        }

        //preparing prev data
        TkodegeneratorPK tgensearch = new TkodegeneratorPK("TKST", tkartustok.getTkartustokPK().getKodekatalog());

        TkodegeneratorJpaController tgenp = new TkodegeneratorJpaController(this.getEmf(), this.getEm());
        Tkodegenerator tgen = tgenp.findTkodegenerator(tgensearch);
        int awal = 0;

        long nourut = 1;
        if (tgen != null) {

            Tkartustok tkartustoktmp = findTkartustok(new TkartustokPK(tgen.getLast(), tkartustok.getTkartustokPK().getKodekatalog()));
            awal = tkartustoktmp.getAkhir();
            nourut = tgenp.getNumber(tgen);
        }
        int akhir = awal + tkartustok.getTransaksi();
        tkartustok.setAkhir(akhir);
        tkartustok.getTkartustokPK().setNourut(nourut);

        getEm().persist(tkartustok);
        return setOK("entry created");

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

    public Tkartustok findTkartustok(TkartustokPK id) {

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
