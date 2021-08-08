package com.javavilnius10.service;

import com.javavilnius10.exception.InvoiceNotFoundException;
import com.javavilnius10.model.Invoice;
import com.javavilnius10.reposirory.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class InvoiceService {

    @Autowired
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id) throws InvoiceNotFoundException {
        return invoiceRepository.findById(id).orElseThrow(() -> new InvoiceNotFoundException("No Invoices with id: " + id));
    }

    public Invoice getInvoiceByDate(LocalDate date) {
        return invoiceRepository.getInvoiceByDateOfInvoice(date);
    }

    public void addInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void fixInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteInvoiceById(id);
    }

}
