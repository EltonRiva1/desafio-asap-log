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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/apolices")
@Api(value = "Apolice")
public class ApoliceController {
	@Autowired
	private ApoliceServiceImpl apoliceServiceImpl;

	@ApiOperation(value = "Create an policy")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Apolice> create(@RequestBody(required = true) @Valid Apolice apolice) {
		return new ResponseEntity<Apolice>(this.apoliceServiceImpl.create(apolice), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update an policy by its number")
	@PutMapping(value = "/{numero}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Apolice> update(@RequestBody(required = true) @Valid Apolice apolice,
			@PathVariable("numero") String numero) {
		return new ResponseEntity<Apolice>(this.apoliceServiceImpl.update(apolice, numero), HttpStatus.OK);
	}

	@ApiOperation(value = "Delete an policy by its number")
	@DeleteMapping(value = "/{numero}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(required = true, name = "numero") String numero) {
		this.apoliceServiceImpl.delete(numero);
	}
	
	@ApiOperation(value = "Find by policy for your number")
	@GetMapping(value = "/findByNumero/{numero}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Apolice> findByNumero(@PathVariable(required = true, name = "numero") String numero) {
		return new ResponseEntity<Apolice>(this.apoliceServiceImpl.findByNumero(numero), HttpStatus.OK);
	}

	@ApiOperation(value = "List all policy")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Apolice>> findAll() {
		return new ResponseEntity<List<Apolice>>(this.apoliceServiceImpl.findAll(), HttpStatus.OK);
	}
}
