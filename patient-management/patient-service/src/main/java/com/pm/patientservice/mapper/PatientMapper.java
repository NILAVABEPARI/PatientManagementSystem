package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;

import java.time.LocalDate;

// The Translator --
// This is a conversion utility that sits between your internal model and the outside world.
// Patient (DB model)  →  PatientMapper.toDTO()  →  PatientResponseDTO (API response)
// It takes a Patient object and maps each field into a PatientResponseDTO
// Calls .toString() on fields like getId(), getDateOfBirth() — converting types like UUID or LocalDate into plain strings
// Keeps your internal model decoupled from what you expose

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO patientDTO = new PatientResponseDTO();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setName(patient.getName().toString());
        patientDTO.setAddress(patient.getAddress().toString());
        patientDTO.setEmail(patient.getEmail().toString());
        patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());
        return patientDTO;
    }

    public static Patient toModel (PatientRequestDTO patientResquestDTO) {
        Patient patient = new Patient();
        patient.setName(patientResquestDTO.getName());
        patient.setEmail(patientResquestDTO.getEmail());
        patient.setAddress(patientResquestDTO.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientResquestDTO.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patientResquestDTO.getRegisteredDate()));
        return patient;
    }
}
