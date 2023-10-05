package fr.m2i.globogymsystemspring.controller;

import fr.m2i.globogymsystemspring.model.Client;
import fr.m2i.globogymsystemspring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/index_client")
    public String viewHomePage (Model model) {
        model.addAttribute("listClients", clientService.getAllClients());
        return "index_client";
    }

    @GetMapping("/showNewClientForm")
    public String showNewClientForm(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
    return "new_client";
    }

    @PostMapping("/saveClient")
    public String saveClient(@ModelAttribute("client") Client client) {
        clientService.saveClient(client);
        return "redirect:/index_client";
    }

    @GetMapping("/showFormForUpdateClient/{id}")
    public String showFormForUpdateClient(@PathVariable (value="id") long id, Model model ){
        Client client = clientService.getClientById(id);
        model.addAttribute("client", client);
        return "update_client";
    }

    @GetMapping("/deleteClient/{id}")
    public String deleteClient (@PathVariable (value="id") long id) {
        this.clientService.deleteClientById(id);
        return "redirect:/index_client";
    }

}
