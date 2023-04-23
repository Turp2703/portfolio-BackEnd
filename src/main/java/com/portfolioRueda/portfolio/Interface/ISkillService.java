package com.portfolioRueda.portfolio.Interface;

import com.portfolioRueda.portfolio.Entity.Skill;
import java.util.List;

public interface ISkillService {
    //Get all
    public List<Skill> getSkill();
    
    //Get by 'id'
    public Skill findSkill(Long id);
    
    //Save
    public void saveSkill(Skill skill);
    
    //Delete
    public void deleteSkill(Long id);
}
