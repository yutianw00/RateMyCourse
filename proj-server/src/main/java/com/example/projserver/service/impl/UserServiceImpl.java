package com.example.projserver.service.impl;

import com.example.projserver.dao.UsersMapper;
import com.example.projserver.entity.Users;
import com.example.projserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersMapper usersMapper;

    @Override
    public boolean addUser(Users user) {
        return usersMapper.insert(user) > 0;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersMapper.selectAll();
    }

    @Override
    public boolean deleteUser(int id) {
        return usersMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean editUser(Users user) {
        return usersMapper.updateByPrimaryKey(user) > 0;
    }

    @Override
    public Users getUserByName(String username) {
        return usersMapper.selectByName(username);
    }
}
