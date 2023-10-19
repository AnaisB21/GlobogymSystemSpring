package fr.m2i.globogymsystemspring.repository;

import fr.m2i.globogymsystemspring.model.Cours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {

    //Création d'une requête personnalisée pour récupérer les derniers cours ajoutés
    @Query("SELECT c FROM Cours c ORDER BY c.date DESC ")
    Page<Cours> findCoursByDateDesc(PageRequest pageRequest);
}
