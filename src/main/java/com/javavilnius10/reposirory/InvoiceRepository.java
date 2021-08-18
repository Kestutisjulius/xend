package com.javavilnius10.reposirory;

import com.javavilnius10.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    @Query("SELECT d FROM Invoice d WHERE d.dateOfInvoice=?1")
    Invoice getInvoiceByDateOfInvoice(LocalDate date);

    void deleteInvoiceById(Long id);
}