package br.com.matheusdebona.sistemaclinicamedica.core.service;

import java.util.List;

import br.com.matheusdebona.sistemaclinicamedica.core.bo.ProcedimentoBO;
import br.com.matheusdebona.sistemaclinicamedica.core.entity.ProcedimentoEntity;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class ProcedimentoService {
	
	public String salvarProcedimento(ProcedimentoEntity procedimento) throws NegocioException {
		
		ProcedimentoBO pbo = new ProcedimentoBO();
		return pbo.salvarProcedimento(procedimento);
	}
	
	public List<ProcedimentoEntity> listarProcedimento() throws NegocioException {
		return new ProcedimentoBO().listarProcedimento();
	}
	
	public void excluirProcedimento(Long codigoProcedimento) throws NegocioException {
		new ProcedimentoBO().excluirProcedimento(codigoProcedimento);
	}
	
	public ProcedimentoEntity buscarProcedimentoPorId(Long codigoProcedimento) throws NegocioException {
		return new ProcedimentoBO().buscarProcedimentoPorId(codigoProcedimento);
	}

	public String editarProcedimento(ProcedimentoEntity procedimento) throws NegocioException {
		return new ProcedimentoBO().editarProcedimento(procedimento);
	}
	
	public List<ProcedimentoEntity> buscarProcedimentoFiltrado(ProcedimentoEntity procedimento) throws NegocioException {
		return new ProcedimentoBO().buscarProcedimentoFiltrado(procedimento);
	}
	

}
