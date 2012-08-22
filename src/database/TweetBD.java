package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import beans.Tweet;
import beans.Usuario;

public class TweetBD {
	public boolean inserirTweet(Tweet novoTweet) {
		Connection conexao = BDFactory.getConnection();
		PreparedStatement st;
		try {
			st = conexao
					.prepareStatement("INSERT INTO `Tweetlet`.`tweets`(`corpo`,`id_usuario`, data_envio) VALUES(?,?,?);");
			st.setString(1, novoTweet.getMensagem());
			st.setInt(2, novoTweet.getDono().getId());
			java.util.Date dataUtil = new java.util.Date();
			java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			st.setDate(3,dataSql);
			st.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Tweet> getTweets() {
		List<Tweet> tweets = new ArrayList<Tweet>();
		Connection conexao = BDFactory.getConnection();
		PreparedStatement st;
		try {
			st = conexao
					.prepareStatement("select t.corpo, t.id_usuario, u.login, t.data_envio from tweets as t, users as u where t.id_usuario = u.id order  by t.data_envio desc;");
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				tweets.add(resultSetToTweet(rs));
			}
			return tweets;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Arrays.asList(new Tweet("Nenhum Tweet", new Usuario()));
	}
	
	private Tweet resultSetToTweet(ResultSet rs) throws SQLException{
		Usuario user = new Usuario();
		user.setLogin(rs.getString("login"));
		String mensagem = rs.getString("corpo");
		return new Tweet(mensagem, user);
	}

}
