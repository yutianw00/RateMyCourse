package com.example.projserver.dao;

import com.example.projserver.entity.CourseEval;

import java.util.List;

public interface CourseEvalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseEval record);

    int insertSelective(CourseEval record);

    CourseEval selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseEval record);

    int updateByPrimaryKey(CourseEval record);

    List<CourseEval> selectAll();

    List<CourseEval> selectByUser(String user);
}