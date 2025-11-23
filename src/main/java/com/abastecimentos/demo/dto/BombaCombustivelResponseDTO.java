package com.abastecimentos.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BombaCombustivelResponseDTO(Integer id, String nome, @JsonProperty("tipoCombustivel") TipoCombustivelResponseDTO tipoCombustivelResponseDTO) {}
