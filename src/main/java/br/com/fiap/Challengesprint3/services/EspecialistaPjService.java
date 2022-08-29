package br.com.fiap.Challengesprint3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.Challengesprint3.models.EspecialistaPj;
import br.com.fiap.Challengesprint3.repository.EspecialistaPjRepository;

@Service
public class EspecialistaPjService {

	@Autowired
	EspecialistaPjRepository repository;
	
	public List<EspecialistaPj> listAll() {
        return repository.findAll();
    }

    @Transactional
    public void save(EspecialistaPj especialistaPj) {
        repository.save(especialistaPj);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

}
