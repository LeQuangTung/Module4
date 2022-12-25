package com.example.sandwich_condiments.controller;

import com.example.sandwich_condiments.model.Sandwich;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {

    @PostMapping("/add")
    public ModelAndView add(Sandwich sandwich) {
        ModelAndView modelAndView = new ModelAndView("index.jsp");
        modelAndView.addObject("lettuce", sandwich.getLettuce());
        modelAndView.addObject("tomato", sandwich.getTomato());
        modelAndView.addObject("mustard", sandwich.getMustard());
        modelAndView.addObject("sprouts", sandwich.getSprouts());
        return modelAndView;
    }
}
