package com.abastecimentos.demo.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record AbastecimentoCriarDTO(Integer bombaCombustivelId, @JsonFormat(pattern = "dd/MM/yyyy") LocalDate data, Double valorTotal, Double litros) {}
