package fr.m2i.globogymsystemspring.controller;

import fr.m2i.globogymsystemspring.model.Cours;
import fr.m2i.globogymsystemspring.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BaseController {

    @Autowired
    private CoursService coursService;

    @GetMapping("/home")
    public String viewHomePage (Model model) {
        List<Cours> latestCours = coursService.getLatestCours(3);
        model.addAttribute("listCours", latestCours);
        return "home";
    }
}
