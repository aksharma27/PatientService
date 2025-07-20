package com.pm.patient_service.service;

import com.pm.patient_service.model.dto.PatientRequestDTO;
import com.pm.patient_service.model.dto.PatientResponseDTO;

import java.util.List;

public interface PatientService {
    public List<PatientResponseDTO> getPatients ();
    public PatientResponseDTO createPatient (PatientRequestDTO patientRequestDTO);
}
