package servlets;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Tweet;
import beans.Usuario;
import database.TweetBD;
import database.UsuarioBD;

/**
 * Servlet implementation class FazerLogin
 */
public class FazerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FazerLogin() {
        super();
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
		String login = request.getParameter("login");
		String pass = request.getParameter("senha");
		UsuarioBD bancoUsuarios = new UsuarioBD();
		Usuario usuarioLogado = bancoUsuarios.identificarUsuario(login, pass);
		if (usuarioLogado != null){
			TweetBD tBD = new TweetBD();
			List<Tweet> tweets = tBD.getTweets();
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuario", usuarioLogado);
			sessao.setAttribute("tweets", tweets);
			sessao.setAttribute("mensagemBoasVindas", "Bem vindo, " + usuarioLogado.getLogin());
			dispatcher = request.getRequestDispatcher("/inicio.jsp");
			dispatcher.forward(request, response);
		}else{
			HttpSession sessao = request.getSession();
			sessao.setAttribute("mensagemErro", "Usuário não encontrado.");
			dispatcher = request.getRequestDispatcher("/Erro.jsp");
			dispatcher.forward(request, response);
		}
	}

}
