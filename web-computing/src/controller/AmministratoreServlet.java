package controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Amministratore;
import persistence.dao.DAOFactory;
/**
 * Servlet implementation class AmministratoreServlet
 */
@WebServlet("/AmministratoreServlet")
public class AmministratoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmministratoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequestt request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		switch (action) {
		case "controllaId":
			Amministratore controllaid = DAOFactory.getAmministratoreDAO().findByPrimaryKey(request.getParameter("id"));
			if (controllaid != null) {
				out.write("esistente");
				out.flush();
			} else {
				out.write("disponibile");
				out.flush();
			}
			break;
		/*case "presenze":
			Amministratore amministratorePresenze = DAOFactory.getAmministratoreDAO().findByPrimaryKey(request.getParameter("id"));
			 corsoPresenze = DAOFactory.getAmministratoreDAO().findByPrimaryKey(request.getParameter("idcorso"));
			int totali = DAOFactory.getLezioneDAO().numeroLezioniPerCorso(corsoPresenze);
			int presente = DAOFactory.getLezioneDAO().numeroLezioniPerCorsoAmministratore(corsoPresenze, amministratorePresenze);
			int assente = totali - presente;
			if (totali != 0)
				out.write(presente * 100 / totali + "," + assente * 100 / totali);
			else
				out.write(0);
			out.flush();
			break;
		} */
	}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequestt requestt, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
