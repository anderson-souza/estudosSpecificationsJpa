package com.aps.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aps.domain.Logradouro;
import com.aps.service.LogradouroService;

@RestController
@RequestMapping("logradouros")
public class LogradouroResource {

	@Autowired
	private LogradouroService logradouroService;

	@GetMapping
	public List<Logradouro> buscar() {
		return logradouroService.buscarTodosLogradouros();
	}

	@PostMapping
	public void salvar(@RequestBody Logradouro logradouro) {
		logradouroService.salvarLogradouro(logradouro);
	}

}
