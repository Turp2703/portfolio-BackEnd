package com.portfolioRueda.portfolio.Service;

import com.portfolioRueda.portfolio.Entity.Educacion;
import com.portfolioRueda.portfolio.Repository.IEducacionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService{
    @Autowired IEducacionRepository iEducacionRepository;
    
    public List<Educacion> list() {
        return iEducacionRepository.findAll();
    }

    public Optional<Educacion> getById(int id) {
        return iEducacionRepository.findById(id);
    }
    
    public Optional<Educacion> getByTitle(String title) {
        return iEducacionRepository.findByTitle(title);
    }

    public void save(Educacion educacion) {
        iEducacionRepository.save(educacion);
    }

    public void delete(int id) {
        iEducacionRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iEducacionRepository.existsById(id);
    }
    
    public boolean existsByTitle(String title){
        return iEducacionRepository.existsByTitle(title);
    }
    
}
