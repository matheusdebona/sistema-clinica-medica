package br.com.matheusdebona.sistemaclinicamedica.core.bo;

import java.util.List;

import br.com.matheusdebona.sistemaclinicamedica.core.dao.MedicoDAO;
import br.com.matheusdebona.sistemaclinicamedica.core.entity.MedicoEntity;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class MedicoBO {
	
public String salvarMedico(MedicoEntity medico) throws NegocioException {
		
		MedicoDAO mdao = new MedicoDAO();
		return mdao.salvarMedico(medico);
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
		return new MedicoDAO().editarMedico(medico);
	}
	
	public List<MedicoEntity> buscarMedicoFiltrado(MedicoEntity medico) throws NegocioException {
		return new MedicoDAO().buscarMedicoFiltrado(medico);
	}
}
