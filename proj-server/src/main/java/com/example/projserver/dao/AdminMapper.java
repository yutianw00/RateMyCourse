package com.example.projserver.dao;

import com.example.projserver.entity.Admin;
import org.springframework.stereotype.Repository;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    int verify(String name, String password);
}