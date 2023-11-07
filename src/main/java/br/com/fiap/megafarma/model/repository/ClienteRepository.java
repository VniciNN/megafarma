package br.com.fiap.megafarma.model.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.megafarma.model.entity.Cliente;

public class ClienteRepository extends Repository{
	
	public static ArrayList<Cliente> findAll(){
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();		
		String sql = "select * from tb_clientes";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setId(rs.getLong("id"));
					cliente.setNome(rs.getString("nome"));
					cliente.setCpf(rs.getString("cpf"));
					cliente.setEmail(rs.getString("email"));
					cliente.setData_de_nascimento(rs.getDate("data_de_nascimento").toLocalDate());
					clientes.add(cliente);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " +e.getMessage());
		} finally {
			closeConnection();
		}
		return clientes;
	}
	
	public static Cliente save(Cliente cliente) {
		String sql = "insert into tb_clientes"
				+ "(id, nome, cpf, email, data_de_nascimento)"
				+ " values(null, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getEmail());
			ps.setDate(4, Date.valueOf(cliente.getData_de_nascimento()));
			if (ps.executeUpdate() > 0) {
				return cliente;
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
	
	public static Cliente update(Cliente cliente) {
		String sql = "Update tb_clientes "
				+ "SET nome=?, cpf=?, email=?, data_de_nascimento=? "
				+ "WHERE id=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getEmail());
			ps.setDate(4, Date.valueOf(cliente.getData_de_nascimento()));
			ps.setLong(5, cliente.getId());
			if (ps.executeUpdate() > 0) {
				return cliente;
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
		String sql = "delete from tb_clientes where id=?";
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
