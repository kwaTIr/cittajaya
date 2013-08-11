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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author arinegara
 */
public class TtransbrgitemJpaController extends GenericController {

    public TtransbrgitemJpaController(EntityManagerFactory emf, EntityManager em) throws Exception {
        super(emf, em);
    }

    public KWAMesg create(Ttransbrgitem ttransbrgitem) throws PreexistingEntityException, Exception {
        checkConnection();
        setError("unknown", "unknownError");

        if (ttransbrgitem.getTtransbrgitemPK() == null) {
            return setError("PK", "Entity is null or spaces");
        }

        TtransbrgheaderJpaController ttbhp = new TtransbrgheaderJpaController(getEmf(), getEm());
        Ttransbrgheader ttbh = ttbhp.findTtransbrgheader(ttransbrgitem.getTtransbrgitemPK().getKode());
        if (ttbh == null) {
            return setError("HeaderCode", "Entity is invalid");
        }

        TkatalogJpaController tkp = new TkatalogJpaController(getEmf(), getEm());
        Tkatalog tk = tkp.findTkatalog(ttransbrgitem.getTtransbrgitemPK().getKodekatalog());
        if (tk == null) {
            return setError("katalog", "Entity is invalid");
        }


        if (Double.isNaN(ttransbrgitem.getJumlah())) {
            return setError("jumlah", "Entity is null");
        }
        if (ttransbrgitem.getJumlah() <= 0) {
            return setError("jumlah", "Entity is invalid");
        }

        T010JpaController t010p = new T010JpaController(getEmf(), getEm());
        T010 t010 = t010p.findT010("TSB", ttransbrgitem.getSatuan());
        if (t010 == null) {
            return setError("Satuan", "Entity is invalid");
        }

        if (Double.isNaN(ttransbrgitem.getHarga())) {
            return setError("Harga", "Entity is null");
        }
        if (ttransbrgitem.getJumlah() <= 0) {
            return setError("Harga", "Entity is invalid");
        }

        ArrayList diskons = Util.extractDisc(ttransbrgitem.getDiscount());
        if (diskons == null) {
            return setError("discount", "Entity is invalid");
        }



        getEm().persist(ttransbrgitem);
        return setOK("Entry Created");

    }

    public KWAMesg edit(Ttransbrgitem ttransbrgitem) throws NonexistentEntityException, Exception {
        if (ttransbrgitem.getTtransbrgitemPK() == null) {
            return setError("PK", "Entity is null or spaces");
        }

        TtransbrgheaderJpaController ttbhp = new TtransbrgheaderJpaController(getEmf(), getEm());
        Ttransbrgheader ttbh = ttbhp.findTtransbrgheader(ttransbrgitem.getTtransbrgitemPK().getKode());
        if (ttbh == null) {
            return setError("HeaderCode", "Entity is invalid");
        }

        TkatalogJpaController tkp = new TkatalogJpaController(getEmf(), getEm());
        Tkatalog tk = tkp.findTkatalog(ttransbrgitem.getTtransbrgitemPK().getKodekatalog());
        if (tk == null) {
            return setError("katalog", "Entity is invalid");
        }


        if (findTtransbrgitem(ttransbrgitem.getTtransbrgitemPK()) == null) {
            return setError("Key", "Entity is invalid");
        }

        if (Double.isNaN(ttransbrgitem.getJumlah())) {
            return setError("jumlah", "Entity is null");
        }
        if (ttransbrgitem.getJumlah() <= 0) {
            return setError("jumlah", "Entity is invalid");
        }

        T010JpaController t010p = new T010JpaController(getEmf(), getEm());
        T010 t010 = t010p.findT010("TSB", ttransbrgitem.getSatuan());
        if (t010 == null) {
            return setError("Satuan", "Entity is invalid");
        }

        if (Double.isNaN(ttransbrgitem.getHarga())) {
            return setError("Harga", "Entity is null");
        }
        if (ttransbrgitem.getJumlah() <= 0) {
            return setError("Harga", "Entity is invalid");
        }

        ArrayList diskons = Util.extractDisc(ttransbrgitem.getDiscount());
        if (diskons == null) {
            return setError("discount", "Entity is invalid");
        }



        getEm().merge(ttransbrgitem);
        return setOK("Entry Modified");
    }

    public KWAMesg destroy(TtransbrgitemPK id) throws Exception {
        if (id == null) {
            return setError("PK", "Entity is null or spaces");
        }

        TtransbrgheaderJpaController ttbhp = new TtransbrgheaderJpaController(getEmf(), getEm());
        Ttransbrgheader ttbh = ttbhp.findTtransbrgheader(id.getKode());
        if (ttbh == null) {
            return setError("HeaderCode", "Entity is invalid");
        }

        TkatalogJpaController tkp = new TkatalogJpaController(getEmf(), getEm());
        Tkatalog tk = tkp.findTkatalog(id.getKodekatalog());
        if (tk == null) {
            return setError("katalog", "Entity is invalid");
        }


        if (findTtransbrgitem(id) == null) {
            return setError("Key", "Entity is invalid");
        }

        getEm().remove(id);
        return setOK("Entry Deleted");
    }

    public List<Ttransbrgitem> findTtransbrgitemEntities() {
        return findTtransbrgitemEntities(true, -1, -1);
    }

    public List<Ttransbrgitem> findTtransbrgitemEntities(int maxResults, int firstResult) {
        return findTtransbrgitemEntities(false, maxResults, firstResult);
    }

    private List<Ttransbrgitem> findTtransbrgitemEntities(boolean all, int maxResults, int firstResult) {

        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Ttransbrgitem.class));
        Query q = getEm().createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();

    }
    
    public List<Ttransbrgitem> findTtransbrgitem(String kode) {
                checkConnection();

        Query q = getEm().createNamedQuery("Ttransbrgitem.findByKode").setParameter("kode", kode);

        return q.getResultList();
        //return getEm().find(Ttransbrgitem.class, kode);

    }
    public Ttransbrgitem findTtransbrgitem(TtransbrgitemPK id) {

        return getEm().find(Ttransbrgitem.class, id);

    }

    public int getTtransbrgitemCount() {

        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        Root<Ttransbrgitem> rt = cq.from(Ttransbrgitem.class);
        cq.select(getEm().getCriteriaBuilder().count(rt));
        Query q = getEm().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();

    }
}
