package com.portfolioRueda.portfolio.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    public Educacion() {
    }
    public Educacion(String picture, String title, String origin) {
        this.picture = picture;
        this.title = title;
        this.origin = origin;
    }
}
