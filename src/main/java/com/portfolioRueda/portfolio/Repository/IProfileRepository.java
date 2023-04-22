package com.portfolioRueda.portfolio.Repository;

import com.portfolioRueda.portfolio.Entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileRepository extends JpaRepository<Profile,Long> {
    
}
