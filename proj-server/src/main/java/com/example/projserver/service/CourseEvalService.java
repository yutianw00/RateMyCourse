package com.example.projserver.service;

import com.example.projserver.entity.CourseEval;

import java.util.List;

public interface CourseEvalService {
    boolean addCourseEval(CourseEval courseEval);

    List<CourseEval> getAllCourseEvals();

    boolean deleteCourseEval(int id);

    boolean editCourseEval(CourseEval courseEval);

    List<CourseEval> getCourseEvalsByUser(String user);
}
