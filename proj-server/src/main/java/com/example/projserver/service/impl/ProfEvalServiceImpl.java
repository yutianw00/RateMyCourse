package com.example.projserver.service.impl;

import com.example.projserver.dao.ProfEvalMapper;
import com.example.projserver.entity.ProfEval;
import com.example.projserver.service.ProfEvalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfEvalServiceImpl implements ProfEvalService {

    @Autowired
    private ProfEvalMapper profEvalMapper;

    @Override
    public boolean addProfEval(ProfEval profEval) {
        return profEvalMapper.insert(profEval) > 0;
    }

    @Override
    public List<ProfEval> getAllProfEvals() {
        return profEvalMapper.selectAll();
    }

    @Override
    public List<ProfEval> getProfEvalsWithUser(String user) {
        return profEvalMapper.selectByUser(user);
    }

    @Override
    public boolean deleteProfEval(int id) {
        return profEvalMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean editProfEval(ProfEval profEval) {
        return profEvalMapper.updateByPrimaryKey(profEval) > 0;
    }
}
