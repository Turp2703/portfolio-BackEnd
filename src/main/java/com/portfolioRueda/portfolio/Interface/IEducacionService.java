package com.portfolioRueda.portfolio.Interface;

import com.portfolioRueda.portfolio.Entity.Educacion;
import java.util.List;

public interface IEducacionService {
    //Get all
    public List<Educacion> getEducacion();
    
    //Get by 'id'
    public Educacion findEducacion(Long id);
    
    //Save
    public void saveEducacion(Educacion educacion);
    
    //Delete
    public void deleteEducacion(Long id);
}
