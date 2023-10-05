package fr.m2i.globogymsystemspring.repository;

import fr.m2i.globogymsystemspring.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long> {
}
