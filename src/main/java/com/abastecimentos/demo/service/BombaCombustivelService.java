package com.abastecimentos.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abastecimentos.demo.dao.BombaCombustivelDAO;
import com.abastecimentos.demo.dao.TipoCombustivelDAO;
import com.abastecimentos.demo.dto.BombaCombustivelCriarDTO;
import com.abastecimentos.demo.dto.BombaCombustivelResponseDTO;
import com.abastecimentos.demo.dto.TipoCombustivelCriarDTO;
import com.abastecimentos.demo.dto.TipoCombustivelResponseDTO;
import com.abastecimentos.demo.model.BombaCombustivel;
import com.abastecimentos.demo.model.TipoCombustivel;

@Service
public class BombaCombustivelService {
	private final TipoCombustivelDAO tcDao;
	private final BombaCombustivelDAO dao;
	
	public BombaCombustivelService(BombaCombustivelDAO dao, TipoCombustivelDAO tcDao) {
		this.dao = dao;
		this.tcDao = tcDao;
	}
	
	public BombaCombustivelResponseDTO criar(BombaCombustivelCriarDTO dto) {
		TipoCombustivel tc = tcDao.buscarPorId(dto.tipoCombustivelId());
		if(tc == null) {
			throw new RuntimeException("Tipo de Combustível não encontrado.");
		}
		
		BombaCombustivel bc = new BombaCombustivel(dto.nome(), tc);
		
		Integer idCriado = dao.criar(bc);
		return new BombaCombustivelResponseDTO(idCriado, dto.nome(), new TipoCombustivelResponseDTO(tc.getId(), tc.getNome(), tc.getPrecoLitro()));
	}
	
	
}
