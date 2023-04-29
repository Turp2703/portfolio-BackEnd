package com.portfolioRueda.portfolio.Controller;

import com.portfolioRueda.portfolio.Entity.Skill;
import com.portfolioRueda.portfolio.Interface.ISkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SkillController {
    @Autowired ISkillService iSkillService;
    
    @GetMapping("skill/get")
    public List<Skill> getSkill(){
        return iSkillService.getSkill();
    }
    
    @GetMapping("skill/get/{id}")
    public Skill findSkill(@PathVariable Long id){
        return iSkillService.findSkill(id);
    }
    
    @GetMapping("skill/get/main")
    public Skill findSkill(){
        return iSkillService.findSkill((long)1);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("skill/post")
    public String createSkill(@RequestBody Skill skill){
        iSkillService.saveSkill(skill);
        return "Create Success";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("skill/delete/{id}")
    public String deleteSkill(@PathVariable Long id){
        iSkillService.deleteSkill(id);
        return "Delete Success";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("skill/put/{id}")
    public String editSkill(@PathVariable Long id, 
                              @RequestParam("name") String newName,
                              @RequestParam("percentage") String newPercentage){
        Skill skill = iSkillService.findSkill(id);
        skill.setName(newName);
        skill.setPercentage(newPercentage);
        iSkillService.saveSkill(skill);
        return "Edit Success";
    }
}
