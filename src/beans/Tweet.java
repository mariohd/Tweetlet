package beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tweet {
	
	private int id;
	private String mensagem;
	private Usuario dono;
	private Date data;
	private boolean emResposta;
	private int tweetIdRespondido;
	
	public Tweet(String mensagem, Usuario dono, Date data) {
		super();
		this.mensagem = mensagem;
		this.dono = dono;
		this.setData(data);
		this.setEmResposta(false);
		setTweetIdRespondido(0);
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
	public String getData() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return sdf.format(data);
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isEmResposta() {
		return emResposta;
	}
	public void setEmResposta(boolean emResposta) {
		this.emResposta = emResposta;
	}
	public int getTweetIdRespondido() {
		return tweetIdRespondido;
	}
	public void setTweetIdRespondido(int tweetIdRespondido) {
		this.tweetIdRespondido = tweetIdRespondido;
	}
	
	
}
