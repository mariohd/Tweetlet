package servlets;

import java.io.IOException;
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
 * Servlet implementation class submeterNovoTweetlet
 */
public class submeterNovoTweetlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submeterNovoTweetlet() {
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
		String mensagem = request.getParameter("novoTweetlet");
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		if (usuario != null){
			TweetBD tBD = new TweetBD();
			String respostaEnvio = "";
			if (tBD.inserirTweet(new Tweet(mensagem, usuario, new Date()))){
				respostaEnvio = "Tweetlet enviado.";
			}
			else{
				respostaEnvio = "Ocorreu um problema, tente novamente.";
			}
			List<Tweet> tweets = tBD.getTweets();
			sessao.setAttribute("tweets", tweets);
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
