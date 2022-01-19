package com.example.projserver.controller;


import com.example.projserver.entity.Prof;
import com.example.projserver.service.CourseService;
import com.example.projserver.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfController {

    @Autowired
    private ProfService profService;

    @ResponseBody
    @RequestMapping(value={"/admin/profs", "/client/profs"}, method = RequestMethod.GET)
    public Object getAllProfs() {
        return profService.getAllProfs();
    }

    @ResponseBody
    @RequestMapping(value="admin/profs/delete", method = RequestMethod.GET)
    public Object deleteCourse(HttpServletRequest req) {
        String id = req.getParameter("id");
        return profService.deleteProf(Integer.valueOf(id));
    }

    @ResponseBody
    @RequestMapping(value="admin/profs/add")
    public Object addCourse(HttpServletRequest req) {
        Prof prof = new Prof();
        try {
            prof.setName(req.getParameter("name"));
            prof.setRating(Integer.valueOf(req.getParameter("rating")));
            prof.setIntro(req.getParameter("intro"));
        } catch (Exception e) { // catch integer conversion errors
            return false;
        }

        return profService.addProf(prof);
    }

    @ResponseBody
    @RequestMapping(value="admin/profs/edit")
    public Object editUser(HttpServletRequest req) {
        Prof prof = new Prof();
        try {
            prof.setId(Integer.valueOf(req.getParameter("id")));
            prof.setName(req.getParameter("name"));
            prof.setRating(Integer.valueOf(req.getParameter("rating")));
            prof.setIntro(req.getParameter("intro"));
        } catch (Exception e) { // catch integer conversion errors
            return false;
        }
        return profService.editProf(prof);
    }
}
