package com.portfolioRueda.portfolio.Service;

import com.portfolioRueda.portfolio.Entity.Footer;
import com.portfolioRueda.portfolio.Interface.IFooterService;
import com.portfolioRueda.portfolio.Repository.IFooterRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpFooterService implements IFooterService{
    @Autowired IFooterRepository iFooterRepository;
    
    @Override
    public List<Footer> getFooter() {
        List<Footer> footers = iFooterRepository.findAll();
        return footers;
    }

    @Override
    public Footer findFooter(Long id) {
        Footer footer = iFooterRepository.findById(id).orElse(null);
        return footer;
    }

    @Override
    public void saveFooter(Footer footer) {
        iFooterRepository.save(footer);
    }

    @Override
    public void deleteFooter(Long id) {
        iFooterRepository.deleteById(id);
    }
    
}
