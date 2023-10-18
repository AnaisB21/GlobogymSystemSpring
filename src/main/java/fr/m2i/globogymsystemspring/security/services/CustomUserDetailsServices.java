package fr.m2i.globogymsystemspring.security.services;

import fr.m2i.globogymsystemspring.security.entities.DBUser;
import fr.m2i.globogymsystemspring.security.repositories.DBUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsServices implements UserDetailsService {

    private DBUserRepository dbUserRepo;

    public CustomUserDetailsServices(@Autowired DBUserRepository dbUserRepo) {
        this.dbUserRepo = dbUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DBUser user = this.dbUserRepo.findByUsername(username);
        return new User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user.getRole()));
    }

    private List<GrantedAuthority> getGrantedAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE" + role));
        return authorities;
    }
}
