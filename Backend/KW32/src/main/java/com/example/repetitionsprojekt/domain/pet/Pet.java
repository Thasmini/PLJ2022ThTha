package com.example.repetitionsprojekt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor // generates emprty constructor for the class
@AllArgsConstructor // generates a constructorr with all the fielss that are available in the class
@Builder

public class Pet {
    @Id
    @GeneratedValue
    @NotNull
    @Column
    int id;
    @Column
    String name;
    @Column
    int age;
    @Column
    String breed;
    @Column
    String gender;
    @Column
    boolean available;
    @Column
    String url;

}
