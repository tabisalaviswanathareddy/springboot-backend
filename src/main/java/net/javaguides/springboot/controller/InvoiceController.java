package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Invoice;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.InvoiceRepository;
import net.javaguides.springboot.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rest/v1/")
public class InvoiceController {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;


    @GetMapping("/invoice/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not exist with id :" + id));
        return ResponseEntity.ok(invoice);
    }

    @PostMapping("/invoice")
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        invoice.setId(sequenceGeneratorService.getSequenceNumber(Invoice.SEQUENCE_NAME));
        // Create a LocalDateTime object representing the current system date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Format the LocalDateTime object to a string with the specified format
        String formattedDate = currentDateTime.format(formatter);

        invoice.setBillingDate(formattedDate);
        return invoiceRepository.save(invoice);
    }
}
