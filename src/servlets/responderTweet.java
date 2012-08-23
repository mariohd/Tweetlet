package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.TweetBD;

import beans.Tweet;
import beans.Usuario;

/**
 * Servlet implementation class responderTweet
 */
public class responderTweet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public responderTweet() {
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
		TweetBD tBD = new TweetBD();
		Tweet aResponder = tBD.getTweet(idTweet);
		sessao.setAttribute("TweetAResponder", aResponder);
		dispatcher = request.getRequestDispatcher("/TweetResposta.jsp");
		dispatcher.forward(request, response);
	}

}
