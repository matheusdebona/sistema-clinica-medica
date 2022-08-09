package br.com.matheusdebona.sistemaclinicamedica.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.matheusdebona.sistemaclinicamedica.core.dao.connection.ConexaoMySQL;
import br.com.matheusdebona.sistemaclinicamedica.core.entity.ProcedimentoEntity;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class ProcedimentoDAO {
	
	public String salvarProcedimento(ProcedimentoEntity procedimento) throws NegocioException {
		
		String sql = "INSERT INTO PROCEDIMENTO (NOME_PROCEDIMENTO, VALOR_PROCEDIMENTO) VALUES (?,?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, procedimento.getNome());
			ps.setDouble(2, procedimento.getValor());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					throw new NegocioException("Erro ao cadastrar procedimento. ");
				}
			}
		}
		
		
		return "Salvo com sucesso";
		
	}
	
	public List<ProcedimentoEntity> listarProcedimento() throws NegocioException {
		
		String sql = "SELECT ID_PROCEDIMENTO, NOME_PROCEDIMENTO, VALOR_PROCEDIMENTO FROM PROCEDIMENTO";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProcedimentoEntity> procedimentos = new ArrayList<>();
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				ProcedimentoEntity procedimento = new ProcedimentoEntity();
				procedimento.setCodigo(rs.getLong("ID_PROCEDIMENTO"));
				procedimento.setNome(rs.getString("NOME_PROCEDIMENTO"));
				procedimento.setValor(rs.getDouble("VALOR_PROCEDIMENTO"));
				procedimentos.add(procedimento);
			}
			
		} catch (SQLException e) {
			throw new NegocioException("Erro ao listar procedimentos.");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return procedimentos;
	}
	
	public void excluirProcedimento(Long codigoProcedimento) throws NegocioException {
		
		String sql = "DELETE FROM PROCEDIMENTO WHERE ID_PROCEDIMENTO = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoProcedimento);
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new NegocioException("Não foi possível excluir o procedimento.");
			
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
		
	}
	
	public ProcedimentoEntity buscarProcedimentoPorId(Long codigoProcedimento) throws NegocioException {
		
		String sql = "SELECT ID_PROCEDIMENTO, NOME_PROCEDIMENTO, VALOR_PROCEDIMENTO FROM PROCEDIMENTO WHERE ID_PROCEDIMENTO = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoProcedimento);
			
			rs = ps.executeQuery();
			
			ProcedimentoEntity procedimentoEncontrado = null;

			if(rs.next()) {
				procedimentoEncontrado = new ProcedimentoEntity();
				procedimentoEncontrado.setCodigo(rs.getLong("ID_PROCEDIMENTO"));
				procedimentoEncontrado.setNome(rs.getString("NOME_PROCEDIMENTO"));
				procedimentoEncontrado.setValor(rs.getDouble("VALOR_PROCEDIMENTO"));
				
			}
			
			return procedimentoEncontrado;
			
		} catch (SQLException e) {
			throw new NegocioException("Erro ao BUSCAR procedimento.");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public String editarProcedimento(ProcedimentoEntity procedimento) throws NegocioException {
		
		String sql = "UPDATE PROCEDIMENTO SET NOME_PROCEDIMENTO = ?, VALOR_PROCEDIMENTO = ? WHERE ID_PROCEDIMENTO = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, procedimento.getNome());
			ps.setDouble(2, procedimento.getValor());
			ps.setLong(3, procedimento.getCodigo());
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new NegocioException("Ocorreu um erro ao atualizar os dados do Procedimento.");
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return "O procedimento foi alterado com sucesso.";
		
	}
	
	public List<ProcedimentoEntity> buscarProcedimentoFiltrado(ProcedimentoEntity procedimento) throws NegocioException {
		
		String sql = "SELECT ID_PROCEDIMENTO, NOME_PROCEDIMENTO, VALOR_PROCEDIMENTO FROM PROCEDIMENTO ";
		
		boolean adicionaWhere = true;
		
		List<ProcedimentoEntity> resultado = new ArrayList<>();
		
		if(procedimento != null) {
			if (procedimento.getCodigo() != null) {
				adicionaWhere = false;
				sql += "WHERE ";
				sql += "ID_PROCEDIMENTO = ? ";
				
			}
			if (procedimento.getNome() != null && !procedimento.getNome().equals("")) {
				if(adicionaWhere) {
					sql += "WHERE ";
					adicionaWhere = false;
				} else {
					sql += "AND ";
				}
				sql += "NOME_PROCEDIMENTO LIKE ? ";
			}
			if (procedimento.getValor() != null && !procedimento.getValor().equals("")) {
				if(adicionaWhere) {
					sql += "WHERE ";
					adicionaWhere = false;
				} else {
					sql += "OR ";
				}
				sql += "VALOR_PROCEDIMENTO LIKE ? ";
			}
			
		}
		
		System.out.println(sql);
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			
			int indice = 0;
			
			if(procedimento != null) {
				if(procedimento.getCodigo() != null) {
					indice = indice + 1;
					ps.setLong(indice, procedimento.getCodigo());
				}
				if (procedimento.getNome() != null && !procedimento.getNome().equals("")) {
					indice = indice + 1;
					ps.setString(indice, procedimento.getNome() + "%");
				}
				if (procedimento.getValor() != null && !procedimento.getValor().equals("")) {
					indice = indice + 1;
					ps.setString(indice, procedimento.getValor() + "%");
				}
				
			}
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProcedimentoEntity procedimentoResultado = new ProcedimentoEntity();
				procedimentoResultado.setCodigo(rs.getLong("ID_PROCEDIMENTO"));
				procedimentoResultado.setNome(rs.getString("NOME_PROCEDIMENTO"));
				procedimentoResultado.setValor(rs.getDouble("VALOR_PROCEDIMENTO"));
				resultado.add(procedimentoResultado);
				
				
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
