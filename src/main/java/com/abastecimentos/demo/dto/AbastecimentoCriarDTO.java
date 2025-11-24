package com.abastecimentos.demo.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AbastecimentoCriarDTO(
		@NotNull (message = "O campo 'bomba de combustível' é obrigatório.")
		Integer bombaCombustivelId, 
		
		@NotNull (message = "O campo 'data' é obrigatório.")
		@JsonFormat(pattern = "dd/MM/yyyy") 
		LocalDate data, 
		
		@NotNull (message = "O campo 'litros' é obrigatório.")
		Double litros) {}
