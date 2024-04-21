package com.example.application.services.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "User")
@Getter
@Setter
@AllArgsConstructor
public class User {


    private UUID id;
    private String username;
    private String surname;
    private String lastname;
    private String email;
    private String password; //TODO: Hash!


    //TODO:
    // hat mehrere freunde
    // beiträge
    //kommentare

}
