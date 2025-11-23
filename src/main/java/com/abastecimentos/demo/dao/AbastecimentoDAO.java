package com.abastecimentos.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abastecimentos.demo.model.Abastecimento;
import com.abastecimentos.demo.model.BombaCombustivel;
import com.abastecimentos.demo.model.TipoCombustivel;

import java.sql.*;
import java.util.List;

@Repository
public class AbastecimentoDAO {

	@Autowired
	private JdbcTemplate jdbc;
	
	 public Integer criar(Abastecimento a) {
        String sql = "INSERT INTO abastecimentos (bomba_combustivel, data, valor_total, litros) VALUES (?, ?, ?, ?) RETURNING id;";

        return jdbc.queryForObject(sql, Integer.class, a.getBombaCombustivel().getId(), a.getData(), a.getValorTotal(), a.getLitros());
    }
	 
	 
}