package com.example.apiAuthetication.controllers;


import com.example.apiAuthetication.dtos.UserDto;
import com.example.apiAuthetication.model.User;
import com.example.apiAuthetication.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping
    public ResponseEntity getAll(){
        List<User> listUsers = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listUsers);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody UserDto dto){
        var user = new User();
        BeanUtils.copyProperties(dto, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Integer id, @RequestBody UserDto dto){
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        var userModel = user.get();
        BeanUtils.copyProperties(dto, userModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(userModel));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Integer id){
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        repository.delete(user.get());
        return ResponseEntity.status(HttpStatus.OK).body("User delete");
    }
}
