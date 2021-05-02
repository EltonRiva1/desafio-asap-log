package br.com.viavarejo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viavarejo.enums.MessagesValidation;
import br.com.viavarejo.error.ErrorException;
import br.com.viavarejo.model.Apolice;
import br.com.viavarejo.repository.ApoliceRepository;
import br.com.viavarejo.repository.ClienteRepository;
import br.com.viavarejo.service.ApoliceService;
import br.com.viavarejo.utils.MessageUtils;

@Service
public class ApoliceServiceImpl implements ApoliceService {
	@Autowired
	private ApoliceRepository apoliceRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Apolice create(Apolice apolice) {
		// TODO Auto-generated method stub
		if (!this.clienteRepository.existsById(apolice.getCliente().getId())) {
			throw new ErrorException(MessageUtils.getMessage(MessagesValidation.REGISTER_NOT_FOUND));
		}
		return this.apoliceRepository.save(apolice);
	}

	@Override
	public Apolice update(Apolice apolice, String numero) {
		// TODO Auto-generated method stub
		if (!this.apoliceRepository.existsById(numero)) {
			throw new ErrorException(MessageUtils.getMessage(MessagesValidation.REGISTER_NOT_FOUND));
		}
		apolice.setNumero(numero);
		return this.apoliceRepository.save(apolice);
	}

	@Override
	public Apolice findByNumero(String numero) {
		// TODO Auto-generated method stub
		return this.apoliceRepository.findById(numero)
				.orElseThrow(() -> new ErrorException(MessageUtils.getMessage(MessagesValidation.REGISTER_NOT_FOUND)));
	}

	@Override
	public void delete(String numero) {
		// TODO Auto-generated method stub
		Apolice apolice = this.apoliceRepository.findById(numero)
				.orElseThrow(() -> new ErrorException(MessageUtils.getMessage(MessagesValidation.REGISTER_NOT_FOUND)));
		this.apoliceRepository.delete(apolice);
	}

	@Override
	public List<Apolice> findAll() {
		// TODO Auto-generated method stub
		return this.apoliceRepository.findAll();
	}

}
