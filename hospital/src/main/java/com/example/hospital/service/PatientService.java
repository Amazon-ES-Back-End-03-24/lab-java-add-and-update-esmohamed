package com.example.hospital.service;

import com.example.hospital.model.Patient;
import com.example.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    public Optional <Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }
    public List<Patient> getPatientByDBirthRange(LocalDate startdate, LocalDate endDate) {
        return patientRepository.findByDateOfBirthBetween(startdate, endDate);
    }
    public List<Patient> getPatientsByDoctorDepartment(String department) {
        return patientRepository.findByAdmittedByDepartament(department);

    }
    public List<Patient> getPatientsByDoctorStatus(String status) {
        return patientRepository.findByAdmittedByStatus(status);
    }
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);

    }
    public Patient updatePatient( Long id ,Patient patient,String name) {
        Patient patient1 = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        patient1.setDateOfBirth(patient.getDateOfBirth());
        patient1.setName(name);
        return patientRepository.save(patient1);
    }

}
