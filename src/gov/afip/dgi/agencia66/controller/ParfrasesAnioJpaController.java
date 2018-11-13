/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.afip.dgi.agencia66.controller;

import gov.afip.dgi.agencia66.model.ParfrasesAnio;
import gov.afip.dgi.agencia66.controller.exceptions.NonexistentEntityException;
import gov.afip.dgi.agencia66.controller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author u84062
 */
public class ParfrasesAnioJpaController implements Serializable {

    public ParfrasesAnioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ParfrasesAnio parfrasesAnio) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(parfrasesAnio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findParfrasesAnio(parfrasesAnio.getAnio()) != null) {
                throw new PreexistingEntityException("ParfrasesAnio " + parfrasesAnio + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ParfrasesAnio parfrasesAnio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            parfrasesAnio = em.merge(parfrasesAnio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = parfrasesAnio.getAnio();
                if (findParfrasesAnio(id) == null) {
                    throw new NonexistentEntityException("The parfrasesAnio with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ParfrasesAnio parfrasesAnio;
            try {
                parfrasesAnio = em.getReference(ParfrasesAnio.class, id);
                parfrasesAnio.getAnio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The parfrasesAnio with id " + id + " no longer exists.", enfe);
            }
            em.remove(parfrasesAnio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ParfrasesAnio> findParfrasesAnioEntities() {
        return findParfrasesAnioEntities(true, -1, -1);
    }

    public List<ParfrasesAnio> findParfrasesAnioEntities(int maxResults, int firstResult) {
        return findParfrasesAnioEntities(false, maxResults, firstResult);
    }

    private List<ParfrasesAnio> findParfrasesAnioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from ParfrasesAnio as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ParfrasesAnio findParfrasesAnio(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ParfrasesAnio.class, id);
        } finally {
            em.close();
        }
    }

    public int getParfrasesAnioCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from ParfrasesAnio as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
