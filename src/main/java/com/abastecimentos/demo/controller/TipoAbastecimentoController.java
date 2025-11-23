package com.abastecimentos.demo.controller;
import java.util.Map;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abastecimentos.demo.dto.TipoAbastecimentoCriarDTO;
import com.abastecimentos.demo.dto.TipoAbastecimentoResponseDTO;
import com.abastecimentos.demo.model.TipoAbastecimento;
import com.abastecimentos.service.TipoAbastecimentoService;

@RestController
public class TipoAbastecimentoController {
	
	TipoAbastecimentoService service = new TipoAbastecimentoService();
	
	@PostMapping("/tipos-abastecimento")
    public ResponseEntity<?> criar(@RequestBody TipoAbastecimentoCriarDTO dto) {
    	try {
    		TipoAbastecimentoResponseDTO tipoAbastecimento =  service.criar(dto);
    		
    		
    		return ResponseEntity.status(201).body(tipoAbastecimento);
    	} catch(Exception e) {
    		return ResponseEntity.badRequest().body(Map.of("erro", e.getMessage()));
    	}
    }
}