package com.portfolioRueda.portfolio.Interface;

import com.portfolioRueda.portfolio.Entity.Proyecto;
import java.util.List;

public interface IProyectoService {
    //Get all
    public List<Proyecto> getProyecto();
    
    //Get by 'id'
    public Proyecto findProyecto(Long id);
    
    //Save
    public void saveProyecto(Proyecto proyecto);
    
    //Delete
    public void deleteProyecto(Long id);
}
