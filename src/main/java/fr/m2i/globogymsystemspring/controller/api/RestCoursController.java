package fr.m2i.globogymsystemspring.controller.api;

import fr.m2i.globogymsystemspring.DTO.CoursDTO;
import fr.m2i.globogymsystemspring.DTO.Mapper;
import fr.m2i.globogymsystemspring.service.CoursService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@Data
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins = "*")
@RequestMapping("/api/cours")
public class RestCoursController {

    private CoursService cs;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<CoursDTO>> getCours() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cs.getAllCours()
                        .stream()
                        .map(Mapper::coursToDTO)
                        .collect(toList()));
    }

}
