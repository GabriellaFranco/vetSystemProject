package com.enterprise.vetSystem.mapper;

import com.enterprise.vetSystem.model.Veterinarian;
import com.enterprise.vetSystem.model.dtos.ConsultAllVeterinariansDto;
import org.springframework.stereotype.Component;

@Component
public class ConsultAllVeterinariansMapper {

    public ConsultAllVeterinariansDto veterinariansToConsultAllVeterinariansDto(Veterinarian veterinarian) {
        return ConsultAllVeterinariansDto.builder()
                .id(veterinarian.getId())
                .name(veterinarian.getName())
                .crv(veterinarian.getCrv())
                .Specialization(veterinarian.getSpecialization())
                .build();
    }
}
