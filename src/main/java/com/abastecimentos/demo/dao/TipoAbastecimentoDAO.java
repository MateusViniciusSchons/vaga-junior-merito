package com.abastecimentos.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abastecimentos.demo.model.TipoAbastecimento;

import java.sql.*;
import java.util.List;

@Repository
public class TipoAbastecimentoDAO {

	@Autowired
	private JdbcTemplate jdbc;
    
    public Integer criar(TipoAbastecimento ta) {
        String sql = "INSERT INTO tipos_abastecimento (nome, preco_litro) VALUES (?, ?) RETURNING id;";

        return jdbc.update(sql, ta.getNome(), ta.getPrecoLitro());
    }
}