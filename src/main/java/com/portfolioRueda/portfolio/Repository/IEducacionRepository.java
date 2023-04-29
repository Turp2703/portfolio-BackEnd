package com.portfolioRueda.portfolio.Repository;

import com.portfolioRueda.portfolio.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion,Integer>{
    public Optional<Educacion> findByTitle(String title);
    public boolean existsByTitle(String title);
}
