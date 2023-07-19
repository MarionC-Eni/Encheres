package fr.eni.projet.encheres.ihm;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/connectionServlet")
public class connectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public connectionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/html/index.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String utilisateur = request.getParameter("utilisateur");
		utilisateur = utilisateur.toUpperCase();
		request.setAttribute("utilisateur", utilisateur);
		this.getServletContext().getRequestDispatcher("/html/index.html").forward(request, response);
		
		String password = request.getParameter("password");
		password = password.toUpperCase();
		request.setAttribute("password", password);
		this.getServletContext().getRequestDispatcher("/html/index.html").forward(request, response);
	}
	}
