package com.fundamentos.springboot.fundamentos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //auto incremente cuando se agregue un usuario
    @Column(name = "id_user", nullable = false, unique = true)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //un usuario puede hacer muchos post
    @JsonManagedReference //acceder a este servicio a nivel rest no arroje un error
    private List<Post> post = new ArrayList<>();

    //contructor vacio
    public User() {
    }

    //contructot con todos los metodos
    public User(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", post=" + post +
                '}';
    }
}
