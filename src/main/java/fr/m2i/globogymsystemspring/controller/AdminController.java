package fr.m2i.globogymsystemspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/")
    public String getWelcome() {
        return "home";
    }

}
