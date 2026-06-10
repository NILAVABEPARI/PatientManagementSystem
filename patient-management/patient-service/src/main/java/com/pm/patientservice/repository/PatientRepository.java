package com.pm.patientservice.repository;

import com.pm.patientservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
// JpaRepository is a powerful interface provided by Spring Data JPA that comes with dozens of pre-built database methods — you don't have to write any SQL yourself!
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    // <Patient, UUID> — these are the two Generic type parameters JpaRepository needs:
    // Patient → "Which table/entity are we working with?"
    // UUID → "What is the data type of the primary key (ID)?"

    boolean existsByEmail(String mail);
    // existsByEmail(String mail) --
    // Spring reads: "exists + By + Email"
    // Generates this SQL behind the scenes: sql> SELECT COUNT(*) > 0 FROM patient WHERE email = ?
    // Returns true if a patient with that email exists, false if not.
    // Used in PatientService to prevent duplicate emails when creating a patient.

    boolean existsByEmailAndIdNot(String email, UUID id);
    // existsByEmailAndIdNot(String email, UUID id) --
    // Spring reads: "exists + By + Email + And + Id + Not"
    // Generates this SQL: sql> SELECT COUNT(*) > 0 FROM patient WHERE email = ? AND id != ?
    // Returns true if another patient (not the current one) already has that email.
    // Used in PatientService when updating a patient — so a patient can keep their own email, but can't steal someone else's.
}
