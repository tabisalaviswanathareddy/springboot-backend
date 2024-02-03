package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Invoice;
import net.javaguides.springboot.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends MongoRepository<Invoice, Long>{


}
