package com.portfolioRueda.portfolio.Repository;

import com.portfolioRueda.portfolio.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRepository extends JpaRepository<Skill,Long>{
    
}
