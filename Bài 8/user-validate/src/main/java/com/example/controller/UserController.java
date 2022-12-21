package com.example.controller;

import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping ("/create-user")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/validateUser")
    public ModelAndView checkValidate (@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/index");
        }
        userService.save(user);
        ModelAndView modelAndView =new ModelAndView("/index");
        modelAndView.addObject("message", "New user created successfully");
        return new ModelAndView("/result");
    }

    @GetMapping("/user")
    public ModelAndView listUsers(){
        List<User> users = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
}
