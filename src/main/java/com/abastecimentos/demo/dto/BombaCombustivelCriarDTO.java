package com.abastecimentos.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BombaCombustivelCriarDTO(
		@NotBlank (message = "O campo 'nome' é obrigatório.")
		String nome, 
		
		@NotNull (message = "O campo 'tipoCombustivel' é obrigatório.")
		Integer tipoCombustivelId) {}
