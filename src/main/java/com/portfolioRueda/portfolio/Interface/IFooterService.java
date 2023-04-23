package com.portfolioRueda.portfolio.Interface;

import com.portfolioRueda.portfolio.Entity.Footer;
import java.util.List;

public interface IFooterService {
    //Get all
    public List<Footer> getFooter();
    
    //Get by 'id'
    public Footer findFooter(Long id);
    
    //Save
    public void saveFooter(Footer footer);
    
    //Delete
    public void deleteFooter(Long id);
}
