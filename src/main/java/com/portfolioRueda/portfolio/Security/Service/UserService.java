package com.portfolioRueda.portfolio.Security.Service;

import com.portfolioRueda.portfolio.Security.Entity.User;
import com.portfolioRueda.portfolio.Security.Repository.IUserRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired IUserRepository iUserRepository;
    
    public Optional<User> getByUserName(String userName){
        return iUserRepository.findByUserName(userName);
    }
    
    public boolean existsByUserName(String userName){
        return iUserRepository.existsByUserName(userName);
    }
    
    public void save(User user){
        iUserRepository.save(user);
    }
}
