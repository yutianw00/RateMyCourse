package com.example.projserver.dao;

import com.example.projserver.entity.ProfEval;

import java.util.List;

public interface ProfEvalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProfEval record);

    int insertSelective(ProfEval record);

    ProfEval selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProfEval record);

    int updateByPrimaryKey(ProfEval record);

    List<ProfEval> selectAll();

    List<ProfEval> selectByUser(String user);
}