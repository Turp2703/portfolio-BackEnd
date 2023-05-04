package com.portfolioRueda.portfolio.Controller;

import com.portfolioRueda.portfolio.Entity.Footer;
import com.portfolioRueda.portfolio.Interface.IFooterService;
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
//@CrossOrigin(origins = "http://localhost:4200")
//Deploy
@CrossOrigin(origins = "https://rueda-portfolio-frontend.web.app/")
public class FooterController {
    @Autowired IFooterService iFooterService;
    
    @GetMapping("footer/get")
    public List<Footer> getFooter(){
        return iFooterService.getFooter();
    }
    
    @GetMapping("footer/get/{id}")
    public Footer findFooter(@PathVariable Long id){
        return iFooterService.findFooter(id);
    }
    
    @GetMapping("footer/get/main")
    public Footer findFooter(){
        return iFooterService.findFooter((long)1);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("footer/post")
    public String createFooter(@RequestBody Footer footer){
        iFooterService.saveFooter(footer);
        return "Create Success";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("footer/delete/{id}")
    public String deleteFooter(@PathVariable Long id){
        iFooterService.deleteFooter(id);
        return "Delete Success";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("footer/put/{id}")
    public String editFooter(@PathVariable Long id, 
                              @RequestParam("name") String newName,
                              @RequestParam("copyright") String newCopyright){
        Footer footer = iFooterService.findFooter(id);
        footer.setName(newName);
        footer.setCopyright(newCopyright);
        iFooterService.saveFooter(footer);
        return "Edit Success";
    }
}
