package br.com.matheusdebona.sistemaclinicamedica.core.bo;

import java.util.List;

import br.com.matheusdebona.sistemaclinicamedica.core.dao.ClienteDAO;
import br.com.matheusdebona.sistemaclinicamedica.core.entity.ClienteEntity;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class ClienteBO {
	
	public String salvarCliente(ClienteEntity cliente) throws NegocioException {
		
		if(cliente.getNome() != null && cliente.getNome().equals("")) {
			throw new NegocioException("O nome do cliente precisa ser preenchido.");
		} else if (cliente.getCpf() != null && cliente.getCpf().equals("")) {
			throw new NegocioException("O CPF do cliente precisa ser preenchido.");
		} else if (cliente.getEndereco() != null && cliente.getEndereco().equals("")) {
			throw new NegocioException("O endereço do cliente precisa ser preenhido.");
		} else if (cliente.getTelefone() != null && cliente.getTelefone().equals("")) {
			throw new NegocioException("O telefone do cliente precisa ser preenchida.");
		} else {
			ClienteDAO cdao = new ClienteDAO();
			return cdao.salvarCliente(cliente);	
		}
		

	}
	
	public List<ClienteEntity> listarCliente() throws NegocioException {
		return new ClienteDAO().listarCliente();
	}
	
	public void excluirCliente(Long codigoCliente) throws NegocioException {
		new ClienteDAO().excluirCliente(codigoCliente);
	}

	public ClienteEntity buscarClientePorId(Long codigoCliente) throws NegocioException {
		return new ClienteDAO().buscarClientePorId(codigoCliente);
	}
	
	public String editarCliente(ClienteEntity cliente) throws NegocioException {
		
		if(cliente.getNome() != null && cliente.getNome().equals("")) {
			throw new NegocioException("O nome do cliente precisa ser preenchido.");
		} else if (cliente.getCpf() != null && cliente.getCpf().equals("")) {
			throw new NegocioException("O CPF do cliente precisa ser preenchido.");
		} else if (cliente.getEndereco() != null && cliente.getEndereco().equals("")) {
			throw new NegocioException("O endereço do cliente precisa ser preenhido.");
		} else if (cliente.getTelefone() != null && cliente.getTelefone().equals("")) {
			throw new NegocioException("O telefone do cliente precisa ser preenchida.");
		} else {
			ClienteDAO cdao = new ClienteDAO();
			return cdao.editarCliente(cliente);	
		}
		
	}
}
