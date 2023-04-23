package com.portfolioRueda.portfolio.Controller;

import com.portfolioRueda.portfolio.Entity.Footer;
import com.portfolioRueda.portfolio.Interface.IFooterService;
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
public class FooterController {
    @Autowired IFooterService iFooterService;
    
    @GetMapping("footer/get")
    public List<Footer> getFooter(){
        return iFooterService.getFooter();
    }
    
    @GetMapping("footer/get/main")
    public Footer findFooter(){
        return iFooterService.findFooter((long)1);
    }
    
    @PostMapping("footer/post")
    public String createFooter(@RequestBody Footer footer){
        iFooterService.saveFooter(footer);
        return "Create Success";
    }
    
    @DeleteMapping("footer/delete/{id}")
    public String deleteFooter(@PathVariable Long id){
        iFooterService.deleteFooter(id);
        return "Delete Success";
    }
    
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
