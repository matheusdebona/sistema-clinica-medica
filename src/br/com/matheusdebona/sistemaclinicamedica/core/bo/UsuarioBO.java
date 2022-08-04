package br.com.matheusdebona.sistemaclinicamedica.core.bo;

import java.util.List;

import br.com.matheusdebona.sistemaclinicamedica.core.dao.UsuarioDAO;
import br.com.matheusdebona.sistemaclinicamedica.core.entity.UsuarioEntity;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class UsuarioBO {

	
	public String salvarUsuario(UsuarioEntity usuario) throws NegocioException {
				
		
		if(!usuario.getEmail().contains("@")) {
			System.out.println("Email inválido, favor conferir.");
		} else if (usuario.getNome() != null && usuario.getNome().equals("")) {
			throw new NegocioException("O nome do usuário precisa ser preenchido.");
		} else if (usuario.getLogin() != null && usuario.getLogin().equals("")) {
			throw new NegocioException("O login do usuário precisa ser preenchido.");
		} else if (usuario.getEmail() != null && usuario.getEmail().equals("")) {
			throw new NegocioException("O email do usuário precisa ser preenhido.");
		} else if (usuario.getSenha() != null && usuario.getSenha().equals("")) {
			throw new NegocioException("O senha do usuário precisa ser preenchida.");
		} else {
			UsuarioDAO udao = new UsuarioDAO();
			return udao.salvarUsuario(usuario);	
		}
		
		return "Erro no cadastro";
		

	}
	
	public List<UsuarioEntity> listarUsuario() throws NegocioException {
		return new UsuarioDAO().listarUsuario();
	}
	
	public Boolean autenticacaoUsuario(UsuarioEntity usuario) throws NegocioException {
		if (usuario.getLogin() != null && usuario.getLogin().equals("")) {
			throw new NegocioException("O login do usuário precisa ser preenchido.");
		} else if (usuario.getSenha() != null && usuario.getSenha().equals("")) {
			throw new NegocioException("O senha do usuário precisa ser preenchida.");
		} else {
		UsuarioDAO udao = new UsuarioDAO();
		return udao.autenticacaoUsuario(usuario);
		} 
	}
}
