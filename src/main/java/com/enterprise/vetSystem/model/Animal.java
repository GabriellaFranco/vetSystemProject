package com.enterprise.vetSystem.model;

import com.enterprise.vetSystem.enums.Gender;
import com.enterprise.vetSystem.enums.Species;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private Integer age;
    private Gender gender;
    private Boolean isCastrated;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client owner;

    @OneToMany (mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consultation> consultations = new ArrayList<>();


}
