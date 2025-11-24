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
	 
	 public List<BombaCombustivel> listarTodos() {
    	String sql = "SELECT tc.id as tc_id, tc.nome as tc_nome, tc.preco_litro as tc_preco_litro, tc.deletado as tc_deletado, bc.id as bc_id, bc.nome as bc_nome, bc.tipo_combustivel as bc_tipo_combustivel, bc.deletado as bc_deletado FROM bombas_combustivel bc JOIN tipos_combustivel tc ON tc.id = bc.tipo_combustivel WHERE bc.deletado = false;";
    	return jdbc.query(sql, (rs, rowNum) -> {
    		BombaCombustivel bc = new BombaCombustivel();
    		bc.setId(rs.getInt("bc_id"));
    		bc.setNome(rs.getString("bc_nome"));
    		bc.setTipoCombustivel(new TipoCombustivel(rs.getInt("tc_id"), rs.getString("tc_nome"), rs.getDouble("tc_preco_litro"), rs.getBoolean("tc_deletado")));
    		bc.setDeletado(rs.getBoolean("bc_deletado"));
    		
    		return bc;
    	});
    }
	 
	 public BombaCombustivel buscarPorId(Integer id) {
	    	String sql = "SELECT tc.id as tc_id, tc.nome as tc_nome, tc.preco_litro as tc_preco_litro, tc.deletado as tc_deletado, bc.id as bc_id, bc.nome as bc_nome, bc.tipo_combustivel as bc_tipo_combustivel, bc.deletado as bc_deletado FROM bombas_combustivel bc JOIN tipos_combustivel tc ON tc.id = bc.tipo_combustivel WHERE bc.id = ? AND bc.deletado = false;";
	    	return jdbc.query(sql, rs -> rs.next()? new BombaCombustivel(rs.getInt("bc_id"), rs.getString("bc_nome"), new TipoCombustivel(rs.getInt("tc_id"), rs.getString("tc_nome"), rs.getDouble("tc_preco_litro"), rs.getBoolean("tc_deletado")), rs.getBoolean("bc_deletado")) : null, id);
    }
    
    public void alterar(BombaCombustivel tc) {
    	String sql = "UPDATE bombas_combustivel SET nome = ?, tipo_combustivel = ? WHERE id = ?;";
    	jdbc.update(sql, tc.getNome(), tc.getTipoCombustivel().getId(), tc.getId());
    }
    
    public void deletar(Integer id) {
    	String sql = "UPDATE bombas_combustivel SET deletado = ? WHERE id = ?;";
    	jdbc.update(sql, true, id);
    }
    
}