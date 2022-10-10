package br.com.fiap.Challengesprint3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.Challengesprint3.models.EspecialistaPj;
import br.com.fiap.Challengesprint3.repository.EspecialistaPjRepository;

@Service
public class EspecialistaPjService {

	@Autowired
	EspecialistaPjRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;
	
	public List<EspecialistaPj> listAll() {
        return repository.findAll();
    }

    @Transactional
    public void save(EspecialistaPj especialistaPj) {
        String senha = passwordEncoder.encode(especialistaPj.getPassword());
        especialistaPj.setPassword(senha);
        repository.save(especialistaPj);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public Optional<EspecialistaPj> getById(Long id) {
        return repository.findById(id);
    }

}
