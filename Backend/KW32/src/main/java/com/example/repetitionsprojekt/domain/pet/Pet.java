package com.example.repetitionsprojekt.domain.pet;

import lombok.*;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @NotNull
    @Column(name = "name")
    String name;

    @NotNull
    @Column(name = "age")
    int age;

    @NotNull
    @Column(name = "breed")
    String breed;

    @NotNull
    @Column(name = "gender")
    String gender;

    @Column(name = "url")
    String url;

    @NotNull
    @Column(name = "status")
    String status;

}
