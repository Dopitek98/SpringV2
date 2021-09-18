package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private Long id;
   // private Long ImageId;
    private String comment;
/*
    @ManyToOne
    @JoinColumn(name="id")
    private Image image;

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }
*/
    public Post() {
    }


    public Post(String comment) {
        this.comment = comment;
    }

    public Post(String comment, Image image) {
        this.comment = comment;
       // this.image = image;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
