package com.portfolioRueda.portfolio.Service;

import com.portfolioRueda.portfolio.Entity.Experiencia;
import com.portfolioRueda.portfolio.Interface.IExperienciaService;
import com.portfolioRueda.portfolio.Repository.IExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpExperienciaService implements IExperienciaService{
    @Autowired IExperienciaRepository iExperienciaRepository;
    
    @Override
    public List<Experiencia> getExperiencia() {
        List<Experiencia> experiencias = iExperienciaRepository.findAll();
        return experiencias;
    }

    @Override
    public Experiencia findExperiencia(Long id) {
        Experiencia experiencia = iExperienciaRepository.findById(id).orElse(null);
        return experiencia;
    }

    @Override
    public void saveExperiencia(Experiencia experiencia) {
        iExperienciaRepository.save(experiencia);
    }

    @Override
    public void deleteExperiencia(Long id) {
        iExperienciaRepository.deleteById(id);
    }
    
}
