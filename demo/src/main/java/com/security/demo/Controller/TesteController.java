package com.security.demo.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TesteController {

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public String teste(){
        return"<h1> Teste</h1>";

    }
    @GetMapping("/all")
    public String rotaLivre(){
        return"<h1> Rota Livre</h1>";
    }

}