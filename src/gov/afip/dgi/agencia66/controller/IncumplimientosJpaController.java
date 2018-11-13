/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.afip.dgi.agencia66.controller;

import gov.afip.dgi.agencia66.controller.exceptions.NonexistentEntityException;
import gov.afip.dgi.agencia66.controller.exceptions.PreexistingEntityException;
import gov.afip.dgi.agencia66.model.Incumplimientos;
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
 * @author u84062
 */
public class IncumplimientosJpaController implements Serializable {

    public IncumplimientosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Incumplimientos incumplimientos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(incumplimientos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findIncumplimientos(incumplimientos.getId()) != null) {
                throw new PreexistingEntityException("Incumplimientos " + incumplimientos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Incumplimientos incumplimientos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            incumplimientos = em.merge(incumplimientos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = incumplimientos.getId();
                if (findIncumplimientos(id) == null) {
                    throw new NonexistentEntityException("The incumplimientos with id " + id + " no longer exists.");
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
            Incumplimientos incumplimientos;
            try {
                incumplimientos = em.getReference(Incumplimientos.class, id);
                incumplimientos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The incumplimientos with id " + id + " no longer exists.", enfe);
            }
            em.remove(incumplimientos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Incumplimientos> findIncumplimientosEntities() {
        return findIncumplimientosEntities(true, -1, -1);
    }

    public List<Incumplimientos> findIncumplimientosEntities(int maxResults, int firstResult) {
        return findIncumplimientosEntities(false, maxResults, firstResult);
    }

    private List<Incumplimientos> findIncumplimientosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Incumplimientos.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Incumplimientos findIncumplimientos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Incumplimientos.class, id);
        } finally {
            em.close();
        }
    }

    public int getIncumplimientosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Incumplimientos> rt = cq.from(Incumplimientos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
