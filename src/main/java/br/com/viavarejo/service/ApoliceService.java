package br.com.viavarejo.service;

import java.util.List;

import br.com.viavarejo.model.Apolice;

public interface ApoliceService {
	public Apolice create(Apolice apolice);

	public Apolice update(Apolice apolice, String numero);

	public Apolice findByNumero(String numero);

	public void delete(String numero);

	public List<Apolice> findAll();
}
