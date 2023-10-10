package fr.m2i.globogymsystemspring.repository;

import fr.m2i.globogymsystemspring.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
}
