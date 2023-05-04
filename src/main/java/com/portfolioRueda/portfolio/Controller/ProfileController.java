package com.portfolioRueda.portfolio.Controller;

import com.portfolioRueda.portfolio.Entity.Profile;
import com.portfolioRueda.portfolio.Interface.IProfileService;
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
public class ProfileController {
    @Autowired IProfileService iProfileService;
    
    @GetMapping("profile/get")
    public List<Profile> getProfile(){
        return iProfileService.getProfile();
    }
    
    @GetMapping("profile/get/{id}")
    public Profile findProfile(@PathVariable Long id){
        return iProfileService.findProfile(id);
    }
        
    @GetMapping("profile/get/main")
    public Profile findProfile(){
        return iProfileService.findProfile((long)1);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("profile/post")
    public String createProfile(@RequestBody Profile profile){
        iProfileService.saveProfile(profile);
        return "Create Success";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("profile/delete/{id}")
    public String deleteProfile(@PathVariable Long id){
        iProfileService.deleteProfile(id);
        return "Delete Success";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("profile/put/{id}")
    public String editProfile(@PathVariable Long id, 
                              @RequestParam("background") String newBackground,
                              @RequestParam("info_picture") String newPicture,
                              @RequestParam("info_name") String newName,
                              @RequestParam("info_situation") String newSituation,
                              @RequestParam("info_location") String newLocation,
                              @RequestParam("logo_uns") String newUns){
        Profile profile = iProfileService.findProfile(id);
        profile.setBackground(newBackground);
        profile.setInfo_picture(newPicture);
        profile.setInfo_name(newName);
        profile.setInfo_situation(newSituation);
        profile.setInfo_location(newLocation);
        profile.setLogo_uns(newUns);
        iProfileService.saveProfile(profile);
        return "Edit Success";
    }
}
