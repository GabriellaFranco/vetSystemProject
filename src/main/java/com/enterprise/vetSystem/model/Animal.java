package com.enterprise.vetSystem.model;

import com.enterprise.vetSystem.enums.Gender;
import com.enterprise.vetSystem.enums.Species;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Builder
@Data
@Entity
@Table(name = "tb_animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Species species;
    private String breed;
    private int age;
    private Gender gender;
    private Boolean isCastrated;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client owner;

    @OneToMany (mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consultation> consultations = new ArrayList<>();


}
