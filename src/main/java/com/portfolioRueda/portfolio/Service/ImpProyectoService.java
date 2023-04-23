package com.portfolioRueda.portfolio.Service;

import com.portfolioRueda.portfolio.Entity.Proyecto;
import com.portfolioRueda.portfolio.Interface.IProyectoService;
import com.portfolioRueda.portfolio.Repository.IProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpProyectoService implements IProyectoService{
    @Autowired IProyectoRepository iProyectoRepository;
    
    @Override
    public List<Proyecto> getProyecto() {
        List<Proyecto> proyectos = iProyectoRepository.findAll();
        return proyectos;
    }

    @Override
    public Proyecto findProyecto(Long id) {
        Proyecto proyecto = iProyectoRepository.findById(id).orElse(null);
        return proyecto;
    }

    @Override
    public void saveProyecto(Proyecto proyecto) {
        iProyectoRepository.save(proyecto);
    }

    @Override
    public void deleteProyecto(Long id) {
        iProyectoRepository.deleteById(id);
    }
    
}
