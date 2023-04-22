package com.portfolioRueda.portfolio.Repository;

import com.portfolioRueda.portfolio.Entity.Header;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHeaderRepository extends JpaRepository<Header,Long>{
    
}
