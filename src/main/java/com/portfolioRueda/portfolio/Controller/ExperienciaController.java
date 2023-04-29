package com.portfolioRueda.portfolio.Controller;

import com.portfolioRueda.portfolio.Dto.DtoExperiencia;
import com.portfolioRueda.portfolio.Entity.Experiencia;
import com.portfolioRueda.portfolio.Security.Controller.msg;
import com.portfolioRueda.portfolio.Service.ExperienciaService;
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
@RequestMapping("experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
    @Autowired ExperienciaService experienciaService;
    
    @GetMapping("/get")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<Experiencia> list(@PathVariable("id") int id){
        if(!experienciaService.existsById(id)){
            return new ResponseEntity(new msg("No existe una experiencia con esa id"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = experienciaService.getById(id).get();
        return new ResponseEntity(experiencia,HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/post")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExperiencia){
        if(StringUtils.isBlank(dtoExperiencia.getName())){
            return new ResponseEntity(new msg("Nombre obligatorio."), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoExperiencia.getPlace())){
            return new ResponseEntity(new msg("Lugar obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(experienciaService.existsByName(dtoExperiencia.getName())){
            return new ResponseEntity(new msg("Experiencia con ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = new Experiencia(dtoExperiencia.getLogo(), dtoExperiencia.getName(), dtoExperiencia.getPlace());
        experienciaService.save(experiencia);
        
        return new ResponseEntity(new msg("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/put/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExperiencia){
        if(!experienciaService.existsById(id)){
            return new ResponseEntity(new msg("No existe una experiencia con esa id"), HttpStatus.BAD_REQUEST);
        }
        if(experienciaService.existsByName(dtoExperiencia.getName()) && experienciaService.getByName(dtoExperiencia.getName()).get().getId() != id){
            return new ResponseEntity(new msg("Experiencia con ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoExperiencia.getName())){
            return new ResponseEntity(new msg("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoExperiencia.getPlace())){
            return new ResponseEntity(new msg("Lugar obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = experienciaService.getById(id).get();
        experiencia.setLogo(dtoExperiencia.getLogo());
        experiencia.setName(dtoExperiencia.getName());
        experiencia.setPlace(dtoExperiencia.getPlace());
        
        experienciaService.save(experiencia);
        
        return new ResponseEntity(new msg("Experiencia actualizada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!experienciaService.existsById(id)){
            return new ResponseEntity(new msg("No existe una experiencia con esa id"), HttpStatus.BAD_REQUEST);
        }
        
        experienciaService.delete(id);
        
        return new ResponseEntity(new msg("Experiencia eliminada"), HttpStatus.OK);
    }
}
