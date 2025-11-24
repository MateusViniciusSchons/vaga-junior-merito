package com.abastecimentos.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TipoCombustivelCriarDTO(
		@NotBlank (message = "O campo 'nome' é obrigatório.")
		String nome, 
		
		@NotNull (message = "O campo 'precoLitro' é obrigatório.")
		Double precoLitro) {}
