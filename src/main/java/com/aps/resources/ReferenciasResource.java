package com.aps.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aps.domain.Referencias;
import com.aps.service.ReferenciasService;

@RestController
@RequestMapping("referencias")
public class ReferenciasResource {

	@Autowired
	private ReferenciasService referenciasService;

	@GetMapping
	public List<Referencias> buscar(@RequestParam(required = false, name = "cep") String cep,
			@RequestParam(required = false, name = "bairroId") Long bairroId,
			@RequestParam(required = false, name = "logradouroId") Long logradouroId) {
		return referenciasService.listarReferencias(cep, bairroId, logradouroId);
	}

	@PostMapping
	public void salvar(@RequestBody Referencias referencia) {
		referenciasService.salvarReferencia(referencia);
	}

}
