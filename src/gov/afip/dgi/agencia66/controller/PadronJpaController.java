/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.afip.dgi.agencia66.controller;

import gov.afip.dgi.agencia66.model.Padron;
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
public class PadronJpaController implements Serializable {

    public PadronJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Padron padron) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(padron);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPadron(padron.getId()) != null) {
                throw new PreexistingEntityException("Padron " + padron + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Padron padron) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            padron = em.merge(padron);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = padron.getId();
                if (findPadron(id) == null) {
                    throw new NonexistentEntityException("The padron with id " + id + " no longer exists.");
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
            Padron padron;
            try {
                padron = em.getReference(Padron.class, id);
                padron.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The padron with id " + id + " no longer exists.", enfe);
            }
            em.remove(padron);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Padron> findPadronEntities() {
        return findPadronEntities(true, -1, -1);
    }

    public List<Padron> findPadronEntities(int maxResults, int firstResult) {
        return findPadronEntities(false, maxResults, firstResult);
    }

    private List<Padron> findPadronEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Padron as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Padron findPadron(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Padron.class, id);
        } finally {
            em.close();
        }
    }

    public int getPadronCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Padron as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
