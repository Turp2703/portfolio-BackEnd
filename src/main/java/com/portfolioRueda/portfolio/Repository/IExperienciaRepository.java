package com.portfolioRueda.portfolio.Repository;

import com.portfolioRueda.portfolio.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia,Integer>{
    public Optional<Experiencia> findByName(String name);
    public boolean existsByName(String name);
}
