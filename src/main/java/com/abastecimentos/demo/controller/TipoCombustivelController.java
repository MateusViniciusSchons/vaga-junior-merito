package com.abastecimentos.demo.controller;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abastecimentos.demo.dto.TipoCombustivelCriarDTO;
import com.abastecimentos.demo.dto.TipoCombustivelResponseDTO;
import com.abastecimentos.demo.model.TipoCombustivel;
import com.abastecimentos.demo.service.TipoCombustivelService;

@RestController
public class TipoCombustivelController {
	
	private final TipoCombustivelService service;
	
	public TipoCombustivelController(TipoCombustivelService service) {
		this.service = service;
	}
	
	@PostMapping("/tipos-combustivel")
    public ResponseEntity<?> criar(@RequestBody TipoCombustivelCriarDTO dto) {
    	try {
    		TipoCombustivelResponseDTO tipoCombustivel =  service.criar(dto);
    		
    		
    		return ResponseEntity.status(201).body(tipoCombustivel);
    	} catch(Exception e) {
    		return ResponseEntity.badRequest().body(Map.of("erro", e.getMessage()));
    	}
    }
	
	@GetMapping("/tipos-combustivel")
    public ResponseEntity<?> listarTodos() {
    	try {
    		List<TipoCombustivelResponseDTO> tiposCombustivel =  service.listarTodos();
    		
    		
    		return ResponseEntity.status(200).body(tiposCombustivel);
    	} catch(Exception e) {
    		return ResponseEntity.badRequest().body(Map.of("erro", e.getMessage()));
    	}
    }
	
	@PutMapping("/tipos-combustivel/{id}")
    public ResponseEntity<?> alterar(@PathVariable Integer id, @RequestBody  TipoCombustivelCriarDTO dto) {
		
    	try {
    		TipoCombustivelResponseDTO tipoCombustivel =  service.alterar(id, dto);
    		
    		
    		return ResponseEntity.status(200).body(tipoCombustivel);
    	} catch(Exception e) {
    		return ResponseEntity.badRequest().body(Map.of("erro", e.getMessage()));
    	}
    }
}