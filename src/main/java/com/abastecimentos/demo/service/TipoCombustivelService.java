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
		
		return dao.listarTodos().stream().map(tc -> new TipoCombustivelResponseDTO(tc.getId(), tc.getNome(), tc.getPrecoLitro())).toList();
		
	}
	
	public TipoCombustivelResponseDTO alterar(Integer id, TipoCombustivelCriarDTO dto) {
		
		TipoCombustivel existe = dao.buscarPorId(id);
		if(existe == null) {
			throw new RuntimeException("Tipo de combustível não encontrado.");
		}
		
		existe.setNome(dto.nome());
		existe.setPrecoLitro(dto.precoLitro());
		
		dao.alterar(existe);
		
		return new TipoCombustivelResponseDTO(existe.getId(), existe.getNome(), existe.getPrecoLitro());
		
	}
	
	public void deletar(Integer id) {
		
		TipoCombustivel existe = dao.buscarPorId(id);
		if(existe == null) {
			throw new RuntimeException("Tipo de combustível não encontrado.");
		}
		
		
		dao.deletar(id);
		
	}
}
