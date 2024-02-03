package net.javaguides.springboot.service;

public interface UserService {
    boolean findByUser(String userName, String password);
}
