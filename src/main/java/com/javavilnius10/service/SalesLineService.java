package com.javavilnius10.service;

import com.javavilnius10.exception.SalesLineNotFoundException;
import com.javavilnius10.model.SalesLine;
import com.javavilnius10.reposirory.SalesLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class SalesLineService {

    private final SalesLineRepository salesLineRepository;

    @Autowired
    public SalesLineService(SalesLineRepository salesLineRepository) {
        this.salesLineRepository = salesLineRepository;
    }

    public List<SalesLine>getSalesLines(){return salesLineRepository.findAll();}
    public SalesLine getSalesLineByName (String name) {return salesLineRepository.getSalesLineByName(name);}
    public SalesLine getSalesLineById (Long id) {return salesLineRepository.getSalesLineById(id);}
    public void updateSalesLine (SalesLine salesLine) {salesLineRepository.save(salesLine);}
    public void deleteSalesLineById(Long id) {salesLineRepository.deleteById(id);}

    public SalesLine findSalesLineById(Long id) throws SalesLineNotFoundException {
        return salesLineRepository.findById(id)
                .orElseThrow(() -> new SalesLineNotFoundException("Sales Line with id: " + id + " not exist !"));
    }

    public List<SalesLine> getSalesLineFromPeriod(LocalDateTime from, LocalDateTime to) { return (List<SalesLine>) salesLineRepository.getSalesLineByPeriod(from, to);
    }

    public void addSalesLine(SalesLine salesLine) { salesLineRepository.save(salesLine);
    }

    public List<SalesLine> findAllSalesLine() { return salesLineRepository.findAll();
    }
}
