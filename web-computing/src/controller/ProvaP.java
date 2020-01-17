package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProvaP
 */
@WebServlet("/ProvaP")
public class ProvaP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvaP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome= request.getParameter("cognome");
		
//		PrintWriter out = response.getWriter();
//		
//		out.println("<!DOCTYPE HTML>");
//		out.println("<html>");
//		out.println("<head><title>CIAO!</title></head>");
//		out.println("<body>");
//		out.println("<h1>CIAO" + nome + " " + cognome + "</h1>");
//		out.println("</body>");
//		out.println("</html>");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(nome.equalsIgnoreCase("ale1") && cognome.equalsIgnoreCase("ale2"))
			response.sendRedirect(request.getContextPath() + "/pag1.jsp");
		else {
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML>");
			out.println("<html>");
			out.println("<head><title>CIAO!</title></head>");
			out.println("<body>");
			out.println("<h1>NON PUOI ACCEDERE</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String nome = request.getParameter("nome");
		String cognome= request.getParameter("cognome");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE HTML>");
		out.println("<html>");
		out.println("<head><title>CIAO!</title></head>");
		out.println("<body>");
		out.println("<h1>CIAO" + nome + " " + cognome + "</h1>");
		out.println("<p>sono nel doPost</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
