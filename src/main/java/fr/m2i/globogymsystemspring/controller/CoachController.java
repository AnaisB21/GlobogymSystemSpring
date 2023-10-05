package fr.m2i.globogymsystemspring.controller;


import fr.m2i.globogymsystemspring.model.Coach;
import fr.m2i.globogymsystemspring.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CoachController {

    @Autowired
    private CoachService coachService;

    @GetMapping("/index_coach")
    public String viewHomePage (Model model) {
        model.addAttribute("listCoachs", coachService.getAllCoachs());
        return "index_coach";
    }

    @GetMapping("/showNewCoachForm")
    public String showNewClientForm(Model model) {
        Coach coach= new Coach();
        model.addAttribute("coach", coach);
        return "new_coach";
    }

    @PostMapping("/saveCoach")
    public String saveCoach(@ModelAttribute("coach") Coach coach) {
        coachService.saveCoach(coach);
        return "redirect:/index_coach";
    }

    @GetMapping("/showFormForUpdateCoach/{id}")
    public String showFormForUpdateCoach(@PathVariable(value="id") long id, Model model ){
        Coach coach = coachService.getCoachById(id);
        model.addAttribute("coach", coach);
        return "update_coach";
    }

    @GetMapping("/deleteCoach/{id}")
    public String deleteCoach (@PathVariable (value="id") long id) {
        this.coachService.deleteCoachById(id);
        return "redirect:/index_coach";
    }

}
