package com.enterprise.vetSystem.model;

import com.enterprise.vetSystem.enums.Animal.ConsultationStatus;

import java.util.Date;

public class Consultation {

    private Long id;
    private Date dateAndTime;
    private String description;
    private ConsultationStatus status;

}
