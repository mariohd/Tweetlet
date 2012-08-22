package database;

import java.sql.Connection;

public class BDFactory {
	
	public static Connection getConnection(){
		return ConexaoBD.getConexao();
	}

}
