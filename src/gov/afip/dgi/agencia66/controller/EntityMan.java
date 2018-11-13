/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.afip.dgi.agencia66.controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author u84062
 */
public final class EntityMan {
    
    //private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CFServerPU");
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModelosAG66PU");
    
    public EntityMan() {
        
    }
    
    public static EntityManagerFactory getInstance() {
        return emf;
    }
    
}
