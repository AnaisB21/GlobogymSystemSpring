package fr.m2i.globogymsystemspring.service;

import fr.m2i.globogymsystemspring.model.Cours;

import java.util.List;

public interface CoursService {
    List<Cours> getAllCours();
    void saveCours(Cours cours);
    Cours getCoursById(long id);
    void deleteCoursById(long id);
    void detachCoachFromCours(Cours cours);
    List<Cours> getLatestCours(int count);

}
