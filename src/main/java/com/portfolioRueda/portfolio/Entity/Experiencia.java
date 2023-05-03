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
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String logo;
    private String name;
    private String place;
    private String periodStart;
    private String periodEnd;

    public Experiencia() {
    }
    public Experiencia(String logo, String name, String place, String periodStart, String periodEnd) {
        this.logo = logo;
        this.name = name;
        this.place = place;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
    }
}
