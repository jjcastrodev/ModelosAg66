/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.afip.dgi.agencia66.controller;

import gov.afip.dgi.agencia66.model.Tramites;
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
public class TramitesJpaController implements Serializable {

    public TramitesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tramites tramites) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tramites);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTramites(tramites.getId()) != null) {
                throw new PreexistingEntityException("Tramites " + tramites + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tramites tramites) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tramites = em.merge(tramites);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tramites.getId();
                if (findTramites(id) == null) {
                    throw new NonexistentEntityException("The tramites with id " + id + " no longer exists.");
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
            Tramites tramites;
            try {
                tramites = em.getReference(Tramites.class, id);
                tramites.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tramites with id " + id + " no longer exists.", enfe);
            }
            em.remove(tramites);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tramites> findTramitesEntities() {
        return findTramitesEntities(true, -1, -1);
    }

    public List<Tramites> findTramitesEntities(int maxResults, int firstResult) {
        return findTramitesEntities(false, maxResults, firstResult);
    }

    private List<Tramites> findTramitesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Tramites as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Tramites findTramites(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tramites.class, id);
        } finally {
            em.close();
        }
    }

    public int getTramitesCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Tramites as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
