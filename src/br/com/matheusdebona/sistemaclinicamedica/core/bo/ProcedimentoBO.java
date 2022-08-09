package br.com.matheusdebona.sistemaclinicamedica.core.bo;

import java.util.List;

import br.com.matheusdebona.sistemaclinicamedica.core.dao.ProcedimentoDAO;
import br.com.matheusdebona.sistemaclinicamedica.core.entity.ProcedimentoEntity;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class ProcedimentoBO {
	
	public String salvarProcedimento(ProcedimentoEntity procedimento) throws NegocioException {
	
		if(procedimento.getNome() != null && procedimento.getNome().equals("")) {
			throw new NegocioException("O nome do procedimento precisa ser preenchido.");
		} else if (procedimento.getValor() != null && procedimento.getValor().equals("")) {
			throw new NegocioException("O valor do procedimento precisa ser preenchido.");
		} else {
			ProcedimentoDAO pdao = new ProcedimentoDAO();
			return pdao.salvarProcedimento(procedimento);
		}

	}
	
	public List<ProcedimentoEntity> listarProcedimento() throws NegocioException {
		return new ProcedimentoDAO().listarProcedimento();
	}
	
	public void excluirProcedimento(Long codigoProcedimento) throws NegocioException {
		new ProcedimentoDAO().excluirProcedimento(codigoProcedimento);
	}
	
	public ProcedimentoEntity buscarProcedimentoPorId(Long codigoProcedimento) throws NegocioException {
		return new ProcedimentoDAO().buscarProcedimentoPorId(codigoProcedimento);
	}

	public String editarProcedimento(ProcedimentoEntity procedimento) throws NegocioException {
		
		if(procedimento.getNome() != null && procedimento.getNome().equals("")) {
			throw new NegocioException("O nome do procedimento precisa ser preenchido.");
		} else if (procedimento.getValor() != null && procedimento.getValor().equals("")) {
			throw new NegocioException("O valor do procedimento precisa ser preenchido.");
		} else {
			ProcedimentoDAO pdao = new ProcedimentoDAO();
			return pdao.editarProcedimento(procedimento);
		}
		
	}
	
	public List<ProcedimentoEntity> buscarProcedimentoFiltrado(ProcedimentoEntity procedimento) throws NegocioException {
		return new ProcedimentoDAO().buscarProcedimentoFiltrado(procedimento);
	}

}
