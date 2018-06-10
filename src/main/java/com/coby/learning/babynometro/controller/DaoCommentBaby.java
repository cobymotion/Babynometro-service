package com.coby.learning.babynometro.controller;

import com.coby.learning.babynometro.MainClass;
import com.coby.learning.babynometro.model.CommentBaby;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luiscobian
 */
public class DaoCommentBaby {
        
    
    public boolean addCommentBaby(CommentBaby comment){
        EntityManagerFactory factory = 
        Persistence.createEntityManagerFactory(MainClass.NAME_PERSISTENCE_UNIT);
        EntityManager em = factory.createEntityManager(); 
        em.getTransaction().begin(); 
        em.persist(comment);
        em.getTransaction().commit();
        em.refresh(comment);
        em.close();
        factory.close();
        return true;
    }
    
}
