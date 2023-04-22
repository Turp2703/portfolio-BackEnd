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
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max= 100, message = "Longitud invalida")
    private String background;
    
    @NotNull
    @Size(min = 1, max= 100, message = "Longitud invalida")
    private String info_picture;
    
    @NotNull
    @Size(min = 1, max= 100, message = "Longitud invalida")
    private String info_name;
    
    @NotNull
    @Size(min = 1, max= 100, message = "Longitud invalida")
    private String info_situation;
    
    @NotNull
    @Size(min = 1, max= 100, message = "Longitud invalida")
    private String info_location;
    
    @NotNull
    @Size(min = 1, max= 100, message = "Longitud invalida")
    private String logo_uns;
    
}
