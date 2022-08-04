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

}


