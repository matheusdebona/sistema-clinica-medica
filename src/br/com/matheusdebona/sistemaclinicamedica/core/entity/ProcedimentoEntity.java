package br.com.matheusdebona.sistemaclinicamedica.core.entity;

import java.util.Objects;

public class ProcedimentoEntity {

	private Long codigo;
	private String nome;
	private Double valor;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProcedimentoEntity other = (ProcedimentoEntity) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
	
}
