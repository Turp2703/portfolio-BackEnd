package com.portfolioRueda.portfolio.Repository;

import com.portfolioRueda.portfolio.Entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion,Long>{
    
}
