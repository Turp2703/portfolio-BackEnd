package com.portfolioRueda.portfolio.Repository;

import com.portfolioRueda.portfolio.Entity.Footer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFooterRepository extends JpaRepository<Footer,Long> {
    
}