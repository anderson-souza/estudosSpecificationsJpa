package com.aps.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "referencias")
@NoArgsConstructor
public class Referencias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cep;

	@ManyToOne
	@JoinColumn(name = "logradouro_id")
	private Logradouro logradouro;

	@ManyToOne
	@JoinColumn(name = "bairro_id")
	private Bairro bairro;

}
