package com.portfolioRueda.portfolio.Controller;

import com.portfolioRueda.portfolio.Entity.AcercaDe;
import com.portfolioRueda.portfolio.Interface.IAcercaDeService;
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
public class AcercaDeController {
    @Autowired IAcercaDeService iAcercaDeService;
    
    @GetMapping("acercaDe/get")
    public List<AcercaDe> getAcercaDe(){
        return iAcercaDeService.getAcercaDe();
    }
    
    @GetMapping("acercaDe/get/{id}")
    public AcercaDe findAcercaDe(@PathVariable Long id){
        return iAcercaDeService.findAcercaDe(id);
    }
    
    @GetMapping("acercaDe/get/main")
    public AcercaDe findAcercaDe(){
        return iAcercaDeService.findAcercaDe((long)1);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("acercaDe/post")
    public String createAcercaDe(@RequestBody AcercaDe acercaDe){
        iAcercaDeService.saveAcercaDe(acercaDe);
        return "Create Success";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("acercaDe/delete/{id}")
    public String deleteAcercaDe(@PathVariable Long id){
        iAcercaDeService.deleteAcercaDe(id);
        return "Delete Success";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("acercaDe/put/{id}")
    public String editAcercaDe(@PathVariable Long id, 
                              @RequestParam("data1") String newData1,
                              @RequestParam("data2") String newData2){
        AcercaDe acercaDe = iAcercaDeService.findAcercaDe(id);
        acercaDe.setData1(newData1);
        acercaDe.setData2(newData2);
        iAcercaDeService.saveAcercaDe(acercaDe);
        return "Edit Success";
    }
}
