package com.example.projserver.controller;

import com.example.projserver.entity.Users;
import com.example.projserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value="admin/users", method= RequestMethod.GET)
    public Object getAllUsers() {
        return userService.getAllUsers();
    }

    @ResponseBody
    @RequestMapping(value="admin/users/delete", method = RequestMethod.GET)
    public Object deleteUser(HttpServletRequest req) {
        String id = req.getParameter("id");
        return userService.deleteUser(Integer.valueOf(id));
    }

    @ResponseBody
    @RequestMapping(value={"admin/users/add", "client/users/add"}, method = RequestMethod.POST)
    public Object addUser(HttpServletRequest req) {
        Users user = new Users();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setCollege(req.getParameter("college"));
        user.setEmail(req.getParameter("email"));
        boolean hasGradYear = true;
        try {
            Integer.valueOf(req.getParameter("gradYear"));
        } catch (NumberFormatException e) {
            hasGradYear = false;
        }
        if (hasGradYear) {
            user.setGradYear(Integer.valueOf(req.getParameter("gradYear")));
        }
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value="admin/users/edit")
    public Object editUser(HttpServletRequest req) {
        Users user = new Users();
        user.setId(Integer.valueOf(req.getParameter("id")));
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setCollege(req.getParameter("college"));
        user.setEmail(req.getParameter("email"));
        boolean hasGradYear = true;
        try {
            Integer.valueOf(req.getParameter("gradYear"));
        } catch (NumberFormatException e) {
            hasGradYear = false;
        }
        if (hasGradYear) {
            user.setGradYear(Integer.valueOf(req.getParameter("gradYear")));
        }
        return userService.editUser(user);
    }

    @ResponseBody
    @RequestMapping(value="client/users/login", method = RequestMethod.POST)
    public Object userLogin(HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Users user = userService.getUserByName(username);

        if (user == null) {
            return false;
        } else if (!user.getPassword().equals(password)) {
            return false;
        } else {
            return true;
        }
    }
}
