package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public boolean findByUser(String userName, String password) {
        User user = employeeRepository.findUserByUsername(userName);
        if(user != null && password.equals(user.getPassword())){
            return true;
        }
        return false;
    }
}
