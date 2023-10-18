package fr.m2i.globogymsystemspring.security.repositories;

import fr.m2i.globogymsystemspring.security.entities.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBUserRepository extends JpaRepository<DBUser, Long> {

    public DBUser findByUsername(String username);
}
