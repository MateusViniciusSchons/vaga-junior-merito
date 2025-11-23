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
	

	public List<BombaCombustivelResponseDTO> listarTodos() {
		
		return dao.listarTodos().stream().map(bc -> new BombaCombustivelResponseDTO(bc.getId(), bc.getNome(), new TipoCombustivelResponseDTO(bc.getTipoCombustivel().getId(), bc.getTipoCombustivel().getNome(), bc.getTipoCombustivel().getPrecoLitro()))).toList();
		
	}
	
	public BombaCombustivelResponseDTO alterar(Integer id, BombaCombustivelCriarDTO dto) {
		
		BombaCombustivel existeBomba = dao.buscarPorId(id);
		if(existeBomba == null) {
			throw new RuntimeException("Bomba de combustível não encontrada.");
		}
		
		TipoCombustivel existeTipo = tcDao.buscarPorId(dto.tipoCombustivelId());
		if(existeTipo == null) {
			throw new RuntimeException("Tipo de Combustível não encontrado.");
		}
		
		existeBomba.setNome(dto.nome());
		existeBomba.setTipoCombustivel(existeTipo);
		
		dao.alterar(existeBomba);
		
		return new BombaCombustivelResponseDTO(existeBomba.getId(), existeBomba.getNome(), new TipoCombustivelResponseDTO(existeTipo.getId(), existeTipo.getNome(), existeTipo.getPrecoLitro()));
		
	}
	
	public void deletar(Integer id) {
		
		BombaCombustivel existe = dao.buscarPorId(id);
		if(existe == null) {
			throw new RuntimeException("Bomba de combustível não encontrada.");
		}
		
		
		dao.deletar(id);
		
	}
	
	
}
