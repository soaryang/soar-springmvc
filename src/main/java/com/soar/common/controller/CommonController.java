package com.soar.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 15/9/6.
 */
@Controller
public class CommonController {

    @RequestMapping("/login.html")
    public String getCode(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        return "login";
    }


    @RequestMapping("/noAuthority.html")
    public String noAuthority(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        return "/common/403";
    }

    @RequestMapping("/menu.html")
    public String menu(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        return "common/menu";
    }

}
