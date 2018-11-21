/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.afip.dgi.agencia66.controller;

import gov.afip.dgi.agencia66.controller.exceptions.NonexistentEntityException;
import gov.afip.dgi.agencia66.controller.exceptions.PreexistingEntityException;
import gov.afip.dgi.agencia66.model.ControladorFiscal;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author u84062
 */
public class ControladorFiscalJpaController implements Serializable {

    private final static Logger LOGGER = Logger.getLogger("gov.afip.dgi.agencia66.controller");
    public ControladorFiscalJpaController(EntityManagerFactory emf) {
        LOGGER.log(Level.INFO, "CF JPA Cntroller");
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public ControladorFiscalJpaController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EntityManager getEntityManager() {
        LOGGER.log(Level.INFO, "Retornando una EM");
        return emf.createEntityManager();
    }

    public void create(ControladorFiscal controladorFiscal) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        LOGGER.log(Level.INFO, "En Create");
        try {
            LOGGER.log(Level.INFO, "En Try");
            em = getEntityManager();
            LOGGER.log(Level.INFO, "Antes de Comenzar la tx");
            em.getTransaction().begin();
            LOGGER.log(Level.INFO, "Antes de persistir");
            em.persist(controladorFiscal);
            LOGGER.log(Level.INFO, "Antes de Commit");
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findControladorFiscal(controladorFiscal.getId()) != null) {
                throw new PreexistingEntityException("ControladorFiscal " + controladorFiscal + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ControladorFiscal controladorFiscal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            controladorFiscal = em.merge(controladorFiscal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = controladorFiscal.getId();
                if (findControladorFiscal(id) == null) {
                    throw new NonexistentEntityException("The controladorFiscal with id " + id + " no longer exists.");
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
            ControladorFiscal controladorFiscal;
            try {
                controladorFiscal = em.getReference(ControladorFiscal.class, id);
                controladorFiscal.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The controladorFiscal with id " + id + " no longer exists.", enfe);
            }
            em.remove(controladorFiscal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ControladorFiscal> findControladorFiscalEntities() {
        return findControladorFiscalEntities(true, -1, -1);
    }

    public List<ControladorFiscal> findControladorFiscalEntities(int maxResults, int firstResult) {
        return findControladorFiscalEntities(false, maxResults, firstResult);
    }

    private List<ControladorFiscal> findControladorFiscalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ControladorFiscal.class));
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

    public ControladorFiscal findControladorFiscal(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ControladorFiscal.class, id);
        } finally {
            em.close();
        }
    }
    

    public int findCFxSolicitud(Double solicitud) {
        ControladorFiscal cf = new ControladorFiscal();
        EntityManager em = getEntityManager();
        Object[] oCf;
        Query q = em.createNativeQuery("Select c.id, c.cuit, c.razon_social from controlador_fiscal c where c.solicitud = " +solicitud);
        System.out.println("Buscando la solicitud: " +solicitud);
        try {
            oCf = (Object[]) q.getSingleResult();
            System.out.println("Encontre el id: " +oCf[0]);
            return (Integer) oCf[0];
        } catch(NoResultException noEncontro) { return 0;}
    }


    public int findCFxCuitPvta(Double cuit, int ptovta) {
        ControladorFiscal cf = new ControladorFiscal();
        EntityManager em = getEntityManager();
        String consulta = "Select c.id, c.razon_social"
                + " from controlador_fiscal c where c.cuit = " +cuit + " and c.puesto_venta = " +ptovta;
        
        Query q = em.createNativeQuery(consulta);
        System.out.println("Consulta es: " +consulta );
        try{
            Object[] oCf = (Object[]) q.getSingleResult();
            System.out.println("Encontre el id: " +oCf[0]);
            return (Integer) oCf[0];
        } catch(NoResultException noEncontro) { return 0; }
    }
    
    
    
    public int getControladorFiscalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ControladorFiscal> rt = cq.from(ControladorFiscal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List findCFSinMemoria(Double cuit) {
        
        EntityManager em = getEntityManager();
        TypedQuery<ControladorFiscal> consultaPorMemoria = em.createNamedQuery("ControladorFiscal.findByCuitYRetiroMemoria" ,ControladorFiscal.class);
        consultaPorMemoria.setParameter("cuit", cuit);
        List<ControladorFiscal> conMemoria = consultaPorMemoria.getResultList();
/*        for(ControladorFiscal a :conMemoria) {
            System.out.println(a.getRazonSocial() +" - Solicitud: " +a.getSolicitud());
        } */
        return conMemoria;
    }
    
     public List findCFSinMemoria() {
        
        EntityManager em = getEntityManager();
        TypedQuery<ControladorFiscal> consultaPorMemoria = em.createNamedQuery("ControladorFiscal.findByRetiroMemoria" ,ControladorFiscal.class);
        List<ControladorFiscal> conMemoria = consultaPorMemoria.getResultList();
        return conMemoria;
    }

    private List obtenerCFDeObj(List resultList) {
        Object[] oCf;
        ControladorFiscal cf;
        List retornoCF = null;
        
        for(int i =0; resultList.size() > i; i++) {
            oCf = (Object[]) resultList.get(i);
            cf = new ControladorFiscal();
            
            cf.setId((Integer) oCf[0]);
            
            retornoCF.add(cf);
        }
        
        return retornoCF;
    }
    
}
