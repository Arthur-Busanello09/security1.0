package com.security20.demo.Controller;

import com.security20.demo.Entity.Usuario;
import com.security20.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class TesteController {

    private final UserService userService;

    @Autowired
    public TesteController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Usuario> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Usuario getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public Usuario createUser(@RequestBody Usuario user) {
        String encodedPassword = passwordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);

        return userService.createUser(user);
    }
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}