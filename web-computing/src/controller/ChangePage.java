package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet("/ChangePage")
public class ChangePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ChangePage() {
        super();        
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome= req.getParameter("nome");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String action = req.getParameter("action");
		//HttpSession session = req.getSession();
		//User currentUser = (User) session.getAttribute("nome");
		
		//se non sei loggato ti riporta al login
		if(nome==null) {
			resp.sendRedirect(req.getContextPath() + "/login.jsp");
		}
		
		else {
			resp.sendRedirect(req.getContextPath() + "/pag1.jsp");
		}
		
		//Se è un utente fai questo
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//se elimino il doGet non passa all'altra pagina.. DUNQUE....
		doGet(req, resp);
	}

}
