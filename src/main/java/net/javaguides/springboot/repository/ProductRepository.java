package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long>{
    @Query("{productCode : ?0}")
    Product findUserByProductCode(String productCode);

}
