package fr.m2i.globogymsystemspring.repository;

import fr.m2i.globogymsystemspring.model.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBUserRepository extends JpaRepository<DBUser, Long> {

    public DBUser findByUsername(String username);
}
