package com.example.projserver.service.impl;

import com.example.projserver.dao.CourseMapper;
import com.example.projserver.entity.Course;
import com.example.projserver.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public boolean addCourse(Course course) {
        return courseMapper.insert(course) > 0;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseMapper.selectAll();
    }

    @Override
    public boolean deleteCourse(int id) {
        return courseMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean editCourse(Course course) {
        return courseMapper.updateByPrimaryKey(course) > 0;
    }
}
