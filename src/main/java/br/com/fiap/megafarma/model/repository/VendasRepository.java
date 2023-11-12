package br.com.fiap.megafarma.model.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.megafarma.model.entity.Venda;

public class VendasRepository extends Repository{

	public static ArrayList<Venda> findAll(){
		ArrayList<Venda> vendas = new ArrayList<Venda>();		
		String sql = "select * from tb_vendas";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Venda venda = new Venda();
					venda.setId(rs.getLong("id"));
					venda.setDataVenda(rs.getDate("data_da_venda").toLocalDate());
					venda.setIdCliente(rs.getLong("cliente"));
					vendas.add(venda);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " +e.getMessage());
		} finally {
			closeConnection();
		}
		return vendas;
	}
	
	public static Venda save(Venda venda) {
		String sql = "insert into tb_vendas "
				+ "(id, data_da_venda, cliente)"
				+ " values(null, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setDate(1, Date.valueOf(venda.getDataVenda()));
			ps.setLong(2, venda.getIdCliente());
			if (ps.executeUpdate() > 0) {
				return venda;
			} else {				
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	public static Venda update(Venda venda) {
		String sql = "Update tb_vendas "
				+ "SET data_da_venda=?, cliente = ? "
				+ "WHERE id=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setDate(1, Date.valueOf(venda.getDataVenda()));
			ps.setLong(2, venda.getIdCliente());
			ps.setLong(3, venda.getId());
			if (ps.executeUpdate() > 0) {
				return venda;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	public static boolean delete(Long id) {
		String sql = "delete from tb_vendas where vendas=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, id);
			if (ps.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar " + e.getMessage());
		} finally {
			closeConnection();
		}
		return false;
	}
}
