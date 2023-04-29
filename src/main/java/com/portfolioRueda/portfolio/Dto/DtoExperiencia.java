package com.portfolioRueda.portfolio.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoExperiencia {  
    @NotBlank
    private String logo;
    
    @NotBlank
    private String name;
    
    @NotBlank
    private String place;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String logo, String name, String place) {
        this.logo = logo;
        this.name = name;
        this.place = place;
    }
}
