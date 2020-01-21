package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Amministratore;
import model.Model;
import model.User;
import model.UserType;
import persistence.dao.DAOFactory;
import utility.BCrypt;
public class Login extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession session = req.getSession();
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		// Provo login Utente
		Model utente = null;
		utente = DAOFactory.getUtenteDAO().findByPrimaryKey(id);
		if (utente == null || !BCrypt.checkpw(password, utente.getPassword()))
		{
			// utente non trovato, provo login con amministratore
			Model amministratore = null;
			amministratore = DAOFactory.getAmministratoreDAO().findByPrimaryKey(id);
			if (amministratore == null || !BCrypt.checkpw(password, amministratore.getPassword()))
			{
				resp.getWriter().print("error");
			}
			else
			{ // Login come Amministratore
				User currentUser = new User(amministratore.getId(), amministratore.getNome(), amministratore.getEmail(), UserType.AMMINISTRATORE);
				session.removeAttribute("currentUser");
				session.setAttribute("currentUser", currentUser);
			}
		}
		else
		{ // Login come Utente
			User currentUser = new User(utente.getId(), utente.getNome(), utente.getEmail(), UserType.UTENTE);
			session.removeAttribute("currentUser");
			session.setAttribute("currentUser", currentUser);
		}
	}
}