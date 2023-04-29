package com.portfolioRueda.portfolio.Service;

import com.portfolioRueda.portfolio.Entity.Proyecto;
import com.portfolioRueda.portfolio.Repository.IProyectoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService{
    @Autowired IProyectoRepository iProyectoRepository;

    public List<Proyecto> list() {
        return iProyectoRepository.findAll();
    }

    public Optional<Proyecto> getById(int id){
        return iProyectoRepository.findById(id);
    }
    
    public Optional<Proyecto> getByName(String name) {
        return iProyectoRepository.findByName(name);
    }

    public void save(Proyecto proyecto) {
        iProyectoRepository.save(proyecto);
    }

    public void delete(int id) {
        iProyectoRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iProyectoRepository.existsById(id);
    }
    
    public boolean existsByName(String name){
        return iProyectoRepository.existsByName(name);
    }
}
