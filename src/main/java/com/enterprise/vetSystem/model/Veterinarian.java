package com.enterprise.vetSystem.model;

import com.enterprise.vetSystem.enums.Specialization;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Builder
@Data
@Entity
@Table(name = "tb_veterinarian")
public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String crv;
    private Specialization specialization;

    @OneToMany(mappedBy = "veterinarian", cascade = CascadeType.ALL)
    private List<Consultation> consultations = new ArrayList<>();
}
