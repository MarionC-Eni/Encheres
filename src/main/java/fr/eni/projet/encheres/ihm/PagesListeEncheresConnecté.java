package fr.eni.projet.encheres.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PagesListeEncheresConnecté
 */
@WebServlet("/PagesListeEncheresConnecté")
public class PagesListeEncheresConnecté extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagesListeEncheresConnecté() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    		this.getServletContext().getRequestDispatcher("/html/PagesListeEncheresConnecté.jsp").forward(request, response);		
    		//this.getServletContext().getRequestDispatcher("/PagesAccueilNonConnecte").forward(request, response);
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String identifiant = request.getParameter("Identifiant");
		if(identifiant!=null)
			this.getServletContext().getRequestDispatcher("/html/PagesListeEncheresConnecté.jsp").forward(request, response);
		else
			this.getServletContext().getRequestDispatcher("/PagesListeEncheresConnecté.jsp").forward(request, response);
		doGet(request, response);
	}

}
