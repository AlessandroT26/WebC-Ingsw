package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dao.DAOFactory;

@WebServlet("/Login")
public class Login extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//doGet(req, resp);
		String nome = req.getParameter("nome");
		String password = req.getParameter("password");
		System.out.println(nome + " " + password + " quack");
		
//		Utente utente = DAOFactory.getUtenteDAO().findByPrimaryKey(nome);
//		if (utente != null) {
		if(DAOFactory.getUtenteDAO().loginAccess(nome, password)) {
//			resp.sendRedirect(".");
			RequestDispatcher rd = req.getRequestDispatcher("/pag1.jsp");
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("/loginError.html");
			rd.forward(req, resp);
		}
		
	}
}









