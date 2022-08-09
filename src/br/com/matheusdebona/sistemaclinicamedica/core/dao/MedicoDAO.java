package br.com.matheusdebona.sistemaclinicamedica.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.matheusdebona.sistemaclinicamedica.core.dao.connection.ConexaoMySQL;
import br.com.matheusdebona.sistemaclinicamedica.core.entity.MedicoEntity;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class MedicoDAO {
	
public String salvarMedico(MedicoEntity medico) throws NegocioException {
	
	String sql = "INSERT INTO MEDICO (NOME_MEDICO, CRM_MEDICO, EMAIL_MEDICO, ESPECIALIDADE_MEDICO) VALUES (?,?,?,?)";
	
	PreparedStatement ps = null;
	
	try {
		ps = ConexaoMySQL.getConexao().prepareStatement(sql);
		ps.setString(1, medico.getNome());
		ps.setString(2, medico.getCrm());
		ps.setString(3, medico.getEmail());
		ps.setString(4, medico.getEspecialidade());
		
		ps.execute();
		ps.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	} finally {
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				throw new NegocioException("Erro ao cadastrar médico.");
			}
		}
	}
	
	return "Salvo com sucesso";
	
}

	
	public List<MedicoEntity> listarMedico() throws NegocioException {
		
		String sql = "SELECT ID_MEDICO, NOME_MEDICO, CRM_MEDICO, EMAIL_MEDICO, ESPECIALIDADE_MEDICO FROM MEDICO";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MedicoEntity> medicos = new ArrayList<>();
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				MedicoEntity medico = new MedicoEntity();
				medico.setCodigo(rs.getLong("ID_MEDICO"));
				medico.setNome(rs.getString("NOME_MEDICO"));
				medico.setCrm(rs.getString("CRM_MEDICO"));
				medico.setEmail(rs.getString("EMAIL_MEDICO"));
				medico.setEspecialidade(rs.getString("ESPECIALIDADE_MEDICO"));
				medicos.add(medico);
			}
			
		} catch (SQLException e) {
			throw new NegocioException("Erro ao listar médicos.");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return medicos;
		
	}
	
	public void excluirMedico(Long codigoMedico) throws NegocioException {

		String sql = "DELETE FROM MEDICO WHERE ID_MEDICO = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoMedico);
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new NegocioException("Não foi possível excluir o médico.");
			
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
	
	}
	
	
	
	public MedicoEntity buscarMedicoPorId(Long codigoMedico) throws NegocioException {
		
		String sql = "SELECT ID_MEDICO, NOME_MEDICO, CRM_MEDICO, EMAIL_MEDICO, ESPECIALIDADE_MEDICO FROM MEDICO WHERE ID_MEDICO = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoMedico);
			
			rs = ps.executeQuery();
			
			MedicoEntity medicoEncontrado = null;

			if(rs.next()) {
				medicoEncontrado = new MedicoEntity();
				medicoEncontrado.setCodigo(rs.getLong("ID_MEDICO"));
				medicoEncontrado.setNome(rs.getString("NOME_MEDICO"));
				medicoEncontrado.setCrm(rs.getString("CRM_MEDICO"));
				medicoEncontrado.setEmail(rs.getString("EMAIL_MEDICO"));
				medicoEncontrado.setEspecialidade(rs.getString("ESPECIALIDADE_MEDICO"));
				
			}
			
			return medicoEncontrado;
			
		} catch (SQLException e) {
			throw new NegocioException("Erro ao BUSCAR MÉDICO.");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public String editarMedico(MedicoEntity medico) throws NegocioException {
		
		String sql = "UPDATE MEDICO SET NOME_MEDICO = ?, CRM_MEDICO = ?, EMAIL_MEDICO = ?, ESPECIALIDADE_MEDICO = ? WHERE ID_MEDICO = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, medico.getNome());
			ps.setString(2, medico.getCrm());
			ps.setString(3, medico.getEmail());
			ps.setString(4, medico.getEspecialidade());
			ps.setLong(5, medico.getCodigo());
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new NegocioException("Ocorreu um erro ao atualizar os dados do MÉDICO.");
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return "O MÉDICO foi alterado com sucesso.";
		
	}
	
	public List<MedicoEntity> buscarMedicoFiltrado(MedicoEntity medico) throws NegocioException {
		
		String sql = "SELECT ID_MEDICO, NOME_MEDICO, CRM_MEDICO, EMAIL_MEDICO, ESPECIALIDADE_MEDICO FROM MEDICO ";
		
		boolean adicionaWhere = true;
		
		List<MedicoEntity> resultado = new ArrayList<>();
		
		if(medico != null) {
			if (medico.getCodigo() != null) {
				adicionaWhere = false;
				sql += "WHERE ";
				sql += "ID_MEDICO = ? ";
				
			}
			if (medico.getNome() != null && !medico.getNome().equals("")) {
				if(adicionaWhere) {
					sql += "WHERE ";
					adicionaWhere = false;
				} else {
					sql += "AND ";
				}
				sql += "NOME_MEDICO LIKE ? ";
			}
			if (medico.getCrm() != null && !medico.getCrm().equals("")) {
				if(adicionaWhere) {
					sql += "WHERE ";
					adicionaWhere = false;
				} else {
					sql += "OR ";
				}
				sql += "CRM_MEDICO LIKE ? ";
			}
			if (medico.getEmail() != null && !medico.getEmail().equals("")) {
				if(adicionaWhere) {
					sql += "WHERE ";
					adicionaWhere = false;
				} else {
					sql += "OR ";
				}
				sql += "EMAIL_MEDICO LIKE ? ";
			}
			if (medico.getEspecialidade() != null && !medico.getEspecialidade().equals("")) {
				if(adicionaWhere) {
					sql += "WHERE ";
					adicionaWhere = false;
				} else {
					sql += "OR ";
				}
				sql += "ESPECIALIDADE_MEDICO LIKE ? ";
			}
			
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			
			int indice = 0;
			
			if(medico != null) {
				if(medico.getCodigo() != null) {
					indice = indice + 1;
					ps.setLong(indice, medico.getCodigo());
				}
				if (medico.getNome() != null && !medico.getNome().equals("")) {
					indice = indice + 1;
					ps.setString(indice, medico.getNome() + "%");
				}
				if (medico.getCrm() != null && !medico.getCrm().equals("")) {
					indice = indice + 1;
					ps.setString(indice, medico.getCrm() + "%");
				}
				if (medico.getEmail() != null && !medico.getEmail().equals("")) {
					indice = indice + 1;
					ps.setString(indice, medico.getEmail() + "%");
				}
				if (medico.getEspecialidade() != null && !medico.getEspecialidade().equals("")) {
					indice = indice + 1;
					ps.setString(indice, medico.getEspecialidade() + "%");
				}
				
			}
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				MedicoEntity medicoResultado = new MedicoEntity();
				
				medicoResultado.setCodigo(rs.getLong("ID_MEDICO"));
				medicoResultado.setNome(rs.getString("NOME_MEDICO"));
				medicoResultado.setCrm(rs.getString("CRM_MEDICO"));
				medicoResultado.setEmail(rs.getString("EMAIL_MEDICO"));
				medicoResultado.setEspecialidade(rs.getString("ESPECIALIDADE_MEDICO"));
				resultado.add(medicoResultado);
				
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


