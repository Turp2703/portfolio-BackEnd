package com.portfolioRueda.portfolio.Security.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogInUser {
    @NotBlank
    private String userName;
    
    @NotBlank
    private String password;
    
    
}
