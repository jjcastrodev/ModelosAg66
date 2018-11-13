/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.afip.dgi.agencia66.controller;

import gov.afip.dgi.agencia66.model.ParCaracter;
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
public class ParCaracterJpaController implements Serializable {

    public ParCaracterJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ParCaracter parCaracter) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(parCaracter);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findParCaracter(parCaracter.getId()) != null) {
                throw new PreexistingEntityException("ParCaracter " + parCaracter + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ParCaracter parCaracter) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            parCaracter = em.merge(parCaracter);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = parCaracter.getId();
                if (findParCaracter(id) == null) {
                    throw new NonexistentEntityException("The parCaracter with id " + id + " no longer exists.");
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
            ParCaracter parCaracter;
            try {
                parCaracter = em.getReference(ParCaracter.class, id);
                parCaracter.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The parCaracter with id " + id + " no longer exists.", enfe);
            }
            em.remove(parCaracter);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ParCaracter> findParCaracterEntities() {
        return findParCaracterEntities(true, -1, -1);
    }

    public List<ParCaracter> findParCaracterEntities(int maxResults, int firstResult) {
        return findParCaracterEntities(false, maxResults, firstResult);
    }

    private List<ParCaracter> findParCaracterEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from ParCaracter as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ParCaracter findParCaracter(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ParCaracter.class, id);
        } finally {
            em.close();
        }
    }

    public int getParCaracterCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from ParCaracter as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
