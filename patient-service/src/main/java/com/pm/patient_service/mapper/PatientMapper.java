package com.pm.patient_service.mapper;

import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.model.Patient;

public class PatientMapper {
    public static PatientResponseDto toDTO(Patient patient) {
        PatientResponseDto patientDTO = new PatientResponseDto();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setName(patient.getName());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());
        return patientDTO;
    }
}
