package com.ciclo3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/")
    public String start(){
        return "index";
    }
    @RequestMapping("/client")
    public String client(){
        return "client";
    }
    @RequestMapping("/category")
    public String category(){
        return "category";
    }
    @RequestMapping("/message")
    public String message(){
        return "message";
    }
    @RequestMapping("/reservation")
    public String reservation(){
        return "reservation";
    }

}
