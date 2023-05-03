package com.portfolioRueda.portfolio.Controller;

import com.portfolioRueda.portfolio.Dto.DtoSkill;
import com.portfolioRueda.portfolio.Entity.Skill;
import com.portfolioRueda.portfolio.Security.Controller.msg;
import com.portfolioRueda.portfolio.Service.SkillService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("skill")
//Local
@CrossOrigin(origins = "http://localhost:4200")
//Deploy
//@CrossOrigin(origins = "https://rueda-portfolio-frontend.web.app/")
public class SkillController {
    @Autowired SkillService skillService;
    
    @GetMapping("/get")
    public ResponseEntity<List<Skill>> list(){
        List<Skill> list = skillService.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<Skill> list(@PathVariable("id") int id){
        if(!skillService.existsById(id)){
            return new ResponseEntity(new msg("No existe una skill con esa id"), HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = skillService.getById(id).get();
        return new ResponseEntity(skill,HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/post")
    public ResponseEntity<?> create(@RequestBody DtoSkill dtoSkill){
        if(StringUtils.isBlank(dtoSkill.getName())){
            return new ResponseEntity(new msg("Nombre obligatorio."), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoSkill.getPercentage())){
            return new ResponseEntity(new msg("Porcentaje obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(skillService.existsByName(dtoSkill.getName())){
            return new ResponseEntity(new msg("Skill con ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = new Skill(dtoSkill.getName(), dtoSkill.getPercentage());
        skillService.save(skill);
        
        return new ResponseEntity(new msg("Skill agregada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/put/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkill dtoSkill){
        if(!skillService.existsById(id)){
            return new ResponseEntity(new msg("No existe una skill con esa id"), HttpStatus.BAD_REQUEST);
        }
        if(skillService.existsByName(dtoSkill.getName()) && skillService.getByName(dtoSkill.getName()).get().getId() != id){
            return new ResponseEntity(new msg("Skill con ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoSkill.getName())){
            return new ResponseEntity(new msg("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoSkill.getPercentage())){
            return new ResponseEntity(new msg("Porcentaje obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = skillService.getById(id).get();
        skill.setName(dtoSkill.getName());
        skill.setPercentage(dtoSkill.getPercentage());
        
        skillService.save(skill);
        
        return new ResponseEntity(new msg("Skill actualizada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!skillService.existsById(id)){
            return new ResponseEntity(new msg("No existe una Skill con esa id"), HttpStatus.BAD_REQUEST);
        }
        
        skillService.delete(id);
        
        return new ResponseEntity(new msg("Skill eliminada"), HttpStatus.OK);
    }
}
