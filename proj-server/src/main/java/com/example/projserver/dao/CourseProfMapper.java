package com.example.projserver.dao;

import com.example.projserver.entity.CourseProf;

public interface CourseProfMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseProf record);

    int insertSelective(CourseProf record);

    CourseProf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseProf record);

    int updateByPrimaryKey(CourseProf record);
}