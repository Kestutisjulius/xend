package com.javavilnius10.controller;

import com.javavilnius10.exception.InvoiceNotFoundException;
import com.javavilnius10.model.Invoice;
import com.javavilnius10.model.User;
import com.javavilnius10.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
@CrossOrigin(origins = "http://localhost:4200")
public class InvoiceController {
    private final InvoiceService invoiceService;

    @Autowired

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping()
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        List<Invoice> invoices = invoiceService.getInvoices();
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) throws InvoiceNotFoundException {
        Invoice invoice = invoiceService.getInvoiceById(id);
        return new ResponseEntity<>(invoice, HttpStatus.FOUND);
    }

    @PostMapping()
    public ResponseEntity<Void> addInvoice(@RequestBody Invoice invoice){
        invoiceService.addInvoice(invoice);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Void> fixInvoice (@RequestBody Invoice invoice){
        invoiceService.fixInvoice(invoice);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id){
        invoiceService.deleteInvoice(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
