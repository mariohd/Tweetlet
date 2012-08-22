package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Usuario;

public class UsuarioBD {
	public Usuario identificarUsuario(String login, String pass) {
		Connection conexao = BDFactory.getConnection();
		Statement st;
		try {
			st = conexao.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT id, login, pass FROM Tweetlet.users where login='"
							+ login + "' and pass='" + pass + "';");
			if (rs.next()) {
				return getUsuario(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Usuario getUsuario(ResultSet rs) throws SQLException {
		Integer id = rs.getInt("id");
		String login = rs.getString("login");
		String pass = rs.getString("pass");
		if (id != null && !login.equals("") && !pass.equals(""))
			return new Usuario(id, login, pass);
		return null;
	}
}