package br.com.matheusdebona.sistemaclinicamedica.core.bo;

import java.util.List;

import br.com.matheusdebona.sistemaclinicamedica.core.dao.MedicoDAO;
import br.com.matheusdebona.sistemaclinicamedica.core.entity.MedicoEntity;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class MedicoBO {
	
public String salvarMedico(MedicoEntity medico) throws NegocioException {
	
	if(medico.getNome() != null && medico.getNome().equals("")) {
			throw new NegocioException("O nome do médico precisa ser preenchido.");
		} else if (medico.getCrm() != null && medico.getCrm().equals("")) {
			throw new NegocioException("O CRM do médico precisa ser preenchido.");
		} else if (medico.getEmail() != null && medico.getEmail().equals("")) {
			throw new NegocioException("O email do médico precisa ser preenhido.");
		} else if (medico.getEspecialidade() != null && medico.getEspecialidade().equals("")) {
			throw new NegocioException("A especialidade do médico precisa ser preenchida.");
		} else {
			MedicoDAO mdao = new MedicoDAO();
			return mdao.salvarMedico(medico);	
		}
	}
	
	public List<MedicoEntity> listarMedico() throws NegocioException {
		return new MedicoDAO().listarMedico();
	}
	
	public void excluirMedico(Long codigoMedico) throws NegocioException {
		new MedicoDAO().excluirMedico(codigoMedico);
	}

	public MedicoEntity buscarMedicoPorId(Long codigoMedico) throws NegocioException {
		return new MedicoDAO().buscarMedicoPorId(codigoMedico);
	}
	
	public String editarMedico(MedicoEntity medico) throws NegocioException {
		
		if(medico.getNome() != null && medico.getNome().equals("")) {
			throw new NegocioException("O nome do médico precisa ser preenchido.");
			} else if (medico.getCrm() != null && medico.getCrm().equals("")) {
				throw new NegocioException("O CRM do médico precisa ser preenchido.");
			} else if (medico.getEmail() != null && medico.getEmail().equals("")) {
				throw new NegocioException("O email do médico precisa ser preenhido.");
			} else if (medico.getEspecialidade() != null && medico.getEspecialidade().equals("")) {
				throw new NegocioException("A especialidade do médico precisa ser preenchida.");
			} else {
				MedicoDAO mdao = new MedicoDAO();
				return mdao.editarMedico(medico);	
		}
		
	}
	
	public List<MedicoEntity> buscarMedicoFiltrado(MedicoEntity medico) throws NegocioException {
		return new MedicoDAO().buscarMedicoFiltrado(medico);
	}
}
