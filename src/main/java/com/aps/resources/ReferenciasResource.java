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

	@GetMapping("/buscar-filtro-ids")
	public List<Referencias> buscarFiltrandoCepBairroIDLogradouroID(
			@RequestParam(required = false, name = "cep") String cep,
			@RequestParam(required = false, name = "bairroId") Long bairroId,
			@RequestParam(required = false, name = "logradouroId") Long logradouroId) {
		return referenciasService.listarReferenciasFiltrandoCepBairroIDLogradouroID(cep, bairroId, logradouroId);
	}

	@GetMapping("/buscar-filtro-nomes")
	public List<Referencias> buscarFiltrandoCepBairroNomeLogradouroNome(
			@RequestParam(required = false, name = "cep") String cep,
			@RequestParam(required = false, name = "bairroNome") String bairroNome,
			@RequestParam(required = false, name = "logradouroNome") String logradouroNome) {
		return referenciasService.listarReferenciasFiltrandoCepBairroNomeLogradouroNome(cep, bairroNome,
				logradouroNome);
	}

	@PostMapping
	public void salvar(@RequestBody Referencias referencia) {
		referenciasService.salvarReferencia(referencia);
	}

}
