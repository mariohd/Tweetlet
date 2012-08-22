package beans;

public class Tweet {
	
	String mensagem;
	Usuario dono;
	
	public Tweet(String mensagem, Usuario dono) {
		super();
		this.mensagem = mensagem;
		this.dono = dono;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Usuario getDono() {
		return dono;
	}
	public void setDono(Usuario dono) {
		this.dono = dono;
	}
	
	
}
