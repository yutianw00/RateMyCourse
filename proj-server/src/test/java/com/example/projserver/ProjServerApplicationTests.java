package com.example.projserver;

import com.example.projserver.entity.*;
import com.example.projserver.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProjServerApplicationTests {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseEvalService courseEvalService;

    @Autowired
    private ProfEvalService profEvalService;

    @Test
    void contextLoads() {

    }

    @Test
    void testAdminAdd() {
        Admin myadmin = new Admin();
        myadmin.setAvator("");
        myadmin.setId(6);
        myadmin.setUsername("admin6");
        myadmin.setPassword("678");
        adminService.addAdmin(myadmin);
    }

    @Test
    void testUserAdd() {
        Users user = new Users();
        user.setUsername("tom");
        user.setCollege("CIT");
        user.setPassword("tom123");
        userService.addUser(user);
    }

    @Test
    void testUserSelectAll() {
        List<Users> usersList = userService.getAllUsers();
        System.out.println(usersList.size());
        System.out.println(usersList.get(0));
    }

    @Test
    void testUserSelectByName() {
        Users user = userService.getUserByName("tom");
        System.out.println(user);
    }

    @Test
    void deleteUser() {
        int id = 1;
        boolean res = userService.deleteUser(id);
        System.out.println(res);
    }

    @Test
    void testCourseSelectAll() {
        List<Course> courses = courseService.getAllCourses();
        System.out.println(courses.size());
        System.out.println(courses.get(0));
    }

    @Test
    void testCourseEvalSelectAll() {
        List<CourseEval> courseEvals = courseEvalService.getAllCourseEvals();
        System.out.println(courseEvals.size());
        System.out.println(courseEvals.get(0));
    }

    @Test
    void testProfEvalSelectByUser() {
        String user = "tom";
        List<ProfEval> evals = profEvalService.getProfEvalsWithUser(user);
        System.out.println(evals.size());
        System.out.println(evals.get(0));
    }

}
