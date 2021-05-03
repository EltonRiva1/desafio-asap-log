package br.com.viavarejo.mapper;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.viavarejo.dto.ApoliceDTO;
import br.com.viavarejo.model.Apolice;

public class ApoliceMapper {

	private static final String EXPIRED = "Expired";
	private static final String OPENED = "Opened";

	public static ApoliceDTO convertApoliceToDto(Apolice apolice) {
		ApoliceDTO apoliceDTO = new ApoliceDTO();
		apoliceDTO.setNumero(apolice.getNumero());
		apoliceDTO.setDataInicioVigencia(apolice.getDataInicioVigencia());
		apoliceDTO.setDataFimVigencia(apolice.getDataFimVigencia());
		apoliceDTO.setPlacaVeiculo(apolice.getPlacaVeiculo());
		apoliceDTO.setValor(apolice.getValor());
		apoliceDTO.setCliente(apolice.getCliente());
		apoliceDTO.setSituation(apolice.getDataFimVigencia().isBefore(LocalDate.now()) ? EXPIRED : OPENED);
		apoliceDTO.setSituationInDays(apoliceDTO.getSituation().equals(EXPIRED)
				? "Your policy expired a long time ago "
						+ ChronoUnit.DAYS.between(apolice.getDataFimVigencia(), LocalDate.now()) + " days"
				: "Policy will expire in " + ChronoUnit.DAYS.between(LocalDate.now(), apolice.getDataFimVigencia())
						+ " days");
		return apoliceDTO;
	}
}
