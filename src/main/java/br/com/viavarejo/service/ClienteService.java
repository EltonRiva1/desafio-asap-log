package br.com.viavarejo.service;

import java.util.List;

import br.com.viavarejo.model.Cliente;

public interface ClienteService {

	public Cliente create(Cliente cliente);

	public Cliente update(Cliente cliente, String id);

	public Cliente findById(String id);

	public void delete(String id);

	public List<Cliente> findAll();
}
