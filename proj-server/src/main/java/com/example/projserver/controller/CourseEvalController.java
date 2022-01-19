package com.example.projserver.controller;

import com.example.projserver.entity.CourseEval;
import com.example.projserver.service.CourseEvalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CourseEvalController {
    @Autowired
    private CourseEvalService courseEvalService;

    @ResponseBody
    @RequestMapping(value={"/admin/courseevals", "/client/courseevals"}, method = RequestMethod.GET)
    public Object getAllCourseEvals() {
        return courseEvalService.getAllCourseEvals();
    }

    @ResponseBody
    @RequestMapping(value="client/courseevals/user", method = RequestMethod.GET)
    public Object getCourseEvalsWithUser(HttpServletRequest req) {
        String user = req.getParameter("user");
        return courseEvalService.getCourseEvalsByUser(user);
    }

    @ResponseBody
    @RequestMapping(value="admin/courseevals/delete", method = RequestMethod.GET)
    public Object deleteCourseEval(HttpServletRequest req) {
        String id = req.getParameter("id");
        return courseEvalService.deleteCourseEval(Integer.valueOf(id));
    }

    @ResponseBody
    @RequestMapping(value={"admin/courseevals/add", "client/courseevals/add"}, method = RequestMethod.POST)
    public Object addCourseEval(HttpServletRequest req) {
        CourseEval courseEval = new CourseEval();
        try {
            courseEval.setCoursenumber(req.getParameter("coursenumber"));
            courseEval.setProfname(req.getParameter("profname"));
            courseEval.setSemester(req.getParameter("semester"));
            courseEval.setRating(Integer.valueOf(req.getParameter("rating")));
            courseEval.setComment(req.getParameter("comment"));
            courseEval.setUser(req.getParameter("user"));
        } catch (Exception e) { // catch integer conversion errors
            return false;
        }

        return courseEvalService.addCourseEval(courseEval);
    }

    @ResponseBody
    @RequestMapping(value="admin/courseevals/edit")
    public Object editUser(HttpServletRequest req) {
        CourseEval courseEval = new CourseEval();
        try {
            courseEval.setId(Integer.valueOf(req.getParameter("id")));
            courseEval.setCoursenumber(req.getParameter("coursenumber"));
            courseEval.setProfname(req.getParameter("profname"));
            courseEval.setSemester(req.getParameter("semester"));
            courseEval.setRating(Integer.valueOf(req.getParameter("rating")));
            courseEval.setComment(req.getParameter("comment"));
            courseEval.setUser(req.getParameter("user"));
        } catch (Exception e) { // catch integer conversion errors
            return false;
        }
        return courseEvalService.editCourseEval(courseEval);
    }
}
