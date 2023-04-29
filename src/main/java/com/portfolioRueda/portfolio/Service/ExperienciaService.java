package com.portfolioRueda.portfolio.Service;

import com.portfolioRueda.portfolio.Entity.Experiencia;
import com.portfolioRueda.portfolio.Repository.IExperienciaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService{
    @Autowired IExperienciaRepository iExperienciaRepository;

    public List<Experiencia> list() {
        return iExperienciaRepository.findAll();
    }

    public Optional<Experiencia> getById(int id){
        return iExperienciaRepository.findById(id);
    }
    
    public Optional<Experiencia> getByName(String name) {
        return iExperienciaRepository.findByName(name);
    }

    public void save(Experiencia experiencia) {
        iExperienciaRepository.save(experiencia);
    }

    public void delete(int id) {
        iExperienciaRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iExperienciaRepository.existsById(id);
    }
    
    public boolean existsByName(String name){
        return iExperienciaRepository.existsByName(name);
    }
}
