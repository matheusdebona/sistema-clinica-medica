package br.com.matheusdebona.sistemaclinicamedica.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.matheusdebona.sistemaclinicamedica.core.dao.connection.ConexaoMySQL;
import br.com.matheusdebona.sistemaclinicamedica.core.entity.ClienteEntity;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class ClienteDAO {
	
	public String salvarCliente(ClienteEntity cliente) throws NegocioException {
		
		String sql = "INSERT INTO CLIENTE (NOME_CLIENTE, CPF_CLIENTE, ENDERECO_CLIENTE, TELEFONE_CLIENTE) VALUES (?,?,?,?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getEndereco());
			ps.setString(4, cliente.getTelefone());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					throw new NegocioException("Erro ao cadastrar cliente");
				}
			}
		}
		
		
		return "Salvo com sucesso";
		
	}
	
	public List<ClienteEntity> listarCliente() throws NegocioException {
		
		String sql = "SELECT ID_CLIENTE, NOME_CLIENTE, CPF_CLIENTE, ENDERECO_CLIENTE, TELEFONE_CLIENTE FROM CLIENTE";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ClienteEntity> clientes = new ArrayList<>();
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				ClienteEntity cliente = new ClienteEntity();
				cliente.setCodigo(rs.getLong("ID_CLIENTE"));
				cliente.setNome(rs.getString("NOME_CLIENTE"));
				cliente.setCpf(rs.getString("CPF_CLIENTE"));
				cliente.setEndereco(rs.getString("ENDERECO_CLIENTE"));
				cliente.setTelefone(rs.getString("TELEFONE_CLIENTE"));
				clientes.add(cliente);
			}
			
		} catch (SQLException e) {
			throw new NegocioException("Erro ao listar clientes.");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return clientes;
	}
	
	public void excluirCliente(Long codigoCliente) throws NegocioException {
		
		String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoCliente);
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new NegocioException("Não foi possível excluir o cliente.");
			
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
		
	}
	
	public ClienteEntity buscarClientePorId(Long codigoCliente) throws NegocioException {
		
		String sql = "SELECT ID_CLIENTE, NOME_CLIENTE, CPF_CLIENTE, ENDERECO_CLIENTE, TELEFONE_CLIENTE FROM CLIENTE WHERE ID_CLIENTE = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoCliente);
			
			rs = ps.executeQuery();
			
			ClienteEntity clienteEncontrado = null;

			if(rs.next()) {
				clienteEncontrado = new ClienteEntity();
				clienteEncontrado.setCodigo(rs.getLong("ID_CLIENTE"));
				clienteEncontrado.setNome(rs.getString("NOME_CLIENTE"));
				clienteEncontrado.setCpf(rs.getString("CPF_CLIENTE"));
				clienteEncontrado.setEndereco(rs.getString("ENDERECO_CLIENTE"));
				clienteEncontrado.setTelefone(rs.getString("TELEFONE_CLIENTE"));
				
			}
			
			return clienteEncontrado;
			
		} catch (SQLException e) {
			throw new NegocioException("Erro ao BUSCAR cliente.");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public String editarCliente(ClienteEntity cliente) throws NegocioException {
		
		String sql = "UPDATE CLIENTE SET NOME_CLIENTE = ?, CPF_CLIENTE = ?, ENDERECO_CLIENTE = ?, TELEFONE_CLIENTE = ? WHERE ID_CLIENTE = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getEndereco());
			ps.setString(4, cliente.getTelefone());
			ps.setLong(5, cliente.getCodigo());
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new NegocioException("Ocorreu um erro ao atualizar os dados do Cliente.");
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return "O cliente foi alterado com sucesso.";
		
	}
	
	
	
}
