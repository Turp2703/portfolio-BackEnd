package com.portfolioRueda.portfolio.Service;

import com.portfolioRueda.portfolio.Entity.Educacion;
import com.portfolioRueda.portfolio.Interface.IEducacionService;
import com.portfolioRueda.portfolio.Repository.IEducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpEducacionService implements IEducacionService{
    @Autowired IEducacionRepository iEducacionRepository;
    
    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> educacions = iEducacionRepository.findAll();
        return educacions;
    }

    @Override
    public Educacion findEducacion(Long id) {
        Educacion educacion = iEducacionRepository.findById(id).orElse(null);
        return educacion;
    }

    @Override
    public void saveEducacion(Educacion educacion) {
        iEducacionRepository.save(educacion);
    }

    @Override
    public void deleteEducacion(Long id) {
        iEducacionRepository.deleteById(id);
    }
    
}
