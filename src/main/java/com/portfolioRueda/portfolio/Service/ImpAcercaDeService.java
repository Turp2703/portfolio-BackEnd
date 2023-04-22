package com.portfolioRueda.portfolio.Service;

import com.portfolioRueda.portfolio.Entity.AcercaDe;
import com.portfolioRueda.portfolio.Interface.IAcercaDeService;
import com.portfolioRueda.portfolio.Repository.IAcercaDeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpAcercaDeService implements IAcercaDeService{
    @Autowired IAcercaDeRepository iAcercaDeRepository;
    
    @Override
    public List<AcercaDe> getAcercaDe() {
        List<AcercaDe> acercaDes = iAcercaDeRepository.findAll();
        return acercaDes;
    }

    @Override
    public AcercaDe findAcercaDe(Long id) {
        AcercaDe acercaDe = iAcercaDeRepository.findById(id).orElse(null);
        return acercaDe;
    }

    @Override
    public void saveAcercaDe(AcercaDe acercaDe) {
        iAcercaDeRepository.save(acercaDe);
    }

    @Override
    public void deleteAcercaDe(Long id) {
        iAcercaDeRepository.deleteById(id);
    }
    
}
