package com.coby.learning.babynometro.test;

import com.coby.learning.babynometro.controller.DaoBabies;
import com.coby.learning.babynometro.controller.DaoCommentBaby;
import com.coby.learning.babynometro.model.Babies;
import com.coby.learning.babynometro.model.CommentBaby;
import com.google.gson.Gson;
import java.util.List;

/**
 * Test Class
 *
 * @author luiscobian
 */
public class Prueba {

    public static void main(String[] args) {
        System.out.println("Hola");
        try {
      /*  Babies b = new Babies(); 
        b.setId(0L);
        b.setName("LUCILA PEREZ");
        b.setPhone("9389834");
        
        
            DaoBabies dao  = new DaoBabies();
            dao.addBaby(b);
        */    
            //Babies b = dao.getBaby(101L); 
            // System.out.println(b);
            //dao.addBaby(b);                         
            //for(Babies bb : dao.getAll())
            //    System.out.println(bb);

            /*CommentBaby comment = new CommentBaby();
            comment.setComment("Muy buenas peliculas");
            Babies i = new Babies();
            Long id = 1L; 
            i.setId(id);
            comment.setBabies(i);
            comment.setRating(5);
            DaoCommentBaby dcb = new DaoCommentBaby();
            dcb.addCommentBaby(comment);
            System.out.println("Se grabo. ");*/
           
            DaoBabies dao = new DaoBabies();
            List<Babies> babies = dao.getAll();
            for (Babies baby : babies) {
                  baby.getComments().get(0).setBabies(null);
            }
            System.out.println(new Gson().
                    toJson(babies));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
