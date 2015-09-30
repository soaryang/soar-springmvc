package com.soar.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 15/9/6.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/userInfo.html")
    public String getCode(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        System.out.println("------------------------------------------------>");
        return "user/userInfo";
    }

    @RequestMapping("/add.html")
    public String add(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        System.out.println("------------------------------------------------>");
        System.out.print(req.getParameter("name"));
        return "user/userInfo";
    }
}
