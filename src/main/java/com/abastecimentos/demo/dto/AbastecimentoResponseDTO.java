package com.abastecimentos.demo.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public record AbastecimentoResponseDTO(Integer id, @JsonProperty("bombaCombustivel") BombaCombustivelResponseDTO bombaCombustivelResponseDTO, @JsonFormat(pattern = "dd/MM/yyyy") LocalDate data, Double valorTotal, double litros) {}
