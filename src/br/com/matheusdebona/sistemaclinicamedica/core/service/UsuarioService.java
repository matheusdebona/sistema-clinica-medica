package br.com.matheusdebona.sistemaclinicamedica.core.service;

import java.util.List;

import br.com.matheusdebona.sistemaclinicamedica.core.bo.UsuarioBO;
import br.com.matheusdebona.sistemaclinicamedica.core.entity.UsuarioEntity;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class UsuarioService {

	public String salvarUsuario(UsuarioEntity usuario) throws NegocioException {
		
		UsuarioBO bo = new UsuarioBO();
		return bo.salvarUsuario(usuario);
	}
	
	public List<UsuarioEntity> listarUsuario() throws NegocioException {
		return new UsuarioBO().listarUsuario();
	}
	
	
	public Boolean autenticacaoUsuario(UsuarioEntity usuario) throws NegocioException {
		UsuarioBO usbo = new UsuarioBO();
		return usbo.autenticacaoUsuario(usuario);
		
		
	}
	
}
