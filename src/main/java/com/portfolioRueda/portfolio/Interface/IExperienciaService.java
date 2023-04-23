package com.portfolioRueda.portfolio.Interface;

import com.portfolioRueda.portfolio.Entity.Experiencia;
import java.util.List;

public interface IExperienciaService {
    //Get all
    public List<Experiencia> getExperiencia();
    
    //Get by 'id'
    public Experiencia findExperiencia(Long id);
    
    //Save
    public void saveExperiencia(Experiencia experiencia);
    
    //Delete
    public void deleteExperiencia(Long id);
}
