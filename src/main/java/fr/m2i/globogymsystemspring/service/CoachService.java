package fr.m2i.globogymsystemspring.service;

import fr.m2i.globogymsystemspring.model.Coach;

import java.util.List;

public interface CoachService {

    List<Coach> getAllCoachs();
    void saveCoach(Coach coach);
    Coach getCoachById(long id);
    void deleteCoachById(long id);
}
