package com.example.projserver.controller;

import com.example.projserver.entity.ProfEval;
import com.example.projserver.service.ProfEvalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfEvalController {
    @Autowired
    private ProfEvalService profEvalService;

    @ResponseBody
    @RequestMapping(value={"/admin/profevals", "/client/profevals"}, method = RequestMethod.GET)
    public Object getAllProfEvals() {
        return profEvalService.getAllProfEvals();
    }

    @ResponseBody
    @RequestMapping(value="client/profevals/user", method = RequestMethod.GET)
    public Object getProfEvalsWithUser(HttpServletRequest req) {
        String user = req.getParameter("user");
        return profEvalService.getProfEvalsWithUser(user);
    }

    @ResponseBody
    @RequestMapping(value="admin/profevals/delete", method = RequestMethod.GET)
    public Object deleteProfEval(HttpServletRequest req) {
        String id = req.getParameter("id");
        return profEvalService.deleteProfEval(Integer.valueOf(id));
    }

    @ResponseBody
    @RequestMapping(value={"admin/profevals/add", "client/profevals/add"}, method = RequestMethod.POST)
    public Object addProfEval(HttpServletRequest req) {
        ProfEval profEval = new ProfEval();
        try {
            profEval.setProfname(req.getParameter("profname"));
            profEval.setRating(Integer.valueOf(req.getParameter("rating")));
            profEval.setComment(req.getParameter("comment"));
            profEval.setUser(req.getParameter("user"));
        } catch (Exception e) { // catch integer conversion errors
            return false;
        }
        return profEvalService.addProfEval(profEval);
    }

    @ResponseBody
    @RequestMapping(value="admin/profevals/edit")
    public Object editProfEval(HttpServletRequest req) {
        ProfEval profEval = new ProfEval();
        try {
            profEval.setId(Integer.valueOf(req.getParameter("id")));
            profEval.setProfname(req.getParameter("profname"));
            profEval.setRating(Integer.valueOf(req.getParameter("rating")));
            profEval.setComment(req.getParameter("comment"));
            profEval.setUser(req.getParameter("user"));
        } catch (Exception e) { // catch integer conversion errors
            return false;
        }
        return profEvalService.editProfEval(profEval);
    }
}
