package com.example.projserver.service;

import com.example.projserver.entity.Admin;

public interface AdminService {
    boolean addAdmin(Admin admin);

    boolean verify(String name, String password);
}
