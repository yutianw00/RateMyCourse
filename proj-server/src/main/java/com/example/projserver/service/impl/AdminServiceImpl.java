package com.example.projserver.service.impl;

import com.example.projserver.dao.AdminMapper;
import com.example.projserver.entity.Admin;
import com.example.projserver.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public boolean addAdmin(Admin admin) {
//        return false;
        return adminMapper.insert(admin) > 0;
    }

    @Override
    public boolean verify(String name, String password) {
        return (adminMapper.verify(name, password) > 0);
    }
}
