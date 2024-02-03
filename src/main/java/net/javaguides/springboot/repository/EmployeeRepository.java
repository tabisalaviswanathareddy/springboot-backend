package net.javaguides.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.User;

@Repository
public interface EmployeeRepository extends MongoRepository<User, Long>{
    @Query("{userName : ?0}")
    User findUserByUsername(String username);

}
