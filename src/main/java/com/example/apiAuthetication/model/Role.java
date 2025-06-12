package com.example.apiAuthetication.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "roles")
@Table(name = "roles")
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

<<<<<<< HEAD
//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users;
=======
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
>>>>>>> 59c86dd3ad96f5912498130f6da5d1a6403b3172
}
