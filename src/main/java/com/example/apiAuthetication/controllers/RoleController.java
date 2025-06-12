package com.example.apiAuthetication.controllers;


import com.example.apiAuthetication.dtos.RoleDto;
import com.example.apiAuthetication.model.Role;
import com.example.apiAuthetication.repositories.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleRepository repository;

    @GetMapping
    public ResponseEntity getAll(){
        List<Role> listRole = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listRole);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody RoleDto dto){
        var role = new Role();
        BeanUtils.copyProperties(dto, role);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(role));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Integer id, @RequestBody RoleDto dto){
        Optional<Role> role = repository.findById(id);
        if(role.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found");
        }
        var roleModel = role.get();
        BeanUtils.copyProperties(dto, roleModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(roleModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Integer id, @RequestBody Role dto){
        Optional<Role> role = repository.findById(id);
        if(role.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found");
        }
        repository.delete(role.get());
        return ResponseEntity.status(HttpStatus.OK).body("Role Delete");
    }
}
