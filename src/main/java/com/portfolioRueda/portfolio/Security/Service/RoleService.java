package com.portfolioRueda.portfolio.Security.Service;

import com.portfolioRueda.portfolio.Security.Entity.Role;
import com.portfolioRueda.portfolio.Security.Enums.RoleName;
import com.portfolioRueda.portfolio.Security.Repository.IRoleRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {
    @Autowired IRoleRepository iRoleRepository;
    
    public Optional<Role> getByRoleName(RoleName roleName){
        return iRoleRepository.findByRoleName(roleName);
    }
    
    public void save(Role role){
        iRoleRepository.save(role);
    }
}
