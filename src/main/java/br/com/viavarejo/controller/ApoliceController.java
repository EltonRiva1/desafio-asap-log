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

import br.com.viavarejo.model.Apolice;
import br.com.viavarejo.service.impl.ApoliceServiceImpl;

@RestController
@RequestMapping("/apolices")
public class ApoliceController {
	@Autowired
	private ApoliceServiceImpl apoliceServiceImpl;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Apolice> create(@RequestBody(required = true) @Valid Apolice apolice) {
		return new ResponseEntity<Apolice>(this.apoliceServiceImpl.create(apolice), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{numero}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Apolice> update(@RequestBody(required = true) @Valid Apolice apolice,
			@PathVariable("numero") String numero) {
		return new ResponseEntity<Apolice>(this.apoliceServiceImpl.update(apolice, numero), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{numero}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(required = true, name = "id") String numero) {
		this.apoliceServiceImpl.delete(numero);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Apolice>> findAll() {
		return new ResponseEntity<List<Apolice>>(this.apoliceServiceImpl.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/findByNumero/{numero}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Apolice> findByNumero(@PathVariable(required = true, name = "id") String numero) {
		return new ResponseEntity<Apolice>(this.apoliceServiceImpl.findByNumero(numero), HttpStatus.OK);
	}
}
