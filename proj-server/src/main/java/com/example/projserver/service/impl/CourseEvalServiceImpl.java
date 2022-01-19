package com.example.projserver.service.impl;

import com.example.projserver.dao.CourseEvalMapper;
import com.example.projserver.entity.CourseEval;
import com.example.projserver.service.CourseEvalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseEvalServiceImpl implements CourseEvalService {
    @Autowired
    private CourseEvalMapper courseEvalMapper;

    @Override
    public boolean addCourseEval(CourseEval courseEval) {
        return courseEvalMapper.insert(courseEval) > 0;
    }

    @Override
    public List<CourseEval> getAllCourseEvals() {
        return courseEvalMapper.selectAll();
    }

    @Override
    public boolean deleteCourseEval(int id) {
        return courseEvalMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean editCourseEval(CourseEval courseEval) {
        return courseEvalMapper.updateByPrimaryKey(courseEval) > 0;
    }

    @Override
    public List<CourseEval> getCourseEvalsByUser(String user) {
        return courseEvalMapper.selectByUser(user);
    }
}
