package com.aps.Specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.aps.domain.Referencias;

public class ReferenciaSpecification {

	public static Specification<Referencias> buscaPorCepOuBairroOuRua(String cep, Long bairroId, Long logradouroId) {
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

}
