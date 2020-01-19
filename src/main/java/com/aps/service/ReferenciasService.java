package com.aps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.domain.Referencias;
import com.aps.repository.ReferenciaRepository;
import com.aps.specs.ReferenciaSpecification;

@Service
public class ReferenciasService {

	@Autowired
	private ReferenciaRepository referenciasRepository;

	public List<Referencias> listarReferenciasFiltrandoCepBairroIDLogradouroID(String cep, Long bairroId,
			Long logradouroId) {
		return referenciasRepository
				.findAll(ReferenciaSpecification.buscaCombinadaPorCepOuBairroOuRua(cep, bairroId, logradouroId));
	}

	public List<Referencias> listarReferenciasFiltrandoCepBairroNomeLogradouroNome(String cep, String bairroNome,
			String logradouroNome) {
		return referenciasRepository.findAll(ReferenciaSpecification
				.buscaCombinadaPorCepOuNomeBairroOuNomeLogradouro(cep, bairroNome, logradouroNome));
	}

	public void salvarReferencia(Referencias referencia) {
		referenciasRepository.save(referencia);
	}

}
