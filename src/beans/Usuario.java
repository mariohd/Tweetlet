package beans;

public class Usuario {
	private int id;
	private String login;
	private String pass;
	
	public Usuario(int id, String login, String pass){
		this.id = id;
		this.login = login;
		this.pass = pass;
	}
	
	public Usuario(){
		login = "Tweetlet Application";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	

}
