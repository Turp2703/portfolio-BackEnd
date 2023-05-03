package com.portfolioRueda.portfolio.Controller;

import com.portfolioRueda.portfolio.Entity.Header;
import com.portfolioRueda.portfolio.Interface.IHeaderService;
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
//Local
@CrossOrigin(origins = "http://localhost:4200")
//Deploy
//@CrossOrigin(origins = "https://rueda-portfolio-frontend.web.app/")
public class HeaderController {
    @Autowired IHeaderService iHeaderService;
    
    @GetMapping("header/get")
    public List<Header> getHeader(){
        return iHeaderService.getHeader();
    }
    
    @GetMapping("header/get/{id}")
    public Header findHeader(@PathVariable Long id){
        return iHeaderService.findHeader(id);
    }
    
    @GetMapping("header/get/main")
    public Header findHeader(){
        return iHeaderService.findHeader((long)1);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("header/post")
    public String createHeader(@RequestBody Header header){
        iHeaderService.saveHeader(header);
        return "Create Success";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("header/delete/{id}")
    public String deleteHeader(@PathVariable Long id){
        iHeaderService.deleteHeader(id);
        return "Delete Success";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("header/put/{id}")
    public String editHeader(@PathVariable Long id, 
                              @RequestParam("logo_arg_programa") String newLogoArgPrograma,
                              @RequestParam("title") String newTitle){
        Header header = iHeaderService.findHeader(id);
        header.setLogo_arg_programa(newLogoArgPrograma);
        header.setTitle(newTitle);
        iHeaderService.saveHeader(header);
        return "Edit Success";
    }
}
