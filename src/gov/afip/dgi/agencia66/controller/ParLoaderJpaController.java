/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.afip.dgi.agencia66.controller;

import gov.afip.dgi.agencia66.controller.exceptions.NonexistentEntityException;
import gov.afip.dgi.agencia66.controller.exceptions.PreexistingEntityException;
import gov.afip.dgi.agencia66.model.ParLoader;
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
public class ParLoaderJpaController implements Serializable {

    public ParLoaderJpaController(EntityManagerFactory emf) {
        System.out.println("En el JPA Controller");
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ParLoader parLoader) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(parLoader);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findParLoader(parLoader.getId()) != null) {
                throw new PreexistingEntityException("ParLoader " + parLoader + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ParLoader parLoader) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            parLoader = em.merge(parLoader);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = parLoader.getId();
                if (findParLoader(id) == null) {
                    throw new NonexistentEntityException("The parLoader with id " + id + " no longer exists.");
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
            ParLoader parLoader;
            try {
                parLoader = em.getReference(ParLoader.class, id);
                parLoader.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The parLoader with id " + id + " no longer exists.", enfe);
            }
            em.remove(parLoader);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ParLoader> findParLoaderEntities() {
        return findParLoaderEntities(true, -1, -1);
    }

    public List<ParLoader> findParLoaderEntities(int maxResults, int firstResult) {
        return findParLoaderEntities(false, maxResults, firstResult);
    }

    private List<ParLoader> findParLoaderEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ParLoader.class));
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

    public ParLoader findParLoader(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ParLoader.class, id);
        } finally {
            em.close();
        }
    }

    public int getParLoaderCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ParLoader> rt = cq.from(ParLoader.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
