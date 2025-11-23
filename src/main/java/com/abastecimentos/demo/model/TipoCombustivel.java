package com.abastecimentos.demo.model;

public class TipoCombustivel {
	private int id;
    private String nome;
    private Double precoLitro;
    private Boolean deletado;
    
    public TipoCombustivel(String nome, Double precoLitro) {
    	this.nome = nome;
    	this.precoLitro = precoLitro;
    }
    
    public TipoCombustivel() {
    	
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPrecoLitro() {
		return precoLitro;
	}
	public void setPrecoLitro(Double precoLitro) {
		this.precoLitro = precoLitro;
	}
	public Boolean getDeletado() {
		return deletado;
	}
	public void setDeletado(Boolean deletado) {
		this.deletado = deletado;
	}
}
