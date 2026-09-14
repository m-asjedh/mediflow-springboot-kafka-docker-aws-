package com.pm.patient_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pm.patient_service.dto.PatientRequestDTO;
import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.model.Patient;
import com.pm.patient_service.repository.PatientRepository;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDto> getPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(patient -> PatientMapper.toDTO(patient)).toList();

    }

    public PatientResponseDto createPatient(PatientRequestDTO patientRequestDTO) {
        Patient newPatient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(newPatient);
    }

}
