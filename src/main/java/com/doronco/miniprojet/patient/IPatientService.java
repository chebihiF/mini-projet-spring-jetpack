package com.doronco.miniprojet.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPatientService {
    Patient savePatient(Patient patient) throws Exception;
    Patient updatePatient(Patient patient) throws Exception;
    Patient deletePatient(Long id) throws Exception;
    Patient getPatient(Long id) throws Exception;
    List<Patient> getPatients() throws Exception;
    Page<Patient> getPatients(Pageable pageable) throws Exception;

    Page<Patient> getPatientsByNameLike(String keyword,Pageable pageable);
}
