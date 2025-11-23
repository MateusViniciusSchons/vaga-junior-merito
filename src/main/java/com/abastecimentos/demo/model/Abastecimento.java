package com.abastecimentos.demo.model;

import java.time.LocalDate;

public class Abastecimento {
	private int id;
    private BombaCombustivel bombaCombustivel;
    private LocalDate data;
    private Double valorTotal;
    private Double litros;
    private Boolean deletado;
	public Abastecimento(int id, BombaCombustivel bombaCombustivel, LocalDate data, Double valorTotal, Double litros,
			Boolean deletado) {
		this.id = id;
		this.bombaCombustivel = bombaCombustivel;
		this.data = data;
		this.valorTotal = valorTotal;
		this.litros = litros;
		this.deletado = deletado;
	}
	public Abastecimento(BombaCombustivel bombaCombustivel, LocalDate data, Double valorTotal, Double litros) {
		this.bombaCombustivel = bombaCombustivel;
		this.data = data;
		this.valorTotal = valorTotal;
		this.litros = litros;
	}
	public Abastecimento() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BombaCombustivel getBombaCombustivel() {
		return bombaCombustivel;
	}
	public void setBombaCombustivel(BombaCombustivel bombaCombustivel) {
		this.bombaCombustivel = bombaCombustivel;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Double getLitros() {
		return litros;
	}
	public void setLitros(Double litros) {
		this.litros = litros;
	}
	public Boolean getDeletado() {
		return deletado;
	}
	public void setDeletado(Boolean deletado) {
		this.deletado = deletado;
	}
    
	
}
