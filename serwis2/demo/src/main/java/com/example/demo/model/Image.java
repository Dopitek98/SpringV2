package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Image {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private Long id;
    private String path;
    private String author;

    @OneToMany
    @JoinColumn(name = "ImageId")
    private List<Post> post = new ArrayList<>();

    public Image() {
    }



    public Image(String path, String author) {
        this.path = path;
        this.author = author;
    }

    public Image(String path) {
        this.path = path;
    }

    public Long getImageid() {
        return id;
    }

    public void setImageid(Long imageid) {
        this.id = imageid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
