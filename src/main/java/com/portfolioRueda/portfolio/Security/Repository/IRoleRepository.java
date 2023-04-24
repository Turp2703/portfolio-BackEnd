package com.portfolioRueda.portfolio.Security.Repository;

import com.portfolioRueda.portfolio.Security.Entity.Role;
import com.portfolioRueda.portfolio.Security.Enums.RoleName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer>{
    Optional<Role> findByRoleName(RoleName roleName);
}
