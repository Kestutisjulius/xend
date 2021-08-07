package com.javavilnius10.controller;

import com.javavilnius10.exception.SalesLineNotFoundException;
import com.javavilnius10.model.SalesLine;
import com.javavilnius10.service.SalesLineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/salesline")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/salesline")
public class SalesLineController {

    private final SalesLineService salesLineService;

    @GetMapping("/period")
    public ResponseEntity<List<SalesLine>> getSalesLineFromPeriod(LocalDateTime from, LocalDateTime to) {
        List<SalesLine> salesLineList = salesLineService.getSalesLineFromPeriod(from, to);
        return new ResponseEntity<>(salesLineList, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<SalesLine>> getAllSalesLine() {
        List<SalesLine> salesLineList = salesLineService.findAllSalesLine();
        return new ResponseEntity<>(salesLineList, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public SalesLine getSalesLineByName(@PathVariable String name) {
        return salesLineService.getSalesLineByName(name);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<SalesLine> getSalesLineById(@PathVariable Long id) throws SalesLineNotFoundException {
        SalesLine salesLine = salesLineService.getSalesLineById(id);
        return new ResponseEntity<>(salesLine, HttpStatus.FOUND);
    }

    @PostMapping()
    public ResponseEntity<Void> addSalesLine(@RequestBody SalesLine salesLine) {
        salesLineService.addSalesLine(salesLine);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Void> updateSalesLine(@RequestBody SalesLine salesLine) {
        salesLineService.updateSalesLine(salesLine);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalesLine(@PathVariable Long id) {
        salesLineService.deleteSalesLineById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
