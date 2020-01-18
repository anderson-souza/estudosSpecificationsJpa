package com.aps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.domain.Logradouro;
import com.aps.repository.LogradouroRepository;

@Service
public class LogradouroService {

	@Autowired
	LogradouroRepository logradouroRepository;

	public List<Logradouro> buscarTodosLogradouros() {
		return logradouroRepository.findAll();
	}

	public void salvarLogradouro(Logradouro logradouro) {
		logradouroRepository.save(logradouro);
	}

}
