package com.portfolioRueda.portfolio.Service;

import com.portfolioRueda.portfolio.Entity.Header;
import com.portfolioRueda.portfolio.Interface.IHeaderService;
import com.portfolioRueda.portfolio.Repository.IHeaderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpHeaderService implements IHeaderService{
    @Autowired IHeaderRepository iHeaderRepository;
    
    @Override
    public List<Header> getHeader() {
        List<Header> headers = iHeaderRepository.findAll();
        return headers;
    }

    @Override
    public Header findHeader(Long id) {
        Header header = iHeaderRepository.findById(id).orElse(null);
        return header;
    }

    @Override
    public void saveHeader(Header header) {
        iHeaderRepository.save(header);
    }

    @Override
    public void deleteHeader(Long id) {
        iHeaderRepository.deleteById(id);
    }
    
}
