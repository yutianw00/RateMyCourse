package com.example.projserver.service;

import com.example.projserver.entity.Users;

import java.util.List;

public interface UserService {
    boolean addUser(Users user);

    List<Users> getAllUsers();

    boolean deleteUser(int id);

    boolean editUser(Users user);

    Users getUserByName(String username);
}
