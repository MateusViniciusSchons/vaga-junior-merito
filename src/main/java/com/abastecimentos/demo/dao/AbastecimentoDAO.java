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
	 
	 public List<Abastecimento> listarTodos() {
	    	String sql = "SELECT a.id as a_id, a.bomba_combustivel as a_bomba_combustivel, a.data as a_data, a.valor_total as a_valor_total, a.litros as a_litros, a.deletado as a_deletado, tc.id as tc_id, tc.nome as tc_nome, tc.preco_litro as tc_preco_litro, tc.deletado as tc_deletado, bc.id as bc_id, bc.nome as bc_nome, bc.tipo_combustivel as bc_tipo_combustivel, bc.deletado as bc_deletado FROM abastecimentos a JOIN bombas_combustivel bc ON bc.id  = a.bomba_combustivel JOIN tipos_combustivel tc ON tc.id = bc.tipo_combustivel WHERE a.deletado = false;";
	    	return jdbc.query(sql, (rs, rowNum) -> {
	    		Abastecimento a = new Abastecimento();
	    		a.setId(rs.getInt("a_id"));
	    		a.setBombaCombustivel(new BombaCombustivel(rs.getInt("bc_id"), rs.getString("bc_nome"), new TipoCombustivel(rs.getInt("tc_id"), rs.getString("tc_nome"), rs.getDouble("tc_preco_litro"), rs.getBoolean("tc_deletado")), rs.getBoolean("bc_deletado")));
	    		a.setData(rs.getDate("a_data").toLocalDate());
	    		a.setValorTotal(rs.getDouble("a_valor_total"));
	    		a.setLitros(rs.getDouble("a_litros"));
	    		a.setDeletado(rs.getBoolean("a_deletado"));
	    		
	    		return a;
	    	});
	    }
	 
	 public Abastecimento buscarPorId(Integer id) {
		 String sql = "SELECT a.id as a_id, a.bomba_combustivel as a_bomba_combustivel, a.data as a_data, a.valor_total as a_valor_total, a.litros as a_litros, a.deletado as a_deletado, tc.id as tc_id, tc.nome as tc_nome, tc.preco_litro as tc_preco_litro, tc.deletado as tc_deletado, bc.id as bc_id, bc.nome as bc_nome, bc.tipo_combustivel as bc_tipo_combustivel, bc.deletado as bc_deletado FROM abastecimentos a JOIN bombas_combustivel bc ON bc.id  = a.bomba_combustivel JOIN tipos_combustivel tc ON tc.id = bc.tipo_combustivel WHERE a.id = ?;";
		 return jdbc.query(sql, rs -> rs.next()? new Abastecimento(rs.getInt("a_id"), new BombaCombustivel(rs.getInt("bc_id"), rs.getString("bc_nome"), new TipoCombustivel(rs.getInt("tc_id"), rs.getString("tc_nome"), rs.getDouble("tc_preco_litro"), rs.getBoolean("tc_deletado")), rs.getBoolean("bc_deletado")), 
				 rs.getDate("a_data").toLocalDate(), 
				 rs.getDouble("a_valor_total"), rs.getDouble("a_litros"), rs.getBoolean("a_deletado"))
				 : null, id);
	 }
 
	 public void alterar(Abastecimento a) {
		 	String sql = "UPDATE abastecimentos SET bomba_combustivel = ?, data = ?, valor_total = ?, litros = ? WHERE id = ?;";
		 	jdbc.update(sql, a.getBombaCombustivel().getId(), a.getData(), a.getValorTotal(), a.getLitros(), a.getId());
	 }
	 
	 
}