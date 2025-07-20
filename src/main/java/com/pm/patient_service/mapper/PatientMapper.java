package com.pm.patient_service.mapper;

import com.pm.patient_service.model.Patient;
import com.pm.patient_service.model.dto.PatientRequestDTO;
import com.pm.patient_service.model.dto.PatientResponseDTO;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponseDTO toDto (Patient patient) {
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();

        patientResponseDTO.setId(String.valueOf(patient.getId()));
        patientResponseDTO.setName(String.valueOf(patient.getName()));
        patientResponseDTO.setAddress(String.valueOf(patient.getAddress()));
        patientResponseDTO.setEmail(String.valueOf(patient.getEmail()));
        patientResponseDTO.setDateOfBirth(String.valueOf(patient.getDateOfBirth()));
        return patientResponseDTO;
    }

    public static Patient toEntity (PatientRequestDTO patientRequestDTO) {
        Patient patient = new Patient();

        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));
        return patient;
    }
}
