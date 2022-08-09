package br.com.matheusdebona.sistemaclinicamedica.core.dao.connection;

import java.sql.SQLException;
import java.sql.Statement;

public class CriaDB {
	
	
	public void criaSchema() {
		
		String sql = "CREATE SCHEMA IF NOT EXISTS sistema_clinica_medica_db";
			
		
		try {
			Statement stmt = ConexaoMySQL.getConexao().createStatement();
			stmt.execute(sql);
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
	public void criaTabelaUsuario() {
		
		String sql = "CREATE TABLE IF NOT EXISTS usuario ("
				+ "ID_USUARIO INT AUTO_INCREMENT PRIMARY KEY,"
				+ "NOME_USU VARCHAR(100) NOT NULL,"
				+ "LOGIN_USU VARCHAR(50) NOT NULL,"
				+ "EMAIL_USU VARCHAR(100) NOT NULL,"
				+ "SENHA_USU VARCHAR(50) NOT NULL"
				+ ")";
		
		try {
			Statement stmt = ConexaoMySQL.getConexao().createStatement();
			stmt.execute(sql);
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}
	
	public void criaTabelaCliente() {
		
		String sql = "CREATE TABLE IF NOT EXISTS cliente ("
				+ "ID_CLIENTE INT AUTO_INCREMENT PRIMARY KEY,"
				+ "NOME_CLIENTE VARCHAR(100) NOT NULL,"
				+ "CPF_CLIENTE VARCHAR(50) NOT NULL,"
				+ "ENDERECO_CLIENTE VARCHAR(100) NOT NULL,"
				+ "TELEFONE_CLIENTE VARCHAR(50) NOT NULL"
				+ ")";
		
		try {
			Statement stmt = ConexaoMySQL.getConexao().createStatement();
			stmt.execute(sql);
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
	public void criaTabelaMedico() {
		
		String sql = "CREATE TABLE IF NOT EXISTS medico ("
				+ "ID_MEDICO INT AUTO_INCREMENT PRIMARY KEY,"
				+ "NOME_MEDICO VARCHAR(100) NOT NULL,"
				+ "CRM_MEDICO VARCHAR(50) NOT NULL,"
				+ "EMAIL_MEDICO VARCHAR(100) NOT NULL,"
				+ "ESPECIALIDADE_MEDICO VARCHAR(100) NOT NULL"
				+ ")";
		
		try {
			Statement stmt = ConexaoMySQL.getConexao().createStatement();
			stmt.execute(sql);
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
	public void criaTabelaProcedimento() {
		
		String sql = "CREATE TABLE IF NOT EXISTS procedimento ("
				+ "ID_PROCEDIMENTO INT AUTO_INCREMENT PRIMARY KEY,"
				+ "NOME_PROCEDIMENTO VARCHAR(100) NOT NULL,"
				+ "VALOR_PROCEDIMENTO DECIMAL(10,2) NOT NULL"
				+ ")";
		
		try {
			Statement stmt = ConexaoMySQL.getConexao().createStatement();
			stmt.execute(sql);
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	

}
