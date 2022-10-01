package br.com.fiap.Challengesprint3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.Challengesprint3.models.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

    Optional<Paciente> findByEmail(String email); 
}
