package com.aps.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aps.domain.Bairro;
import com.aps.service.BairroService;

@RestController
@RequestMapping("bairros")
public class BairroResource {

	@Autowired
	private BairroService bairroService;

	@GetMapping
	public List<Bairro> buscar() {
		return bairroService.buscarTodosBairros();
	}

	@PostMapping
	public void salvar(@RequestBody Bairro bairro) {
		bairroService.salvarBairro(bairro);
	}

}
