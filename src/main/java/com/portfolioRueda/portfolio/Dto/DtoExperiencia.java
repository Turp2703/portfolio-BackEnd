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
    
    @NotBlank
    private String periodStart;
    
    @NotBlank
    private String periodEnd;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String logo, String name, String place, String periodStart, String periodEnd) {
        this.logo = logo;
        this.name = name;
        this.place = place;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
    }
}
