/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.afip.dgi.agencia66.controller;

import gov.afip.dgi.agencia66.model.Agentes;
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
public class AgentesJpaController implements Serializable {

    public AgentesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Agentes agentes) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(agentes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAgentes(agentes.getId()) != null) {
                throw new PreexistingEntityException("Agentes " + agentes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Agentes agentes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            agentes = em.merge(agentes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = agentes.getId();
                if (findAgentes(id) == null) {
                    throw new NonexistentEntityException("The agentes with id " + id + " no longer exists.");
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
            Agentes agentes;
            try {
                agentes = em.getReference(Agentes.class, id);
                agentes.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The agentes with id " + id + " no longer exists.", enfe);
            }
            em.remove(agentes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Agentes> findAgentesEntities() {
        return findAgentesEntities(true, -1, -1);
    }

    public List<Agentes> findAgentesEntities(int maxResults, int firstResult) {
        return findAgentesEntities(false, maxResults, firstResult);
    }

    private List<Agentes> findAgentesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Agentes as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Agentes findAgentes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Agentes.class, id);
        } finally {
            em.close();
        }
    }

    public int getAgentesCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Agentes as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
