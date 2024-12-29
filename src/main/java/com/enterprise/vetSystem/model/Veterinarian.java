package com.enterprise.vetSystem.model;

import com.enterprise.vetSystem.enums.Animal.Specialization;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


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
}
