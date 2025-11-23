package com.abastecimentos.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abastecimentos.demo.model.TipoCombustivel;

import java.sql.*;
import java.util.List;

@Repository
public class TipoCombustivelDAO {

	@Autowired
	private JdbcTemplate jdbc;
    
    public Integer criar(TipoCombustivel tc) {
        String sql = "INSERT INTO tipos_combustivel (nome, preco_litro) VALUES (?, ?) RETURNING id;";

        return jdbc.queryForObject(sql, Integer.class, tc.getNome(), tc.getPrecoLitro());
    }
    
    public List<TipoCombustivel> listarTodos() {
    	String sql = "SELECT * FROM tipos_combustivel;";
    	return jdbc.query(sql, (rs, rowNum) -> {
    		TipoCombustivel tc = new TipoCombustivel();
    		tc.setId(rs.getInt("id"));
    		tc.setNome(rs.getString("nome"));
    		tc.setPrecoLitro(rs.getDouble("preco_litro"));
    		tc.setDeletado(rs.getBoolean("deletado"));
    		
    		return tc;
    	});
    }
}