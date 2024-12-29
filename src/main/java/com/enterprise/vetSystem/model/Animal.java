package com.enterprise.vetSystem.model;

import com.enterprise.vetSystem.enums.Animal.Gender;
import com.enterprise.vetSystem.enums.Animal.Species;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Builder
@Data
@Entity
@Table(name = "tb_animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Species specie;
    private String breed;
    private int age;
    private Gender gender;
    private Boolean isCastrated;


}
