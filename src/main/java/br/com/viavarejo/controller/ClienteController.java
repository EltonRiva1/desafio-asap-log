package br.com.viavarejo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.viavarejo.model.Cliente;
import br.com.viavarejo.service.impl.ClienteServiceImpl;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteServiceImpl clienteServiceImpl;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> create(@RequestBody(required = true) @Valid Cliente cliente) {
		return new ResponseEntity<Cliente>(this.clienteServiceImpl.create(cliente), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> update(@RequestBody(required = true) @Valid Cliente cliente,
			@PathVariable("id") String id) {
		return new ResponseEntity<Cliente>(this.clienteServiceImpl.update(cliente, id), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> findById(@PathVariable(required = true, name = "id") String id) {
		return new ResponseEntity<Cliente>(this.clienteServiceImpl.findById(id), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(required = true, name = "id") String id) {
		this.clienteServiceImpl.delete(id);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> findAll() {
		return new ResponseEntity<List<Cliente>>(this.clienteServiceImpl.findAll(), HttpStatus.OK);
	}
}
