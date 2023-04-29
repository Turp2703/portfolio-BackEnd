package com.portfolioRueda.portfolio.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoSkill {
    @NotBlank
    private String name;
    
    @NotBlank
    private String percentage;

    public DtoSkill() {
    }
    public DtoSkill(String name, String percentage) {
        this.name = name;
        this.percentage = percentage;
    }
}
