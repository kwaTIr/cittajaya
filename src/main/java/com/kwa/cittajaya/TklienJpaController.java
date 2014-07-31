/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwa.cittajaya;

import com.kwa.cj.modules.t010.T010JpaController;
import com.kwa.cj.modules.t010.T010;
import com.kwa.cittajaya.exceptions.NonexistentEntityException;
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
public class TklienJpaController extends GenericController {

    public TklienJpaController(EntityManagerFactory emf, EntityManager em) throws Exception {
        super(emf, em);
    }

    public KWAMesg create(Tklien tklien) throws Exception {
        checkConnection();
        setError("unknown", "unknownError");

        if (Util.isNullOrSpaces(tklien.getKode())) {
            return setError("Kode", "Entity is null or spaces");
        }
        if (Util.isNullOrSpaces(tklien.getNama())) {
            return setError("Nama", "Entity is null or spaces");
        }

        if (Util.isNullOrSpaces(tklien.getAlamat())) {
            return setError("Alamat", "Entity is null or spaces");
        }

        if (Util.isNullOrSpaces(tklien.getKota())) {
            return setError("Kota", "Entity is null or spaces");
        }
        T010JpaController t010p = new T010JpaController(getEmf(), getEm());
        T010 t010 = t010p.findT010("TKOT", tklien.getKota());
        if (t010 == null) {
            return setError("Kota", "Entity is invalid");
        }

        if (Util.isNullOrSpaces(tklien.getKodepos())) {
            return setError("Kodepos", "Entity is null or spaces");
        }

        if (Util.isNullOrSpaces(tklien.getNamakontak())) {
            return setError("Kontak", "Entity is null or spaces");
        }

        if (Util.isNullOrSpaces(tklien.getTelp())) {
            return setError("Telp", "Entity is null or spaces");
        }
        getEm().persist(tklien);
        return setOK("Entry Created");
    }

    public KWAMesg edit(Tklien tklien) throws NonexistentEntityException, Exception {
        checkConnection();
        setError("unknown", "unknownError");

        if (Util.isNullOrSpaces(tklien.getKode())) {
            return setError("Kode", "Entity is null or spaces");
        }

        if (findTklien(tklien.getKode()) == null) {
            return setError("Primary Key", "Entry doesn't exist");
        }

        if (Util.isNullOrSpaces(tklien.getNama())) {
            return setError("Nama", "Entity is null or spaces");
        }

        if (Util.isNullOrSpaces(tklien.getAlamat())) {
            return setError("Alamat", "Entity is null or spaces");
        }

        if (Util.isNullOrSpaces(tklien.getKota())) {
            return setError("Kota", "Entity is null or spaces");
        }
        T010JpaController t010p = new T010JpaController(getEmf(), getEm());
        T010 t010 = t010p.findT010("TKOT", tklien.getKota());
        if (t010 == null) {
            return setError("Kota", "Entity is invalid");
        }

        if (Util.isNullOrSpaces(tklien.getKodepos())) {
            return setError("Kodepos", "Entity is null or spaces");
        }

        if (Util.isNullOrSpaces(tklien.getNamakontak())) {
            return setError("Kodepos", "Entity is null or spaces");
        }

        if (Util.isNullOrSpaces(tklien.getTelp())) {
            return setError("Telp", "Entity is null or spaces");
        }
        getEm().merge(tklien);
        return setOK("Entry Modified");
    }

    public KWAMesg destroy(String id) throws NonexistentEntityException {
        checkConnection();
        setError("unknown", "unknownError");
        if (Util.isNullOrSpaces(id)) {
            return setError("kode", "Entity is null or spaces");
        }
        if (findTklien(id) == null) {
            return setError("Primary Key", "Entry doesn't exist");
        }
        Tklien tklien = getEm().getReference(Tklien.class, id);
        getEm().remove(tklien);

        return setOK("Entry Deleted");
    }

    public List<Tklien> findTklienEntities() {
        return findTklienEntities(true, -1, -1);
    }

    public List<Tklien> findTklienEntities(int maxResults, int firstResult) {
        return findTklienEntities(false, maxResults, firstResult);
    }

    private List<Tklien> findTklienEntities(boolean all, int maxResults, int firstResult) {
        checkConnection();

        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Tklien.class));
        Query q = getEm().createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();

    }

    public Tklien findTklien(String id) {
        checkConnection();
                if (Util.isNullOrSpaces(id)) {
            return null;
        }
        return getEm().find(Tklien.class, id);

    }

    public int getTklienCount() {
        checkConnection();
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        Root<Tklien> rt = cq.from(Tklien.class);
        cq.select(getEm().getCriteriaBuilder().count(rt));
        Query q = getEm().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();

    }
}
