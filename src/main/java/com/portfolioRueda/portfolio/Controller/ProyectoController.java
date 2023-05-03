package com.portfolioRueda.portfolio.Controller;

import com.portfolioRueda.portfolio.Dto.DtoProyecto;
import com.portfolioRueda.portfolio.Entity.Proyecto;
import com.portfolioRueda.portfolio.Security.Controller.msg;
import com.portfolioRueda.portfolio.Service.ProyectoService;
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
@RequestMapping("proyecto")
//Local
@CrossOrigin(origins = "http://localhost:4200")
//Deploy
//@CrossOrigin(origins = "https://rueda-portfolio-frontend.web.app/")
public class ProyectoController {
    @Autowired ProyectoService proyectoService;
    
    @GetMapping("/get")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = proyectoService.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<Proyecto> list(@PathVariable("id") int id){
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new msg("No existe un proyecto con esa id"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = proyectoService.getById(id).get();
        return new ResponseEntity(proyecto,HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/post")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoProyecto){
        if(StringUtils.isBlank(dtoProyecto.getName())){
            return new ResponseEntity(new msg("Nombre obligatorio."), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoProyecto.getDescription())){
            return new ResponseEntity(new msg("Descripcion obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(proyectoService.existsByName(dtoProyecto.getName())){
            return new ResponseEntity(new msg("Proyecto con ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = new Proyecto(dtoProyecto.getPicture(), dtoProyecto.getName(), dtoProyecto.getDescription(), dtoProyecto.getLink());
        proyectoService.save(proyecto);
        
        return new ResponseEntity(new msg("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/put/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoProyecto){
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new msg("No existe un proyecto con esa id"), HttpStatus.BAD_REQUEST);
        }
        if(proyectoService.existsByName(dtoProyecto.getName()) && proyectoService.getByName(dtoProyecto.getName()).get().getId() != id){
            return new ResponseEntity(new msg("Proyecto con ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoProyecto.getName())){
            return new ResponseEntity(new msg("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoProyecto.getDescription())){
            return new ResponseEntity(new msg("Descripcion obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = proyectoService.getById(id).get();
        proyecto.setPicture(dtoProyecto.getPicture());
        proyecto.setName(dtoProyecto.getName());
        proyecto.setDescription(dtoProyecto.getDescription());
        proyecto.setLink(dtoProyecto.getLink());
        
        proyectoService.save(proyecto);
        
        return new ResponseEntity(new msg("Proyecto actualizado"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new msg("No existe un proyecto con esa id"), HttpStatus.BAD_REQUEST);
        }
        
        proyectoService.delete(id);
        
        return new ResponseEntity(new msg("Proyecto eliminado"), HttpStatus.OK);
    }
}
