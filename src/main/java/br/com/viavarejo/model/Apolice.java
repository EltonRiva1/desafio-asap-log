package br.com.viavarejo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class Apolice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String numero;
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataInicioVigencia;
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFimVigencia;
	@NotNull
	private String placaVeiculo;
	@NotNull
	private Double valor;
	@NotNull
	@DBRef // relationship MongoDB - Only apolice for only cliente or only clinte for many
			// apolice
	private Cliente cliente;

	@JsonProperty
	public String getNumero() {
		return numero;
	}

	@JsonIgnore
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dataFimVigencia == null) ? 0 : dataFimVigencia.hashCode());
		result = prime * result + ((dataInicioVigencia == null) ? 0 : dataInicioVigencia.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((placaVeiculo == null) ? 0 : placaVeiculo.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apolice other = (Apolice) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dataFimVigencia == null) {
			if (other.dataFimVigencia != null)
				return false;
		} else if (!dataFimVigencia.equals(other.dataFimVigencia))
			return false;
		if (dataInicioVigencia == null) {
			if (other.dataInicioVigencia != null)
				return false;
		} else if (!dataInicioVigencia.equals(other.dataInicioVigencia))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (placaVeiculo == null) {
			if (other.placaVeiculo != null)
				return false;
		} else if (!placaVeiculo.equals(other.placaVeiculo))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Apolice [numero=" + numero + ", dataInicioVigencia=" + dataInicioVigencia + ", dataFimVigencia="
				+ dataFimVigencia + ", placaVeiculo=" + placaVeiculo + ", valor=" + valor + ", cliente=" + cliente
				+ "]";
	}

}
