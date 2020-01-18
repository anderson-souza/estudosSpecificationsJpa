package com.aps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.Specs.ReferenciaSpecification;
import com.aps.domain.Referencias;
import com.aps.repository.ReferenciaRepository;

@Service
public class ReferenciasService {

	@Autowired
	private ReferenciaRepository referenciasRepository;

	public List<Referencias> listarReferencias(String cep, Long bairroId, Long logradouroId) {
		return referenciasRepository
				.findAll(ReferenciaSpecification.buscaPorCepOuBairroOuRua(cep, bairroId, logradouroId));
	}

	public void salvarReferencia(Referencias referencia) {
		referenciasRepository.save(referencia);
	}

}
