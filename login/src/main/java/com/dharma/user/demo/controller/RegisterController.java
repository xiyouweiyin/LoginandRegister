package com.dharma.user.demo.controller;

import com.dharma.user.demo.entity.User;
import com.dharma.user.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;


@Controller
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @RequestMapping(value = "/register")
    public String register(){
        return "/login/register";
    }

    @RequestMapping(value = "/doregister",method ={RequestMethod.GET,RequestMethod.POST},produces = "text/plain;charset=UTF-8")
    public String register(HttpServletRequest request,User user){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String password2=request.getParameter("password2");
        if(password.equals(password2)){
            if (registerUser(username)==true){
                User user1=new User();
                user1.setName(username);
                user1.setPassword(password);
                registerService.save(user1);
                return "redirect:/";
            }else {
                return "redirect:/login/register";
            }
        }
        return "/login/register";
    }
    public Boolean registerUser(String username){

        if (registerService.findByName(username).isEmpty())
            return true;
        else {
            return false;
        }
    }

}
