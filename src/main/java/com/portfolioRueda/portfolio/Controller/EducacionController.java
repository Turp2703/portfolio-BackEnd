package com.portfolioRueda.portfolio.Controller;

import com.portfolioRueda.portfolio.Dto.DtoEducacion;
import com.portfolioRueda.portfolio.Entity.Educacion;
import com.portfolioRueda.portfolio.Security.Controller.msg;
import com.portfolioRueda.portfolio.Service.EducacionService;
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
@RequestMapping("educacion")
//Local
//@CrossOrigin(origins = "http://localhost:4200")
//Deploy
@CrossOrigin(origins = "https://rueda-portfolio-frontend.web.app/")
public class EducacionController {
    @Autowired EducacionService educacionService;
    
    @GetMapping("/get")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = educacionService.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<Educacion> list(@PathVariable("id") int id){
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new msg("No existe una educacion con esa id"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = educacionService.getById(id).get();
        return new ResponseEntity(educacion,HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/post")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEducacion){
        if(StringUtils.isBlank(dtoEducacion.getTitle())){
            return new ResponseEntity(new msg("Titulo obligatorio."), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEducacion.getOrigin())){
            return new ResponseEntity(new msg("Origen obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEducacion.getYear())){
            return new ResponseEntity(new msg("Año obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(educacionService.existsByTitle(dtoEducacion.getTitle())){
            return new ResponseEntity(new msg("Educacion con ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = new Educacion(dtoEducacion.getPicture(), dtoEducacion.getTitle(), dtoEducacion.getOrigin(), dtoEducacion.getYear());
        educacionService.save(educacion);
        
        return new ResponseEntity(new msg("Educacion agregada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/put/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEducacion){
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new msg("No existe una educacion con esa id"), HttpStatus.BAD_REQUEST);
        }
        if(educacionService.existsByTitle(dtoEducacion.getTitle()) && educacionService.getByTitle(dtoEducacion.getTitle()).get().getId() != id){
            return new ResponseEntity(new msg("Educacion con ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEducacion.getTitle())){
            return new ResponseEntity(new msg("Titulo obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEducacion.getOrigin())){
            return new ResponseEntity(new msg("Origen obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEducacion.getYear())){
            return new ResponseEntity(new msg("Año obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = educacionService.getById(id).get();
        educacion.setPicture(dtoEducacion.getPicture());
        educacion.setTitle(dtoEducacion.getTitle());
        educacion.setOrigin(dtoEducacion.getOrigin());
        educacion.setYear(dtoEducacion.getYear());
        
        educacionService.save(educacion);
        
        return new ResponseEntity(new msg("Educacion actualizada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new msg("No existe una educacion con esa id"), HttpStatus.BAD_REQUEST);
        }
        
        educacionService.delete(id);
        
        return new ResponseEntity(new msg("Educacion eliminada"), HttpStatus.OK);
    }
}
