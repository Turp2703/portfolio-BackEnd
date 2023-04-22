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
public class AcercaDe {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max= 254, message = "Longitud invalida")
    private String data1;
    
    @NotNull
    @Size(min = 1, max= 254, message = "Longitud invalida")
    private String data2;
}
