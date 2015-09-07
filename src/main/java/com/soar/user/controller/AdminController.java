package com.soar.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 15/9/7.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/adminMain.html")
    public String getCode(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        System.out.println("------------------------------------------------>");
        return "admin/adminMain";
    }
}
