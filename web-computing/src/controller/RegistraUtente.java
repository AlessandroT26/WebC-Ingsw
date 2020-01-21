package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;
import model.Utente;
import persistence.dao.DAOFactory;


@WebServlet("/RegistraUtente")
public class RegistraUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1");
		String nomeDaControllare = request.getParameter("nome");
		System.out.println("2");
		Model utenteDaControllare = DAOFactory.getUtenteDAO().findByPrimaryKey(nomeDaControllare);
		System.out.println("3");
		if(utenteDaControllare != null) {
			System.out.println("utenteDaControllare non nullo");
			response.getWriter().print("errore");
		}
		else {
			System.out.println("nullo");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doGet(request, response);

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(nome + " " + email + " " + password);
		Utente utente = new Utente(nome, email,password);
		DAOFactory.getUtenteDAO().save(utente);
		response.sendRedirect(request.getContextPath() + "/login.jsp");

	}
}
