package com.coby.learning.babynometro;

import com.coby.learning.babynometro.controller.DaoBabies;
import com.coby.learning.babynometro.controller.DaoCommentBaby;
import com.coby.learning.babynometro.model.Babies;
import com.coby.learning.babynometro.model.CommentBaby;
import com.google.gson.Gson;
import java.util.List;
import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Main Class
 * @author luiscobian
 */
public class MainClass {
    
    public static final String NAME_PERSISTENCE_UNIT = "com.coby.learning_db"; 
    
    public static void main(String[] args) {
        
        get("/stars-all", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                rspns.type("application/json");
                List<Babies> datos = new DaoBabies().getAll();
                for (int i = 0; i < datos.size(); i++) {
                    List<CommentBaby> comentarios =
                            datos.get(i).getComments();
                    double suma = 0; 
                    double cont= 0;
                    for (CommentBaby comentario : comentarios) {
                        comentario.setBabies(null);
                        cont++; 
                        suma +=comentario.getRating();
                    }
                    if(cont>0)
                        datos.get(i).setRating(suma/cont);
                }
                return new Gson().toJson(datos);
            }
        });
        
        get("/stars", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                rspns.type("application/json");
                System.out.println(rqst.queryParams("id"));
                Long id =Long.parseLong(rqst.queryParams("id"));
                Babies dato = new DaoBabies().getBaby(id); 
                List<CommentBaby> comentarios =
                            dato.getComments();
                double suma=0; 
                double cont=0;
                    for (CommentBaby comentario : comentarios) {
                        comentario.setBabies(null);
                        cont ++; 
                    }
                    if(cont>0)
                    dato.setRating(suma/cont);
                return new Gson().toJson(dato);
            }
        });
        post("/addStars", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                rspns.type("application/json");
                System.out.println(rqst.body());
                Babies baby = new Gson().fromJson(rqst.body(), Babies.class);
                boolean res = new DaoBabies().addBaby(baby);
                System.out.println("Save:" + baby.getName());
                String status = "";
                if (res) 
                    status = "true";

                 else 
                    status = "false";                
                String result = new Gson().toJson(status);
                System.out.println("Result: " + result);
                return result;
            }
        });
        
        post("/addComment", new Route() {
            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                rspns.type("application/json");
                System.out.println(rqst.body());
                CommentBaby comment = new Gson().fromJson(rqst.body(), CommentBaby.class);
                boolean res = new DaoCommentBaby().addCommentBaby(comment);                
                String status = "";
                if (res) 
                    status = "true";

                 else 
                    status = "false";                
                String result = new Gson().toJson(status);
                System.out.println("Result: " + result);
                return result;
            }
        });
        
        
    }
    
}
