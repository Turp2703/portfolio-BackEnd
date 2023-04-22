package com.portfolioRueda.portfolio.Repository;

import com.portfolioRueda.portfolio.Entity.AcercaDe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAcercaDeRepository extends JpaRepository<AcercaDe,Long>{
    
}
