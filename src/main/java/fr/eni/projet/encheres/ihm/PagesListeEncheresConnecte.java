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
@WebServlet("/PagesListeEncheresConnecte")
public class PagesListeEncheresConnecte extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagesListeEncheresConnecte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();	
		System.out.println(session.getAttribute("identifiant"));
		
			
		if(session.getAttribute("identifiant") == null) {
			response.sendRedirect("/Enchere-Eni/PageConnexion");
			return;
		}
		
		this.getServletContext().getRequestDispatcher("/html/PagesListeEncheresConnecte.jsp").forward(request, response);

    }
			
			
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
