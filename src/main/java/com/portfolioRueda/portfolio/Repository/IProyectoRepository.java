package com.portfolioRueda.portfolio.Repository;

import com.portfolioRueda.portfolio.Entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto,Long> {
    
}
