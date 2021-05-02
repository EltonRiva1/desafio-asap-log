package br.com.viavarejo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viavarejo.enums.MessagesValidation;
import br.com.viavarejo.error.ErrorException;
import br.com.viavarejo.model.Cliente;
import br.com.viavarejo.repository.ClienteRepository;
import br.com.viavarejo.service.ClienteService;
import br.com.viavarejo.utils.MessageUtils;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente create(Cliente cliente) {
		// TODO Auto-generated method stub
		if (this.clienteRepository.existsByCpf(cliente.getCpf())) {
			throw new ErrorException(MessageUtils.getMessage(MessagesValidation.REGISTER_EXISTS));
		}
		return this.clienteRepository.save(cliente);
	}

	@Override
	public Cliente update(Cliente cliente, String id) {
		// TODO Auto-generated method stub
		if (!this.clienteRepository.existsById(id)) {
			throw new ErrorException(MessageUtils.getMessage(MessagesValidation.REGISTER_NOT_FOUND));
		}
		cliente.setId(id);
		return this.clienteRepository.save(cliente);
	}

	@Override
	public Cliente findById(String id) {
		// TODO Auto-generated method stub
		return this.clienteRepository.findById(id)
				.orElseThrow(() -> new ErrorException(MessageUtils.getMessage(MessagesValidation.REGISTER_NOT_FOUND)));
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		Cliente cliente = this.clienteRepository.findById(id)
				.orElseThrow(() -> new ErrorException(MessageUtils.getMessage(MessagesValidation.REGISTER_NOT_FOUND)));
		this.clienteRepository.delete(cliente);
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return this.clienteRepository.findAll();
	}

}
