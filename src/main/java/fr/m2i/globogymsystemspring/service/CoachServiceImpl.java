package fr.m2i.globogymsystemspring.service;

import fr.m2i.globogymsystemspring.model.Coach;
import fr.m2i.globogymsystemspring.repository.CoachRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachRepository coachRepository;

    @Override
    public List<Coach> getAllCoachs() {
        return coachRepository.findAll();
    }

    @Override
    public void saveCoach (Coach coach) {
        this.coachRepository.save(coach);
    }

    @Override
    public Coach getCoachById(long id) {
        Optional<Coach> optional = coachRepository.findById(id);
        Coach coach = null;
        if (optional.isPresent()) {
            coach = optional.get();
        } else {
            throw new RuntimeException("Coach non trouvé pour l'id :: " + id);
        }
        return coach;
    }

    @Override
    public void deleteCoachById(long id) {
        this.coachRepository.deleteById(id);
    }
}
