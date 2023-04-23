package com.portfolioRueda.portfolio.Repository;

import com.portfolioRueda.portfolio.Entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia,Long>{
    
}
