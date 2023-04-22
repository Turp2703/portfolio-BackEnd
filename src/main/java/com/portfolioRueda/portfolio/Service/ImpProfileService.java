package com.portfolioRueda.portfolio.Service;

import com.portfolioRueda.portfolio.Entity.Profile;
import com.portfolioRueda.portfolio.Interface.IProfileService;
import com.portfolioRueda.portfolio.Repository.IProfileRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpProfileService implements IProfileService{
    @Autowired IProfileRepository iProfileRepository;
    
    @Override
    public List<Profile> getProfile() {
        List<Profile> profiles = iProfileRepository.findAll();
        return profiles;
    }

    @Override
    public Profile findProfile(Long id) {
        Profile profile = iProfileRepository.findById(id).orElse(null);
        return profile;
    }

    @Override
    public void saveProfile(Profile profile) {
        iProfileRepository.save(profile);
    }

    @Override
    public void deleteProfile(Long id) {
        iProfileRepository.deleteById(id);
    }
    
}
