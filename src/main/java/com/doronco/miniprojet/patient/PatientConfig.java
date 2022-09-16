package com.doronco.miniprojet.patient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class PatientConfig {

    private final PatientRepository patientRepository;

    public PatientConfig(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    //@Bean
    CommandLineRunner init_patient(){
        return args -> {
            for(int i=0; i<100; i++){
                patientRepository.save(new Patient(null, "Patient"+i, LocalDate.now(), false, 0));
            }
            //patientRepository.findAll().forEach(System.out::println);
        };
    }

}
