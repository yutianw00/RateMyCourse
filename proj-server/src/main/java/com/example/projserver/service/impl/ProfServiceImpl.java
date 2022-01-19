package com.example.projserver.service.impl;

import com.example.projserver.dao.ProfMapper;
import com.example.projserver.entity.Prof;
import com.example.projserver.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfServiceImpl implements ProfService {
    @Autowired
    private ProfMapper profMapper;

    @Override
    public boolean addProf(Prof prof) {
        return profMapper.insert(prof) > 0;
    }

    @Override
    public List<Prof> getAllProfs() {
        return profMapper.selectAll();
    }

    @Override
    public boolean deleteProf(int id) {
        return profMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean editProf(Prof prof) {
        return profMapper.updateByPrimaryKey(prof) > 0;
    }
}
