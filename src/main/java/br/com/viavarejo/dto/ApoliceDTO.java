package br.com.viavarejo.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.viavarejo.model.Cliente;

public class ApoliceDTO {
	private String numero;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataInicioVigencia;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFimVigencia;
	private String placaVeiculo;
	private Double valor;
	private Cliente cliente;
	private String situation;
	private String situationInDays;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public void setDataInicioVigencia(LocalDate dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}

	public LocalDate getDataFimVigencia() {
		return dataFimVigencia;
	}

	public void setDataFimVigencia(LocalDate dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getSituationInDays() {
		return situationInDays;
	}

	public void setSituationInDays(String situationInDays) {
		this.situationInDays = situationInDays;
	}

}
