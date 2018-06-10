package com.coby.learning.babynometro.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author luiscobian
 */
@Entity
public class CommentBaby implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment; 
    private double rating;  
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BABIES_ID")
    private Babies babies; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Babies getBabies() {
        return babies;
    }

    public void setBabies(Babies babies) {
        this.babies = babies;
    }

   
    
    
    
}
