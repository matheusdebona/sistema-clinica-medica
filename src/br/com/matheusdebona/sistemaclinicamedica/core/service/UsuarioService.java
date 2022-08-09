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
	
	public void excluirUsuario(Long codigoUsuario) throws NegocioException {
		new UsuarioBO().excluirUsuario(codigoUsuario);
	}
	
	public UsuarioEntity buscarUsuarioPorId(Long codigoUsuario) throws NegocioException {
		return new UsuarioBO().buscarUsuarioPorId(codigoUsuario);
	}

	public String editarUsuario(UsuarioEntity usuario) throws NegocioException {
		return new UsuarioBO().editarUsuario(usuario);
	}
	
	public List<UsuarioEntity> buscarUsuarioFiltrado(UsuarioEntity usuario) throws NegocioException {
		return new UsuarioBO().buscarUsuarioFiltrado(usuario);
	}
	
}
