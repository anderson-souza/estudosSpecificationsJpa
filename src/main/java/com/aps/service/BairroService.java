package com.aps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.domain.Bairro;
import com.aps.repository.BairroRepository;

@Service
public class BairroService {

	@Autowired
	BairroRepository bairroRepository;

	public List<Bairro> buscarTodosBairros() {
		return bairroRepository.findAll();
	}

	public void salvarBairro(Bairro bairro) {
		bairroRepository.save(bairro);
	}

}
