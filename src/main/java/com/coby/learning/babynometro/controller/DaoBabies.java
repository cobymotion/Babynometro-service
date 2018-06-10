package com.coby.learning.babynometro.controller;

import com.coby.learning.babynometro.MainClass;
import com.coby.learning.babynometro.model.Babies;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author luiscobian
 */
public class DaoBabies {
    
    public List<Babies> getAll(){
        EntityManagerFactory factory = 
        Persistence.createEntityManagerFactory(MainClass.NAME_PERSISTENCE_UNIT);
        EntityManager em = factory.createEntityManager(); 
        Query q = em.createQuery("select t from Babies t");
        List<Babies> todoList = q.getResultList();
        em.close();
        factory.close();
        return todoList; 
    }
    
     public Babies getBaby(long id){
        EntityManagerFactory factory = 
        Persistence.createEntityManagerFactory(MainClass.NAME_PERSISTENCE_UNIT);
        EntityManager em = factory.createEntityManager(); 
        Babies baby = em.find(Babies.class, id);
        em.close();
        factory.close();
        return baby; 
    }
    
    public boolean addBaby(Babies baby){
        EntityManagerFactory factory = 
        Persistence.createEntityManagerFactory(MainClass.NAME_PERSISTENCE_UNIT);
        EntityManager em = factory.createEntityManager(); 
        em.getTransaction().begin(); 
        em.persist(baby);
        em.getTransaction().commit();        
        em.close();
        factory.close();
        return true;
    }
    
    public boolean removeBaby(Babies baby){
        EntityManagerFactory factory = 
        Persistence.createEntityManagerFactory(MainClass.NAME_PERSISTENCE_UNIT);
        EntityManager em = factory.createEntityManager(); 
        em.getTransaction().begin(); 
        baby = em.merge(baby);
        em.remove(baby);
        em.getTransaction().commit();
        em.close();
        return true;
    }
    
}
