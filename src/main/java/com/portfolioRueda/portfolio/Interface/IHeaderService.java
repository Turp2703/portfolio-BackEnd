package com.portfolioRueda.portfolio.Interface;

import com.portfolioRueda.portfolio.Entity.Header;
import java.util.List;

public interface IHeaderService {
    //Get all
    public List<Header> getHeader();
    
    //Get by 'id'
    public Header findHeader(Long id);
    
    //Save
    public void saveHeader(Header header);
    
    //Delete
    public void deleteHeader(Long id);
}
