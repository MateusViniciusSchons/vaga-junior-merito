package com.abastecimentos.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abastecimentos.demo.model.BombaCombustivel;
import com.abastecimentos.demo.model.TipoCombustivel;

import java.sql.*;
import java.util.List;

@Repository
public class BombaCombustivelDAO {

	@Autowired
	private JdbcTemplate jdbc;
	
	 public Integer criar(BombaCombustivel bc) {
        String sql = "INSERT INTO bombas_combustivel (nome, tipo_combustivel) VALUES (?, ?) RETURNING id;";

        return jdbc.queryForObject(sql, Integer.class, bc.getNome(), bc.getTipoCombustivel().getId());
    }
	 
    
    
}