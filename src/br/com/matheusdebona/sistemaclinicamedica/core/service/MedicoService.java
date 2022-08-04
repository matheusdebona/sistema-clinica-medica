package br.com.matheusdebona.sistemaclinicamedica.core.service;

import java.util.List;

import br.com.matheusdebona.sistemaclinicamedica.core.bo.MedicoBO;
import br.com.matheusdebona.sistemaclinicamedica.core.entity.MedicoEntity;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class MedicoService {
	
public String salvarMedico(MedicoEntity medico) throws NegocioException {
		
		MedicoBO mbo = new MedicoBO();
		return mbo.salvarMedico(medico);
	}
	
	public List<MedicoEntity> listarMedico() throws NegocioException {
		return new MedicoBO().listarMedico();
	}
	
	public void excluirMedico(Long codigoMedico) throws NegocioException {
		new MedicoBO().excluirMedico(codigoMedico);
	}

}
