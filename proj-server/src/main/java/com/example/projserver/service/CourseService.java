package com.example.projserver.service;

import com.example.projserver.entity.Course;

import java.util.List;

public interface CourseService {
    boolean addCourse(Course course);

    List<Course> getAllCourses();

    boolean deleteCourse(int id);

    boolean editCourse(Course course);
}
