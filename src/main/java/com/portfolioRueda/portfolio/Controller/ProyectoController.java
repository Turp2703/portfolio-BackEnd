package com.portfolioRueda.portfolio.Controller;

import com.portfolioRueda.portfolio.Entity.Proyecto;
import com.portfolioRueda.portfolio.Interface.IProyectoService;
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
public class ProyectoController {
    @Autowired IProyectoService iProyectoService;
    
    @GetMapping("proyecto/get")
    public List<Proyecto> getProyecto(){
        return iProyectoService.getProyecto();
    }
    
    @GetMapping("proyecto/get/{id}")
    public Proyecto findProyecto(@PathVariable Long id){
        return iProyectoService.findProyecto(id);
    }
    
    @GetMapping("proyecto/get/main")
    public Proyecto findProyecto(){
        return iProyectoService.findProyecto((long)1);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("proyecto/post")
    public String createProyecto(@RequestBody Proyecto proyecto){
        iProyectoService.saveProyecto(proyecto);
        return "Create Success";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("proyecto/delete/{id}")
    public String deleteProyecto(@PathVariable Long id){
        iProyectoService.deleteProyecto(id);
        return "Delete Success";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("proyecto/put/{id}")
    public String editProyecto(@PathVariable Long id, 
                              @RequestParam("picture") String newPicture,
                              @RequestParam("name") String newName,
                              @RequestParam("description") String newDescription){
        Proyecto proyecto = iProyectoService.findProyecto(id);
        proyecto.setPicture(newPicture);
        proyecto.setName(newName);
        proyecto.setDescription(newDescription);
        iProyectoService.saveProyecto(proyecto);
        return "Edit Success";
    }
}
