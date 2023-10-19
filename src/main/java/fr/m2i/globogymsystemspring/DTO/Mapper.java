package fr.m2i.globogymsystemspring.DTO;

import fr.m2i.globogymsystemspring.model.Client;
import fr.m2i.globogymsystemspring.model.Coach;
import fr.m2i.globogymsystemspring.model.Cours;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class Mapper {

    public static ClientDTO clientToDTO(Client client) {
        String nom = client.getNom();
        String prenom = client.getPrenom();
        return new ClientDTO(nom, prenom);
    }

    public static CoachDTO coachToDTO(Coach coach) {
        String nom = coach.getNom();
        String prenom = coach.getPrenom();
        return new CoachDTO(nom, prenom);
    }
    public static CoursDTO coursToDTO(Cours cours) {
        String nom = cours.getNom();
        Date date = cours.getDate();
        CoachDTO coach = Mapper.coachToDTO(cours.getCoach());
        List<ClientDTO> listeClients = cours.getClients().stream().map(Mapper::clientToDTO).collect(toList());
        String image = "";
        switch (nom) {
            case "Zumba": {
                image = "https://images.unsplash.com/photo-1527933053326-89d1746b76b9?auto=format&fit=crop&q=80&w=2670&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";
                break;
            }
            case "Pilates": {
                image = "https://images.unsplash.com/photo-1522845015757-50bce044e5da?auto=format&fit=crop&q=80&w=2670&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";
                break;
            }
            case "Aerobic": {
                image = "https://images.unsplash.com/photo-1518310383802-640c2de311b2?auto=format&fit=crop&q=80&w=2670&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";
                break;
            }
            case "Musculation": {
                image = "https://images.unsplash.com/photo-1541534741688-6078c6bfb5c5?auto=format&fit=crop&q=80&w=2669&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";
                break;
            }
            case "Yoga": {
                image = "https://images.unsplash.com/photo-1549576490-b0b4831ef60a?auto=format&fit=crop&q=80&w=2670&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";
                break;
            }
        }
        return new CoursDTO(nom, date, coach, listeClients, image);
    }
}
