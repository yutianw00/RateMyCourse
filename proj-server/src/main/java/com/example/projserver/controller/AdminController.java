package com.example.projserver.controller;

import com.example.projserver.dto.LoginDTO;
import com.example.projserver.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @ResponseBody
    @RequestMapping(value="/admin/login", method= RequestMethod.POST)
    public Object loginControl(HttpServletRequest req, HttpSession session) {

        String adminName = req.getParameter("loginName");
        String password = req.getParameter("password");

        LoginDTO dto = new LoginDTO();
        if (adminName == null || adminName.equals("")) {
            dto.setCode(400);
            dto.setMessage("Admin name cannot be empty.");
            return dto;
        } else if (password == null || password.equals("")) {
            dto.setCode(400);
            dto.setMessage("Password cannot be empty.");
            return dto;
        }

        // verify
        boolean res = adminService.verify(adminName, password);

        // return
        if (res) {
            dto.setCode(200);
            dto.setMessage("Welcome, " + adminName + "!");
            session.setAttribute("name", adminName);
        } else {
            dto.setCode(400);
            dto.setMessage("Admin name or password not correct.");
        }
        return dto;
    }
}
