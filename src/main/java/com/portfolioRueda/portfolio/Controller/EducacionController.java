package com.portfolioRueda.portfolio.Controller;

import com.portfolioRueda.portfolio.Entity.Educacion;
import com.portfolioRueda.portfolio.Interface.IEducacionService;
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
public class EducacionController {
    @Autowired IEducacionService iEducacionService;
    
    @GetMapping("educacion/get")
    public List<Educacion> getEducacion(){
        return iEducacionService.getEducacion();
    }
    
    @GetMapping("educacion/get/main")
    public Educacion findEducacion(){
        return iEducacionService.findEducacion((long)1);
    }
    
    @PostMapping("educacion/post")
    public String createEducacion(@RequestBody Educacion educacion){
        iEducacionService.saveEducacion(educacion);
        return "Create Success";
    }
    
    @DeleteMapping("educacion/delete/{id}")
    public String deleteEducacion(@PathVariable Long id){
        iEducacionService.deleteEducacion(id);
        return "Delete Success";
    }
    
    @PutMapping("educacion/put/{id}")
    public String editEducacion(@PathVariable Long id, 
                              @RequestParam("picture") String newPicture,
                              @RequestParam("title") String newTitle,
                              @RequestParam("origin") String newOrigin){
        Educacion educacion = iEducacionService.findEducacion(id);
        educacion.setPicture(newPicture);
        educacion.setTitle(newTitle);
        educacion.setOrigin(newOrigin);
        iEducacionService.saveEducacion(educacion);
        return "Edit Success";
    }
}
