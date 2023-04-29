package com.portfolioRueda.portfolio.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoProyecto {
    @NotBlank
    private String picture;
    
    @NotBlank
    private String name;
    
    @NotBlank
    private String description;

    public DtoProyecto() {
    }
    public DtoProyecto(String picture, String name, String description) {
        this.picture = picture;
        this.name = name;
        this.description = description;
    }
}
