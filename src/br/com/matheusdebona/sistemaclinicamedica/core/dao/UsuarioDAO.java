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
			e.printStackTrace();
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
	
	
	public void excluirUsuario(Long codigoUsuario) throws NegocioException {
		
		String sql = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoUsuario);
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new NegocioException("Não foi possível excluir o usuário.");
			
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
		
	}
	
	public UsuarioEntity buscarUsuarioPorId(Long codigoUsuario) throws NegocioException {
		
		String sql = "SELECT ID_USUARIO, NOME_USU, LOGIN_USU, EMAIL_USU, SENHA_USU FROM USUARIO WHERE ID_USUARIO = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoUsuario);
			
			rs = ps.executeQuery();
			
			UsuarioEntity usuarioEncontrado = null;

			if(rs.next()) {
				usuarioEncontrado = new UsuarioEntity();
				usuarioEncontrado.setCodigo(rs.getLong("ID_USUARIO"));
				usuarioEncontrado.setNome(rs.getString("NOME_USU"));
				usuarioEncontrado.setLogin(rs.getString("LOGIN_USU"));
				usuarioEncontrado.setEmail(rs.getString("EMAIL_USU"));
				usuarioEncontrado.setSenha(rs.getString("SENHA_USU"));
				
			}
			
			return usuarioEncontrado;
			
		} catch (SQLException e) {
			throw new NegocioException("Erro ao BUSCAR usuário.");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public String editarUsuario(UsuarioEntity usuario) throws NegocioException {
		
		String sql = "UPDATE USUARIO SET NOME_USU = ?, LOGIN_USU = ?, EMAIL_USU = ?, SENHA_USU = ? WHERE ID_USUARIO = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, usuario.getSenha());
			ps.setLong(5, usuario.getCodigo());
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new NegocioException("Ocorreu um erro ao atualizar os dados do usuário.");
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return "O usuário foi alterado com sucesso.";
		
	}
	
	public List<UsuarioEntity> buscarUsuarioFiltrado(UsuarioEntity usuario) throws NegocioException {
		
		String sql = "SELECT ID_USUARIO, NOME_USU, LOGIN_USU, EMAIL_USU, SENHA_USU FROM USUARIO ";
		
		boolean adicionaWhere = true;
		
		List<UsuarioEntity> resultado = new ArrayList<>();
		
		if(usuario != null) {
			if (usuario.getCodigo() != null) {
				adicionaWhere = false;
				sql += "WHERE ";
				sql += "ID_USUARIO = ? ";
				
			}
			if (usuario.getNome() != null && !usuario.getNome().equals("")) {
				if(adicionaWhere) {
					sql += "WHERE ";
					adicionaWhere = false;
				} else {
					sql += "AND ";
				}
				sql += "NOME_USU LIKE ? ";
			}
			if (usuario.getLogin() != null && !usuario.getLogin().equals("")) {
				if(adicionaWhere) {
					sql += "WHERE ";
					adicionaWhere = false;
				} else {
					sql += "OR ";
				}
				sql += "LOGIN_USU LIKE ? ";
			}
			if (usuario.getEmail() != null && !usuario.getEmail().equals("")) {
				if(adicionaWhere) {
					sql += "WHERE ";
					adicionaWhere = false;
				} else {
					sql += "OR ";
				}
				sql += "EMAIL_USU LIKE ? ";
			}
			if (usuario.getSenha() != null && !usuario.getSenha().equals("")) {
				if(adicionaWhere) {
					sql += "WHERE ";
					adicionaWhere = false;
				} else {
					sql += "OR ";
				}
				sql += "SENHA_USU LIKE ? ";
			}
			
		}
		System.out.println(sql);
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			
			int indice = 0;
			
			if(usuario != null) {
				if(usuario.getCodigo() != null) {
					indice = indice + 1;
					ps.setLong(indice, usuario.getCodigo());
				}
				if (usuario.getNome() != null && !usuario.getNome().equals("")) {
					indice = indice + 1;
					ps.setString(indice, usuario.getNome() + "%");
				}
				if (usuario.getLogin() != null && !usuario.getLogin().equals("")) {
					indice = indice + 1;
					ps.setString(indice, usuario.getLogin() + "%");
				}
				if (usuario.getEmail() != null && !usuario.getEmail().equals("")) {
					indice = indice + 1;
					ps.setString(indice, usuario.getEmail() + "%");
				}
				if (usuario.getSenha() != null && !usuario.getSenha().equals("")) {
					indice = indice + 1;
					ps.setString(indice, usuario.getSenha() + "%");
				}
				
			}
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				UsuarioEntity usuarioResultado = new UsuarioEntity();
				usuarioResultado.setCodigo(rs.getLong("ID_USUARIO"));
				usuarioResultado.setNome(rs.getString("NOME_USU"));
				usuarioResultado.setLogin(rs.getString("LOGIN_USU"));
				usuarioResultado.setEmail(rs.getString("EMAIL_USU"));
				usuarioResultado.setSenha(rs.getString("SENHA_USU"));
				resultado.add(usuarioResultado);
				
			}
			
		} catch (SQLException e) {
			throw new NegocioException("Busca filtrada falhou");
		}finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
	}	
	
	
	
	

}
