package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Articolo;
import model.Model;
import persistence.dao.DAOFactory;


@WebServlet("/CreaArticolo")
public class CreaArticolo extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1");
		String nomeDaControllare = request.getParameter("titolo");
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
	//	doGet(request, response);
		String nome = request.getParameter("titolo");
		String email = request.getParameter("contenuto");
		String password = request.getParameter("immagine");
		System.out.println("PORCODIO");
		System.out.println("PPPPPPPPPPPPPPP"+nome + " " + email + " " + password);
		Articolo utente = new Articolo(nome, email,password);
		DAOFactory.makeArticoloDAO().save(utente);
	}
}
