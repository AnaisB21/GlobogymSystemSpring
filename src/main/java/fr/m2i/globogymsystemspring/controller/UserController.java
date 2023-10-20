package fr.m2i.globogymsystemspring.controller;


import fr.m2i.globogymsystemspring.model.DBUser;
import fr.m2i.globogymsystemspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/index_user")
    public String viewHomePage (Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "index_user";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        DBUser user = new DBUser();
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute ("user") DBUser user) {
        userService.saveUser(user);
        return "redirect:/admin/index_user";
    }

    @GetMapping("/showFormForUpdateUser/{id}")
    public String showFormForUpdateUser (@PathVariable (value="id") long id, Model model) {
        DBUser user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser (@PathVariable (value = "id") long id) {
        userService.deleteUserById(id);
        return "redirect:/admin/index_user";
    }
}
