package fr.m2i.globogymsystemspring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping
public class WelcomeController {

    @RequestMapping(path="/", method = RequestMethod.GET)
    public String getWelcome() {
        return "home";
    }


}
