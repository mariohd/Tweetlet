package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Tweet;
import beans.Usuario;
import database.TweetBD;

/**
 * Servlet implementation class submeterRespostaTweetlet
 */
public class submeterRespostaTweetlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submeterRespostaTweetlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		String mensagem = request.getParameter("respostaTweetlet");
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		TweetBD tBD = new TweetBD();
		Tweet tweetRespondido = tBD.getTweet(Integer.parseInt(request.getParameter("tweetRespondidoID")));
		List<Tweet> respondidos = (List) sessao.getAttribute("tweetRespondidos");	
		if (respondidos == null){
			respondidos = new ArrayList<Tweet>();
			sessao.setAttribute("tweetRespondidos",respondidos);
		}
		if (usuario != null){
			Tweet t = new Tweet(mensagem, usuario, new Date());
			String respostaEnvio = "";
			t.setEmResposta(true);
			t.setTweetIdRespondido(tweetRespondido.getId());
			if (tBD.inserirTweet(t)){
				respostaEnvio = "Tweetlet enviado.";
				respondidos.add(tweetRespondido);
			}
			else{
				respostaEnvio = "Ocorreu um problema, tente novamente.";
			}
			List<Tweet> tweets = tBD.getTweets();
			sessao.setAttribute("tweets", tweets);
			sessao.setAttribute("resposta", true);
			sessao.setAttribute("tweetRespondidos",respondidos);
			
			sessao.setAttribute("respostaEnvio", respostaEnvio);
			dispatcher = request.getRequestDispatcher("/inicio.jsp");
			dispatcher.forward(request, response);
		}else{
			sessao.setAttribute("mensagemErro", "Usuário não encontrado.");
			dispatcher = request.getRequestDispatcher("/Erro.jsp");
			dispatcher.forward(request, response);
		}
	}

}
