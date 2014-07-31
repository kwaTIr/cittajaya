/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cittajaya;

import com.kwa.cj.modules.t010.T010JpaController;
import com.kwa.cj.modules.t010.T010;
import com.kwa.cittajaya.exceptions.NonexistentEntityException;
import com.kwa.cittajaya.exceptions.PreexistingEntityException;
import com.kwa.core.GenericController;
import com.kwa.core.KWAMesg;
import com.kwa.core.Util;
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
public class TpegawaiJpaController extends GenericController {

    public TpegawaiJpaController(EntityManagerFactory emf, EntityManager em) throws Exception {
        super(emf, em);
    }

    public KWAMesg create(Tpegawai tpegawai) throws PreexistingEntityException, Exception {
        checkConnection();
        setError("unknown", "unknownError");
        if (Util.isNullOrSpaces(tpegawai.getKode())) {
            return setError("Kode", "Entity is null or spaces");
        }

        if (Util.isNullOrSpaces(tpegawai.getNama())) {
            return setError("Nama", "Entity is null or spaces");
        }
if(findTpegawai(tpegawai.getKode())!=null){
        return setError("Kode", "Entity already exist");
}
        T010JpaController t010p = new T010JpaController(getEmf(), getEm());
        T010 t010 = t010p.findT010("TSPG", tpegawai.getStatus());
        if (t010 == null) {
            return setError("Status", "Entity is invalid");
        }

        getEm().persist(tpegawai);
        return setOK("Entry Created");
    }

    public KWAMesg edit(Tpegawai tpegawai) throws NonexistentEntityException, Exception {
        checkConnection();
        setError("unknown", "unknownError");
        if (findTpegawai(tpegawai.getKode()) == null) {
            return setError("Kode", "Entity is invalid");
        }

        if (Util.isNullOrSpaces(tpegawai.getNama())) {
            return setError("Nama", "Entity is null or spaces");
        }

        T010JpaController t010p = new T010JpaController(getEmf(), getEm());
        T010 t010 = t010p.findT010("TSPG", tpegawai.getStatus());
        if (t010 == null) {
            return setError("Status", "Entity is invalid");
        }

        getEm().merge(tpegawai);
        return setOK("Entry Modified");
    }

    public KWAMesg destroy(String id) throws NonexistentEntityException {

        checkConnection();
        setError("unknown", "unknownError");
if(findTpegawai(id)==null){
        return setError("Kode", "Entity doesn't exist");
}
        if (id == null) {
            return setError("kode", "Entity is null or spaces");
        }

        if (Util.isNullOrSpaces(id)) {
            return setError("kode", "Entity is null or spaces");
        }



        Tpegawai tp = getEm().getReference(Tpegawai.class, id);

        getEm().remove(tp);

        return setOK("Entry Deleted");
    }

    public List<Tpegawai> findTpegawaiEntities() {
        return findTpegawaiEntities(true, -1, -1);
    }

    public List<Tpegawai> findTpegawaiEntities(int maxResults, int firstResult) {
        return findTpegawaiEntities(false, maxResults, firstResult);
    }

    private List<Tpegawai> findTpegawaiEntities(boolean all, int maxResults, int firstResult) {

        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Tpegawai.class));
        Query q = getEm().createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();

    }

    public Tpegawai findTpegawai(String id) {
        if (id == null) {
            return null;
        }
        if (id.trim().equalsIgnoreCase("")) {
            return null;
        }

        return getEm().find(Tpegawai.class, id);

    }

    public int getTpegawaiCount() {

        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        Root<Tpegawai> rt = cq.from(Tpegawai.class);
        cq.select(getEm().getCriteriaBuilder().count(rt));
        Query q = getEm().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();

    }
}
