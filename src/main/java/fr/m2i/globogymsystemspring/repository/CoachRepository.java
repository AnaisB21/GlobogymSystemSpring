package fr.m2i.globogymsystemspring.repository;

import fr.m2i.globogymsystemspring.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository <Coach, Long> {
}
