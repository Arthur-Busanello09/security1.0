package com.security20.demo.Service;

import com.security20.demo.Entity.Usuario;
import com.security20.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Usuario> getAllUsers() {
        List<Usuario> usersIterable = userRepository.findAll();
        List<Usuario> UsuarioList = new ArrayList<>();
        usersIterable.forEach(UsuarioList::add);
        return UsuarioList;
    }

    public Usuario getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Usuario createUser(Usuario user) {
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return user;
    }
}
