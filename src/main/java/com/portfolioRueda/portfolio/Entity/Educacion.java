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
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String picture;
    private String title;
    private String origin;
    private String year;

    public Educacion() {
    }
    public Educacion(String picture, String title, String origin, String year) {
        this.picture = picture;
        this.title = title;
        this.origin = origin;
        this.year = year;
    }
}
