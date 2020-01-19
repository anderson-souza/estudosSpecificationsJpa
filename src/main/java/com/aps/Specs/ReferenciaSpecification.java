package com.aps.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.aps.domain.Bairro;
import com.aps.domain.Logradouro;
import com.aps.domain.Referencias;

public final class ReferenciaSpecification {

	private ReferenciaSpecification() {

	}

	public static Specification<Referencias> buscaCombinadaPorCepOuBairroOuRua(String cep, Long bairroId,
			Long logradouroId) {
		return new Specification<Referencias>() {

			@Override
			public Predicate toPredicate(Root<Referencias> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {

				Predicate predicate = criteriaBuilder.and();

				if (!StringUtils.isAllEmpty(cep)) {
					predicate.getExpressions().add(criteriaBuilder.like(root.get("cep"), "%" + cep + "%"));
				}

				if (bairroId != null) {
					predicate.getExpressions().add(criteriaBuilder.and(root.get("bairro").in(bairroId)));
				}

				if (logradouroId != null) {
					predicate.getExpressions().add(criteriaBuilder.and(root.get("logradouro").in(logradouroId)));
				}

				return predicate;
			}
		};
	}

	public static Specification<Referencias> buscaCombinadaPorCepOuNomeBairroOuNomeLogradouro(String cep,
			String nomeBairro, String nomeLogradouro) {
		return (root, query, criteriaBuilder) -> {

			final Predicate predicate = criteriaBuilder.and();

			if (!StringUtils.isAllEmpty(cep)) {
				predicate.getExpressions().add(criteriaBuilder.like(root.get("cep"), "%" + cep + "%"));
			}

			if (!StringUtils.isAllEmpty(nomeBairro)) {
				final Join<Referencias, Bairro> joinBairro = root.join("bairro", JoinType.INNER);
				predicate.getExpressions().add(criteriaBuilder.and(criteriaBuilder
						.like(criteriaBuilder.upper(joinBairro.get("nome")), "%" + nomeBairro.toUpperCase() + "%")));
			}

			if (!StringUtils.isAllEmpty(nomeLogradouro)) {
				final Join<Referencias, Logradouro> joinLogradouro = root.join("logradouro", JoinType.INNER);
				predicate.getExpressions()
						.add(criteriaBuilder.and(criteriaBuilder.like(criteriaBuilder.upper(joinLogradouro.get("nome")),
								"%" + nomeLogradouro.toUpperCase() + "%")));
			}

			return predicate;
		};
	}

}
