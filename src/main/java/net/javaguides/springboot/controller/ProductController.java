package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Invoice;
import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.InvoiceRepository;
import net.javaguides.springboot.repository.ProductRepository;
import net.javaguides.springboot.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rest/v1/")
public class ProductController {
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ProductRepository productRepository;
    // get all employees
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        try {
            return productRepository.findAll();
        }catch(Exception e) {
            System.out.print("exception" + e.getMessage());

        }
        return null;

    }

    @GetMapping("/products/{code}")
    public ResponseEntity<Product> getProductByCode(@PathVariable String code){
        try {
            Product product = productRepository.findUserByProductCode(code);
            return ResponseEntity.ok(product);
        }catch(Exception e) {
            System.out.print("exception" + e.getMessage());

        }
        return null;
    }


}
