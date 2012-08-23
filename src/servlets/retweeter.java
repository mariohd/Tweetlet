package servlets;

import java.io.IOException;
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
 * Servlet implementation class retweeter
 */
public class retweeter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public retweeter() {
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
		int idTweet = Integer.parseInt(request.getParameter("tweetId"));
		RequestDispatcher dispatcher = null;
		HttpSession sessao = request.getSession();
		Usuario userLogado = (Usuario) sessao.getAttribute("usuario");
		TweetBD tBD = new TweetBD();
		tBD.retweeter(idTweet, userLogado);
		List<Tweet> tweets = tBD.getTweets();
		sessao.setAttribute("tweets", tweets);
		String respostaEnvio = "Retweetletled!";
		sessao.setAttribute("respostaEnvio", respostaEnvio);
		dispatcher = request.getRequestDispatcher("/inicio.jsp");
		dispatcher.forward(request, response);
	}

}
