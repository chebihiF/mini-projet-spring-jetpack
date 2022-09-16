package com.doronco.miniprojet.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService{

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient savePatient(Patient patient) throws Exception {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) throws Exception {
        return null;
    }

    @Override
    public Patient deletePatient(Long id) throws Exception {
        Patient patient = getPatient(id);
        patientRepository.deleteById(id);
        return patient;
    }

    @Override
    public Patient getPatient(Long id) throws Exception {
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent())
            return patient.get();
        else throw new Exception("patient not found");
    }

    @Override
    public List<Patient> getPatients() throws Exception {
        return patientRepository.findAll();
    }

    @Override
    public Page<Patient> getPatients(Pageable pageable) throws Exception {
        return patientRepository.findAll(pageable);
    }

    @Override
    public Page<Patient> getPatientsByNameLike(String keyword, Pageable pageable) {
        return patientRepository.findByNomContains(keyword,pageable);
    }
}
