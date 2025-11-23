package com.abastecimentos.demo.model;

public class BombaCombustivel {
	private int id;
    private String nome;
    private TipoCombustivel tipoCombustivel;
    private Boolean deletado;
    
    public BombaCombustivel(String nome, TipoCombustivel tipoCombustivel) {
    	this.nome = nome;
    	this.tipoCombustivel = tipoCombustivel;
    }
    
    public BombaCombustivel(Integer id, String nome, TipoCombustivel tipoCombustivel, Boolean deletado) {
    	this.id = id;
    	this.nome = nome;
    	this.tipoCombustivel = tipoCombustivel;
    	this.deletado = deletado;
    }
    
    public BombaCombustivel() {
    	
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
	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}
	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
	public Boolean getDeletado() {
		return deletado;
	}
	public void setDeletado(Boolean deletado) {
		this.deletado = deletado;
	}
}
