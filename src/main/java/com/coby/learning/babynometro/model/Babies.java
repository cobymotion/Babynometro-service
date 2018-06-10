package com.coby.learning.babynometro.model;

import com.sun.istack.internal.Nullable;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author luiscobian
 */
@Entity
public class Babies implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nullable
    private String name;
    @Nullable
    private String phone;    
    @Nullable
    private double altitude;
    @Nullable
    private double latitude; 
    @Nullable
    private String life; 
    @Nullable
    private byte[] photo;
    
    @Nullable
    private double rating; 
    
    @OneToMany(mappedBy = "babies", 
            orphanRemoval = true,
            targetEntity = CommentBaby.class, 
            fetch = FetchType.LAZY) 
    private List<CommentBaby> comments; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getLife() {
        return life;
    }

    public void setLife(String life) {
        this.life = life;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    
    
    public double getRating() {
        double rating=0;
        List<CommentBaby> datos = getComments(); 
        if(datos!=null && datos.size()>0) {
            for(CommentBaby c : datos)
            rating+=c.getRating();
        rating = rating / datos.size(); 
        }
        return rating;
    }
    

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public List<CommentBaby> getComments() {
        return comments;
    }

    public void setComments(List<CommentBaby> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Babies{" + "id=" + id + ", name=" + name + ", phone=" + phone + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Babies other = (Babies) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
    

}
