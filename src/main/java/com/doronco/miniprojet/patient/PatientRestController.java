package com.doronco.miniprojet.patient;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientRestController {

    private final IPatientService patientService;

    public PatientRestController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @CrossOrigin("*")
    @GetMapping
    public List<Patient> getPatients(@RequestParam(name = "page", defaultValue = "0") int page,
                                     @RequestParam(name = "size", defaultValue = "10") int size) {
        try {
            return patientService.getPatients(PageRequest.of(page,size)).getContent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
