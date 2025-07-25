package com.pm.patient_service.controller;

import com.pm.patient_service.model.dto.PatientRequestDTO;
import com.pm.patient_service.model.dto.PatientResponseDTO;
import com.pm.patient_service.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PatientControllerTest {

    @Mock
    private PatientService patientService;

    @InjectMocks
    private PatientController patientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPatients() {
        // Arrange
        List<PatientResponseDTO> mockPatients = Arrays.asList(
                new PatientResponseDTO(UUID.randomUUID(), "John Doe", 30),
                new PatientResponseDTO(UUID.randomUUID(), "Jane Doe", 25)
        );
        when(patientService.getPatients()).thenReturn(mockPatients);

        // Act
        ResponseEntity<List<PatientResponseDTO>> response = patientController.getPatients();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockPatients, response.getBody());
        verify(patientService, times(1)).getPatients();
    }

    @Test
    void testCreatePatient() {
        // Arrange
        PatientRequestDTO requestDTO = new PatientRequestDTO("John Doe", 300);
        PatientResponseDTO responseDTO = new PatientResponseDTO(UUID.randomUUID(), "John Doe", 30);
        when(patientService.createPatient(requestDTO)).thenReturn(responseDTO);

        // Act
        ResponseEntity<PatientResponseDTO> response = patientController.createPatient(requestDTO);

        // Assert
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(responseDTO, response.getBody());
        verify(patientService, times(1)).createPatient(requestDTO);
    }

    @Test
    void testUpdatePatient() {
        // Arrange
        UUID patientId = UUID.randomUUID();
        PatientRequestDTO requestDTO = new PatientRequestDTO("John Doe", 35);
        PatientResponseDTO responseDTO = new PatientResponseDTO(patientId, "John Doe", 35);
        when(patientService.updatePatient(patientId, requestDTO)).thenReturn(responseDTO);

        // Act
        ResponseEntity<PatientResponseDTO> response = patientController.updatePatient(patientId, requestDTO);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(responseDTO, response.getBody());
        verify(patientService, times(1)).updatePatient(patientId, requestDTO);
    }
}