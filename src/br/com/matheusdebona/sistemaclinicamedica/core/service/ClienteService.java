package br.com.matheusdebona.sistemaclinicamedica.core.service;

import java.util.List;

import br.com.matheusdebona.sistemaclinicamedica.core.bo.ClienteBO;
import br.com.matheusdebona.sistemaclinicamedica.core.entity.ClienteEntity;
import br.com.matheusdebona.sistemaclinicamedica.util.NegocioException;

public class ClienteService {
	
	public String salvarCliente(ClienteEntity cliente) throws NegocioException {
		
		ClienteBO cbo = new ClienteBO();
		return cbo.salvarCliente(cliente);
	}
	
	public List<ClienteEntity> listarCliente() throws NegocioException {
		return new ClienteBO().listarCliente();
	}
	
	public void excluirCliente(Long codigoCliente) throws NegocioException {
		new ClienteBO().excluirCliente(codigoCliente);
	}
	
	public ClienteEntity buscarClientePorId(Long codigoCliente) throws NegocioException {
		return new ClienteBO().buscarClientePorId(codigoCliente);
	}

	public String editarCliente(ClienteEntity cliente) throws NegocioException {
		return new ClienteBO().editarCliente(cliente);
	}
	
	public List<ClienteEntity> buscarClienteFiltrado(ClienteEntity cliente) throws NegocioException {
		return new ClienteBO().buscarClienteFiltrado(cliente);
	}
	
}
