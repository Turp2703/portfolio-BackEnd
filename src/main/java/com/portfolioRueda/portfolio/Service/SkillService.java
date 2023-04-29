package com.portfolioRueda.portfolio.Service;

import com.portfolioRueda.portfolio.Entity.Skill;
import com.portfolioRueda.portfolio.Repository.ISkillRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillService{
    @Autowired ISkillRepository iSkillRepository;
    
    public List<Skill> list() {
        return iSkillRepository.findAll();
    }

    public Optional<Skill> getById(int id){
        return iSkillRepository.findById(id);
    }
    
    public Optional<Skill> getByName(String name) {
        return iSkillRepository.findByName(name);
    }

    public void save(Skill skill) {
        iSkillRepository.save(skill);
    }

    public void delete(int id) {
        iSkillRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iSkillRepository.existsById(id);
    }
    
    public boolean existsByName(String name){
        return iSkillRepository.existsByName(name);
    }
}
