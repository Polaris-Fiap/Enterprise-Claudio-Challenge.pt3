package br.com.fiap.Challengesprint3.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.Challengesprint3.dto.PacienteDtos.PacienteConsultasDto;
import br.com.fiap.Challengesprint3.dto.PacienteDtos.PacienteConsultasProntuarioDto;
import br.com.fiap.Challengesprint3.models.Paciente;
import br.com.fiap.Challengesprint3.repository.PacienteRepository;

@Transactional
@Service
public class PacienteService {

	@Autowired
	PacienteRepository repository;
	
	public List<Paciente> listAll() {
		return repository.findAll();
	}
	
	@Transactional
	public void save(Paciente paciente) {
		repository.save(paciente);
	}
	
	public void remove(Long id) {
        repository.deleteById(id);
    }

	public Optional<Paciente> getById(Long id) {
        return repository.findById(id);
    }

	public List<PacienteConsultasDto> getPacienteConsultaEspecialista() {
		List<Paciente> pacientes = repository.findAll();
		List<PacienteConsultasDto> dto = pacientes.stream().map(p -> new PacienteConsultasDto(p)).collect(Collectors.toList()); 
		return dto;
	}

	public List<PacienteConsultasProntuarioDto> getPacienteConsultaProntuarioDto() {
		List<Paciente> pacientes = repository.findAll();
		return pacientes.stream().map(p -> new PacienteConsultasProntuarioDto(p)).collect(Collectors.toList());
	}
}
