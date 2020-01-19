package com.aps.configs;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.aps.domain.Bairro;
import com.aps.domain.Logradouro;
import com.aps.domain.Referencias;
import com.aps.service.BairroService;
import com.aps.service.LogradouroService;
import com.aps.service.ReferenciasService;
import com.github.javafaker.Faker;

@Component
public class DatabaseInitializer implements ApplicationRunner {

	private static final int QUANTIDADE_REPETICOES = 100;

	@Autowired
	private BairroService bairroService;

	@Autowired
	private LogradouroService logradouroService;

	@Autowired
	private ReferenciasService referenciasService;

	Faker faker = new Faker(new Locale("pt-BR"));

	@Override
	public void run(ApplicationArguments args) throws Exception {
		popularTabelaBairros();
		popularTabelaLogradouro();
		popularTabelaReferencias();
	}

	public void popularTabelaBairros() {
		for (int i = 0; i < QUANTIDADE_REPETICOES; i++) {
			Bairro bairro = new Bairro();

			bairro.setNome("Bairro " + faker.address().lastName());
			bairroService.salvarBairro(bairro);
		}
	}

	public void popularTabelaLogradouro() {
		for (int i = 0; i < QUANTIDADE_REPETICOES; i++) {
			Logradouro logradouro = new Logradouro();

			logradouro.setNome(faker.address().streetName());
			logradouroService.salvarLogradouro(logradouro);
		}
	}

	public void popularTabelaReferencias() {
		for (int i = 0; i < QUANTIDADE_REPETICOES; i++) {
			Referencias referencia = new Referencias();

			referencia.setCep(faker.address().zipCode());

			Bairro bairro = new Bairro();
			bairro.setId((long) faker.number().numberBetween(1, QUANTIDADE_REPETICOES));

			Logradouro logradouro = new Logradouro();
			logradouro.setId((long) faker.number().numberBetween(1, QUANTIDADE_REPETICOES));

			referencia.setBairro(bairro);
			referencia.setLogradouro(logradouro);

			referenciasService.salvarReferencia(referencia);
		}
	}

}
