package fr.m2i.globogymsystemspring.DTO;



import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
public class CoursDTO {
    private String nom;
    private Date date;
    private CoachDTO coach;
    private List<ClientDTO> reservations;
}
