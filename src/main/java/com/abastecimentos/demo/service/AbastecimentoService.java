package com.abastecimentos.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abastecimentos.demo.dao.AbastecimentoDAO;
import com.abastecimentos.demo.dao.BombaCombustivelDAO;
import com.abastecimentos.demo.dao.TipoCombustivelDAO;
import com.abastecimentos.demo.dto.AbastecimentoCriarDTO;
import com.abastecimentos.demo.dto.AbastecimentoResponseDTO;
import com.abastecimentos.demo.dto.BombaCombustivelCriarDTO;
import com.abastecimentos.demo.dto.BombaCombustivelResponseDTO;
import com.abastecimentos.demo.dto.TipoCombustivelCriarDTO;
import com.abastecimentos.demo.dto.TipoCombustivelResponseDTO;
import com.abastecimentos.demo.model.Abastecimento;
import com.abastecimentos.demo.model.BombaCombustivel;
import com.abastecimentos.demo.model.TipoCombustivel;

@Service
public class AbastecimentoService {
	private final BombaCombustivelDAO bcDao;
	private final AbastecimentoDAO dao;
	
	public AbastecimentoService(AbastecimentoDAO dao, BombaCombustivelDAO bcDao) {
		this.dao = dao;
		this.bcDao = bcDao;
	}
	
	public AbastecimentoResponseDTO criar(AbastecimentoCriarDTO dto) {
		BombaCombustivel bc = bcDao.buscarPorId(dto.bombaCombustivelId());
		if(bc == null) {
			throw new RuntimeException("Bomba de Combustível não encontrada.");
		}
		
		Double valorTotal = bc.getTipoCombustivel().getPrecoLitro() * dto.litros();
		
		Abastecimento a = new Abastecimento(bc, dto.data(), valorTotal, dto.litros());
		
		Integer idCriado = dao.criar(a);
		return new AbastecimentoResponseDTO(
				idCriado, 
				new BombaCombustivelResponseDTO(
						bc.getId(), 
						bc.getNome(), 
						new TipoCombustivelResponseDTO(
								bc.getTipoCombustivel().getId(), 
								bc.getTipoCombustivel().getNome(), 
								bc.getTipoCombustivel().getPrecoLitro()
						)
				),
				a.getData(), 
				a.getValorTotal(), 
				a.getLitros()
		);
	}
	

	
	
}
