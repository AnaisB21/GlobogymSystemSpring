package fr.m2i.globogymsystemspring.controller;

import fr.m2i.globogymsystemspring.model.Cours;
import fr.m2i.globogymsystemspring.service.CoursService;
import fr.m2i.globogymsystemspring.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CoursController {

    @Autowired
    private CoursService coursService;

    @Autowired
    private CoachService coachService;

    @GetMapping("/index_cours")
    public String viewHomePage (Model model) {
        model.addAttribute("listCours", coursService.getAllCours());
        return "index_cours";
    }

    @GetMapping("/showNewCoursForm")
    public String showNewCoursForm(Model model) {
        Cours cours = new Cours();
        model.addAttribute("cours", cours);
        model.addAttribute("listCoachs",this.coachService.getAllCoachs()); //ici, on récupère la liste des coachs
        return "new_cours";
    }

    @PostMapping("/saveCours")
    public String saveCours(@ModelAttribute("cours") Cours cours) {
        coursService.saveCours(cours);
        return "redirect:/index_cours";
    }

    @GetMapping("/showFormForUpdateCours/{id}")
    public String showFormForUpdateCours(@PathVariable(value="id") long id, Model model ){
        Cours cours = coursService.getCoursById(id);
        model.addAttribute("cours", cours);
        model.addAttribute("listCoachs",this.coachService.getAllCoachs()); //ici, on récupère la liste des coachs
        return "update_cours";
    }

    @GetMapping("/deleteCours/{id}")
    public String deleteCours (@PathVariable (value="id") long id) {
        Cours cours = coursService.getCoursById(id);
        if(cours != null){
            coursService.detachCoachFromCours(cours);
            coursService.deleteCoursById(id);
        }
        return "redirect:/index_cours";
    }

}
