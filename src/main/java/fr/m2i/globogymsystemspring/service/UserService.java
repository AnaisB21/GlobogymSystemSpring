package fr.m2i.globogymsystemspring.service;

import fr.m2i.globogymsystemspring.model.DBUser;
import fr.m2i.globogymsystemspring.repository.DBUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private DBUserRepository dbUserRepository;


    public List<DBUser> getAllUsers() {
        return dbUserRepository.findAll();
    }
    public void saveUser(DBUser user) {
        dbUserRepository.save(user);
    }

    public DBUser getUserById(long id) {
        Optional<DBUser> optional = dbUserRepository.findById(id);
        DBUser user = null;
        if(optional.isPresent()) {
            user=optional.get();
        } else {
            throw new RuntimeException("Utilisateur non trouvé pour l'id :: " + id);
        }
        return user;
    }

    public void deleteUserById (long id) {
        dbUserRepository.deleteById(id);
    }

}
