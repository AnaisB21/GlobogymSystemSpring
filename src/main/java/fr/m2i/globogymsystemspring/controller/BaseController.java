package fr.m2i.globogymsystemspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("/home")
    public String viewHomePage () {
        return "home";
    }
}
