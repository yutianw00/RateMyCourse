package com.example.projserver.dao;

import com.example.projserver.entity.Prof;

import java.util.List;

public interface ProfMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Prof record);

    int insertSelective(Prof record);

    Prof selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Prof record);

    int updateByPrimaryKey(Prof record);

    List<Prof> selectAll();
}