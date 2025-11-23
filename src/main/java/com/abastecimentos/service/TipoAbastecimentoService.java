package com.abastecimentos.service;

import com.abastecimentos.demo.dao.TipoAbastecimentoDAO;
import com.abastecimentos.demo.dto.TipoAbastecimentoCriarDTO;
import com.abastecimentos.demo.dto.TipoAbastecimentoResponseDTO;
import com.abastecimentos.demo.model.TipoAbastecimento;

public class TipoAbastecimentoService {
	private TipoAbastecimentoDAO dao = new TipoAbastecimentoDAO();
	
	public TipoAbastecimentoResponseDTO criar(TipoAbastecimentoCriarDTO dto) {
		TipoAbastecimento ta = new TipoAbastecimento(dto.nome(), dto.precoLitro());
		Integer idCriado = dao.criar(ta);
		return new TipoAbastecimentoResponseDTO(idCriado, dto.nome(), dto.precoLitro());
	}
}
