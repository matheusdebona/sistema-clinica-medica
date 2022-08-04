package br.com.matheusdebona.sistemaclinicamedica.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.matheusdebona.sistemaclinicamedica.core.dao.connection.ConexaoMySQL;
import br.com.matheusdebona.sistemaclinicamedica.core.entity.UsuarioEntity;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class UsuarioDAO {
	
	public String salvarUsuario(UsuarioEntity usuario) throws NegocioException {
		
		String sql = "INSERT INTO USUARIO (NOME_USU, LOGIN_USU, EMAIL_USU, SENHA_USU) VALUES (?,?,?,?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, usuario.getSenha());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					throw new NegocioException("Erro ao cadastrar usuário");
				}
			}
		}
		
		
		//TODO Implementação do cadastro dessa informação no banco de dados.
		return "Usuário cadastrado com sucesso no banco de dados.";
		
	}
	
	public List<UsuarioEntity> listarUsuario() throws NegocioException {
		
		String sql = "SELECT ID_USUARIO, NOME_USU, LOGIN_USU, EMAIL_USU, SENHA_USU FROM USUARIO";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UsuarioEntity> usuarios = new ArrayList<>();
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				UsuarioEntity usu = new UsuarioEntity();
				usu.setCodigo(rs.getLong("ID_USUARIO"));
				usu.setNome(rs.getString("NOME_USU"));
				usu.setLogin(rs.getString("LOGIN_USU"));
				usu.setEmail(rs.getString("EMAIL_USU"));
				usu.setSenha(rs.getString("SENHA_USU"));
				usuarios.add(usu);
			}
			
		} catch (SQLException e) {
			throw new NegocioException("Erro ao listar usuários.");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return usuarios;
	}
	
	public Boolean autenticacaoUsuario(UsuarioEntity usuario) throws NegocioException {
		
		String sql = "SELECT LOGIN_USU FROM USUARIO WHERE LOGIN_USU = ? AND SENHA_USU = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			
			rs = ps.executeQuery();
			
			String login = null;
			while (rs.next()) {
				login = rs.getString("LOGIN_USU");
				if(login != null) {
					return true;
				} else {
					return false;
				}
				
			}
			
			
		} catch (SQLException e) {
			throw new NegocioException("Login ou Senha inválidos.");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	
	

}
