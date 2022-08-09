package br.com.matheusdebona.sistemaclinicamedica.core.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	
	private static final String urlDb = "jdbc:mysql://localhost:3306/sistema_clinica_medica_db";
	private static final String userDb = "root";
	private static final String passDb = "andrelio";
	
	public static Connection conn;
	
	public static Connection getConexao() {
		
		try {
			if(conn == null) {
				conn = DriverManager.getConnection(urlDb, userDb, passDb);
				return conn;
			} else {
				return conn;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}

	
	}

}
