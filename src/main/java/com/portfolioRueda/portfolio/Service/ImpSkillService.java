package com.portfolioRueda.portfolio.Service;

import com.portfolioRueda.portfolio.Entity.Skill;
import com.portfolioRueda.portfolio.Interface.ISkillService;
import com.portfolioRueda.portfolio.Repository.ISkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpSkillService implements ISkillService{
    @Autowired ISkillRepository iSkillRepository;
    
    @Override
    public List<Skill> getSkill() {
        List<Skill> skills = iSkillRepository.findAll();
        return skills;
    }

    @Override
    public Skill findSkill(Long id) {
        Skill skill = iSkillRepository.findById(id).orElse(null);
        return skill;
    }

    @Override
    public void saveSkill(Skill skill) {
        iSkillRepository.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        iSkillRepository.deleteById(id);
    }
    
}
