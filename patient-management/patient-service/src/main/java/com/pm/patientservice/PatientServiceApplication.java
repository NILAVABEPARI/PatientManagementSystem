package com.pm.patientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientServiceApplication.class, args);
    }
}



// [Database]
//        ↓
// [PatientRepository]      ← fetches raw Patient entities
//        ↓
// [PatientService]         ← orchestrates the flow
//        ↓
// [PatientMapper]          ← converts Patient → PatientResponseDTO
//        ↓
// [PatientResponseDTO]     ← clean, safe object sent to the client
//        ↓
// [REST Controller]        ← returns it as JSON