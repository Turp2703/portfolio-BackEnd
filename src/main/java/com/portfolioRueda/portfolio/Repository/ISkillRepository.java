package com.portfolioRueda.portfolio.Repository;

import com.portfolioRueda.portfolio.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRepository extends JpaRepository<Skill,Integer>{
    public Optional<Skill> findByName(String name);
    public boolean existsByName(String name);
}
