package com.portfolioRueda.portfolio.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoEducacion {
    @NotBlank
    private String picture;
    
    @NotBlank
    private String title;
    
    @NotBlank
    private String origin;
    
    @NotBlank
    private String year;

    public DtoEducacion() {
    }
    
    public DtoEducacion(String picture, String title, String origin, String year) {
        this.picture = picture;
        this.title = title;
        this.origin = origin;
        this.year = year;
    }
}
