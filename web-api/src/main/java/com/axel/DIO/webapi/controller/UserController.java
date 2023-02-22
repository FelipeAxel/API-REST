package com.axel.DIO.webapi.controller;

import com.axel.DIO.webapi.model.Usuario;
import com.axel.DIO.webapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;
    @GetMapping()
    public List <Usuario> getUsers(){
        return repository.findAll();
    }

    @PostMapping ()
    public void postUser(@RequestBody Usuario usuario){
        repository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") Integer id){
        repository.deleteById(id);
    }


    @GetMapping("/{username}")
    public Usuario getOne(@PathVariable("username") String username){
        return repository.findByUsername(username);
    }


    @PutMapping ()
    public void putUser(@RequestBody Usuario usuario){
        repository.save(usuario);
    }
}