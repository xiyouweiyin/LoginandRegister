package com.dharma.user.demo.controller;

import com.dharma.user.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method = {RequestMethod.POST,RequestMethod.GET})
    public String login(){
        return "/login/login";
    }
    @RequestMapping(value = "/loginPage",method = {RequestMethod.GET,RequestMethod.POST},produces = "text/plain;charset=UTF-8")
    public String loginCon(HttpServletRequest request, HttpSession session) {
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String tname=userService.login(name,password);
        session.setAttribute("tname",tname);
        if (tname==null){
            return "redirect:/";
        }else {
            return "redirect:/index";
        }
    }
    @RequestMapping(value = "/index",method ={RequestMethod.POST,RequestMethod.GET})
    public String loginindex(){
        return "/login/test";
    }
}
