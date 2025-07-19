package com.pm.patient_service.service.impl;

import com.pm.patient_service.repository.PatientRepository;
import com.pm.patient_service.service.PatientService;
import org.springframework.stereotype.Service;


@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;

    public PatientServiceImpl (PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
}
