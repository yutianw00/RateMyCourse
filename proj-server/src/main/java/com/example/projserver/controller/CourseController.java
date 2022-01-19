package com.example.projserver.controller;

import com.example.projserver.entity.Course;
import com.example.projserver.entity.Users;
import com.example.projserver.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @ResponseBody
    @RequestMapping(value={"/admin/courses", "/client/courses"}, method = RequestMethod.GET)
    public Object getAllCourses() {
        return courseService.getAllCourses();
    }

    @ResponseBody
    @RequestMapping(value="admin/courses/delete", method = RequestMethod.GET)
    public Object deleteCourse(HttpServletRequest req) {
        String id = req.getParameter("id");
        return courseService.deleteCourse(Integer.valueOf(id));
    }

    @ResponseBody
    @RequestMapping(value="admin/courses/add")
    public Object addCourse(HttpServletRequest req) {
        Course course = new Course();
        try {
            course.setName(req.getParameter(("name")));
            course.setNumber(Integer.valueOf(req.getParameter("number")));
            course.setProf(req.getParameter("prof"));
            course.setIntro(req.getParameter("intro"));
            course.setUnits(Integer.valueOf(req.getParameter("units")));
        } catch (Exception e) { // catch integer conversion errors
            return false;
        }

        return courseService.addCourse(course);
    }

    @ResponseBody
    @RequestMapping(value="admin/courses/edit")
    public Object editUser(HttpServletRequest req) {
        Course course = new Course();
        try {
            course.setId(Integer.valueOf(req.getParameter("id")));
            course.setName(req.getParameter(("name")));
            course.setNumber(Integer.valueOf(req.getParameter("number")));
            course.setProf(req.getParameter("prof"));
            course.setIntro(req.getParameter("intro"));
            course.setUnits(Integer.valueOf(req.getParameter("units")));
        } catch (Exception e) { // catch integer conversion errors
            return false;
        }
        return courseService.editCourse(course);
    }
}
