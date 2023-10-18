package fr.m2i.globogymsystemspring.controller;

import fr.m2i.globogymsystemspring.model.Client;
import fr.m2i.globogymsystemspring.model.Cours;
import fr.m2i.globogymsystemspring.service.ClientService;
import fr.m2i.globogymsystemspring.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;

@Controller
public class ReservationController {

    @Autowired
    private CoursService coursService;

    @Autowired
    private ClientService clientService;


    @GetMapping("/index_reservation")
    public String viewHomePage (Model model) {
        model.addAttribute("listCours", coursService.getAllCours());
        return "index_reservation";
    }

    //méthode pour afficher la page d'ajout de client au cours
    @GetMapping("/index_reservation/new_reservation/{id}")
    public String newReservationForm(@PathVariable(value = "id") long id, Model model, @RequestParam(value = "full", required = false) boolean errorfullcours) {

        if(errorfullcours) {
            model.addAttribute("errorMessage", "Le cours est complet. Vous ne pouvez pas ajouter plus de clients.");

        }
        Cours cours = coursService.getCoursById(id);
        model.addAttribute("cours", cours);
        model.addAttribute("clients", clientService.getAllClients()); // on récupère tous les clients disponibles
        model.addAttribute("newClient", new Client()); // Formulaire pour ajouter un nouveau client
        return "new_reservation";
    }

    //méthode pour traiter le formulaire d'ajout
    @PostMapping("/index_reservation/new_reservation/{id}")
    public String addClientToCours(@PathVariable(value = "id") long id, @RequestParam("clientId") long clientId, Model model) {
        Cours cours = coursService.getCoursById(id);
        Client client = clientService.getClientById(clientId);

        if(cours.getClients().contains(client) || client.getCours().contains(cours)) {
            model.addAttribute("errorMessage", "Ce client est déjà inscrit à ce cours.");
            return "index_reservation/new_reservation/{id}";

        } else if (cours.getClients().size() < 5) {
            System.out.println("ok");
            cours.getClients().add(client);
            client.getCours().add(cours); //+
            coursService.saveCours(cours);
            return "redirect:/index_reservation";
        } else {

            return "redirect:/index_reservation/new_reservation/{id}?full=true";//
        }

    }

    //afficher les clients inscrits au cours
   @GetMapping("/index_reservation/view_reservation/{id}")
    public String viewReservation (@PathVariable(value="id") long id, Model model) {
        Cours cours = coursService.getCoursById(id);
        model.addAttribute("cours", cours);
        return "view_reservation";
    }

    //supprimer un client inscrit à un cours
    @GetMapping("/index_reservation/remove_reservation")
    public String deleteClientCours (@RequestParam("coursId") long coursId, @RequestParam("clientId") long clientId) {

        Cours cours = coursService.getCoursById(coursId);
        Client client = clientService.getClientById(clientId);

       cours.getClients().remove(client);
       client.getCours().remove(cours);

       coursService.saveCours(cours);

        return "redirect:/index_reservation/view_reservation/" + coursId;
   }


}
