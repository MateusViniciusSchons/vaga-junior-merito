package com.abastecimentos.demo.controller;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abastecimentos.demo.dto.AbastecimentoCriarDTO;
import com.abastecimentos.demo.dto.AbastecimentoResponseDTO;
import com.abastecimentos.demo.dto.BombaCombustivelCriarDTO;
import com.abastecimentos.demo.dto.BombaCombustivelResponseDTO;
import com.abastecimentos.demo.dto.TipoCombustivelCriarDTO;
import com.abastecimentos.demo.dto.TipoCombustivelResponseDTO;
import com.abastecimentos.demo.model.TipoCombustivel;
import com.abastecimentos.demo.service.AbastecimentoService;
import com.abastecimentos.demo.service.BombaCombustivelService;
import com.abastecimentos.demo.service.TipoCombustivelService;

@RestController
public class AbastecimentoController {
	
	private final AbastecimentoService service;
	
	public AbastecimentoController(AbastecimentoService service) {
		this.service = service;
	}
	
	@PostMapping("/abastecimentos")
    public ResponseEntity<?> criar(@RequestBody AbastecimentoCriarDTO dto) {
    	try {
    		AbastecimentoResponseDTO abastecimento=  service.criar(dto);
    		
    		
    		return ResponseEntity.status(201).body(abastecimento);
    	} catch(Exception e) {
    		return ResponseEntity.badRequest().body(Map.of("erro", e.getMessage()));
    	}
    }
	
}