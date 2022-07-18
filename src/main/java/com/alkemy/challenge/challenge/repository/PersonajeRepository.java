package com.alkemy.challenge.challenge.repository;

import com.alkemy.challenge.challenge.entities.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity,Long> {
}
