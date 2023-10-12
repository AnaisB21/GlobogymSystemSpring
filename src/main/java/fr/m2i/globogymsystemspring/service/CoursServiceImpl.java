package fr.m2i.globogymsystemspring.service;

import fr.m2i.globogymsystemspring.model.Cours;
import fr.m2i.globogymsystemspring.repository.CoursRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursServiceImpl implements CoursService {

    @Autowired
    private CoursRepository coursRepository;

    @Override
    public List<Cours> getAllCours() {return coursRepository.findAll();}

    @Override
    public void saveCours (Cours cours) {
        this.coursRepository.save(cours);
    }

    @Override
    public Cours getCoursById(long id) {
        Optional<Cours> optional = coursRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Cours non trouvé pour l'id :: " + id);
        }
    }

    @Override
    public void deleteCoursById(long id) {
        this.coursRepository.deleteById(id);
    }

    @Override
    public void detachCoachFromCours (Cours cours) {
        if (cours.getCoach() != null) {
            cours.getCoach().getListCours().remove(cours);
            cours.setCoach(null);
            coursRepository.save(cours);
        }
    }
}