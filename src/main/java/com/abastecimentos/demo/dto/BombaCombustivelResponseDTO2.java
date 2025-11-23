package com.abastecimentos.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BombaCombustivelResponseDTO2(Integer id, String nome, @JsonProperty("tipoCombustivel") TipoCombustivelResponseDTO tipoCombustivelResponseDTO) {}
