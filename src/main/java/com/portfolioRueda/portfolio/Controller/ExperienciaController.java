package com.portfolioRueda.portfolio.Controller;

import com.portfolioRueda.portfolio.Entity.Experiencia;
import com.portfolioRueda.portfolio.Interface.IExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ExperienciaController {
    @Autowired IExperienciaService iExperienciaService;
    
    @GetMapping("experiencia/get")
    public List<Experiencia> getExperiencia(){
        return iExperienciaService.getExperiencia();
    }
    
    @GetMapping("experiencia/get/main")
    public Experiencia findExperiencia(){
        return iExperienciaService.findExperiencia((long)1);
    }
    
    @PostMapping("experiencia/post")
    public String createExperiencia(@RequestBody Experiencia experiencia){
        iExperienciaService.saveExperiencia(experiencia);
        return "Create Success";
    }
    
    @DeleteMapping("experiencia/delete/{id}")
    public String deleteExperiencia(@PathVariable Long id){
        iExperienciaService.deleteExperiencia(id);
        return "Delete Success";
    }
    
    @PutMapping("experiencia/put/{id}")
    public String editProfile(@PathVariable Long id, 
                              @RequestParam("logo") String newLogo,
                              @RequestParam("name") String newName,
                              @RequestParam("place") String newPlace){
        Experiencia experiencia = iExperienciaService.findExperiencia(id);
        experiencia.setLogo(newLogo);
        experiencia.setName(newName);
        experiencia.setPlace(newPlace);
        iExperienciaService.saveExperiencia(experiencia);
        return "Edit Success";
    }
}
