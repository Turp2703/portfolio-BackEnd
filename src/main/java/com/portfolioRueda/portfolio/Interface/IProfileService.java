package com.portfolioRueda.portfolio.Interface;

import com.portfolioRueda.portfolio.Entity.Profile;
import java.util.List;

public interface IProfileService {
    //Get all
    public List<Profile> getProfile();
    
    //Get by 'id'
    public Profile findProfile(Long id);
    
    //Save
    public void saveProfile(Profile profile);
    
    //Delete
    public void deleteProfile(Long id);
}
