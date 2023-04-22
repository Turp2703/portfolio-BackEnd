package com.portfolioRueda.portfolio.Interface;

import com.portfolioRueda.portfolio.Entity.AcercaDe;
import java.util.List;

public interface IAcercaDeService {
    //Get all
    public List<AcercaDe> getAcercaDe();
    
    //Get by 'id'
    public AcercaDe findAcercaDe(Long id);
    
    //Save
    public void saveAcercaDe(AcercaDe acercaDe);
    
    //Delete
    public void deleteAcercaDe(Long id);
}
