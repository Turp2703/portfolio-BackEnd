package com.portfolioRueda.portfolio.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String picture;
    private String name;
    private String description;
    private String link;

    public Proyecto() {
    }
    public Proyecto(String picture, String name, String description, String link) {
        this.picture = picture;
        this.name = name;
        this.description = description;
        this.link = link;
    }
}
