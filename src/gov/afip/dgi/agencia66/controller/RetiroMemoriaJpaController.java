/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.afip.dgi.agencia66.controller;

import gov.afip.dgi.agencia66.controller.exceptions.NonexistentEntityException;
import gov.afip.dgi.agencia66.controller.exceptions.PreexistingEntityException;
import gov.afip.dgi.agencia66.model.RetiroMemoria;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author u84062
 */
public class RetiroMemoriaJpaController implements Serializable {

    public RetiroMemoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RetiroMemoria retiroMemoria) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(retiroMemoria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRetiroMemoria(retiroMemoria.getId()) != null) {
                throw new PreexistingEntityException("RetiroMemoria " + retiroMemoria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RetiroMemoria retiroMemoria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            retiroMemoria = em.merge(retiroMemoria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = retiroMemoria.getId();
                if (findRetiroMemoria(id) == null) {
                    throw new NonexistentEntityException("The retiroMemoria with id " + id + " no longer exists.");
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
            RetiroMemoria retiroMemoria;
            try {
                retiroMemoria = em.getReference(RetiroMemoria.class, id);
                retiroMemoria.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The retiroMemoria with id " + id + " no longer exists.", enfe);
            }
            em.remove(retiroMemoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RetiroMemoria> findRetiroMemoriaEntities() {
        return findRetiroMemoriaEntities(true, -1, -1);
    }

    public List<RetiroMemoria> findRetiroMemoriaEntities(int maxResults, int firstResult) {
        return findRetiroMemoriaEntities(false, maxResults, firstResult);
    }

    private List<RetiroMemoria> findRetiroMemoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RetiroMemoria.class));
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

    public RetiroMemoria findRetiroMemoria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RetiroMemoria.class, id);
        } finally {
            em.close();
        }
    }

    public int getRetiroMemoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RetiroMemoria> rt = cq.from(RetiroMemoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public boolean exiteRM(int _idCoFi) {
        EntityManager em = getEntityManager();
        TypedQuery<RetiroMemoria> existeRetiro = em.createNamedQuery("RetiroMemoria.findByIdControladorFiscal" ,RetiroMemoria.class);
        existeRetiro.setParameter("idControladorFiscal", _idCoFi);
        List<RetiroMemoria> resultado = existeRetiro.getResultList();
        System.out.println("el id es: " +_idCoFi +" Y encontre: " +resultado.size());
        if(resultado.size() > 0) { return true; } else { return false; }
    }
    
}
