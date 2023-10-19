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
        return new CoursDTO(nom, date, coach, listeClients);
    }
}
