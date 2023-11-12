package br.com.fiap.megafarma.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.megafarma.model.entity.ItensVendidos;

public class ItensVendidosRepository extends Repository{
	
	public static ArrayList<ItensVendidos> findAll(){
		ArrayList<ItensVendidos> itens = new ArrayList<ItensVendidos>();		
		String sql = "select * from tb_itens_vendidos";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ItensVendidos itensVendidos = new ItensVendidos();
					itensVendidos.setId(rs.getLong("venda"));
					itensVendidos.setIdRemedio(rs.getLong("remedio"));
					itensVendidos.setQuantidade(rs.getInt("quantidade"));
					itens.add(itensVendidos);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " +e.getMessage());
		} finally {
			closeConnection();
		}
		return itens;
	}
	
	public static ItensVendidos save(ItensVendidos itensVendidos) {
		String sql = "insert into tb_itens_vendidos"
				+ "(venda, remedio, quantidade)"
				+ " values(null, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, itensVendidos.getId());
			ps.setLong(2, itensVendidos.getIdRemedio());
			ps.setInt(3, itensVendidos.getQuantidade());
			if (ps.executeUpdate() > 0) {
				return itensVendidos;
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
	
	public static ItensVendidos update(ItensVendidos itensVendidos) {
		String sql = "Update tb_itens_vendidos "
				+ "SET remedio=?, quantidade=? "
				+ "WHERE venda=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, itensVendidos.getIdRemedio());
			ps.setInt(2, itensVendidos.getQuantidade());
			ps.setLong(3, itensVendidos.getQuantidade());
			if (ps.executeUpdate() > 0) {
				return itensVendidos;
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
		String sql = "delete from tb_itens_vendidos where remedio=?";
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
