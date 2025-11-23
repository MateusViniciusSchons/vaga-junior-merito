package com.abastecimentos.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abastecimentos.demo.dao.TipoCombustivelDAO;
import com.abastecimentos.demo.dto.TipoCombustivelCriarDTO;
import com.abastecimentos.demo.dto.TipoCombustivelResponseDTO;
import com.abastecimentos.demo.model.TipoCombustivel;

@Service
public class TipoCombustivelService {
	private final TipoCombustivelDAO dao;
	
	public TipoCombustivelService(TipoCombustivelDAO dao) {
		this.dao = dao;
	}
	
	public TipoCombustivelResponseDTO criar(TipoCombustivelCriarDTO dto) {
		TipoCombustivel ta = new TipoCombustivel(dto.nome(), dto.precoLitro());
		Integer idCriado = dao.criar(ta);
		return new TipoCombustivelResponseDTO(idCriado, dto.nome(), dto.precoLitro());
	}
	
	public List<TipoCombustivelResponseDTO> listarTodos() {
		
		return dao.listarTodos().stream().map(ta -> new TipoCombustivelResponseDTO(ta.getId(), ta.getNome(), ta.getPrecoLitro())).toList();
		
	}
}
