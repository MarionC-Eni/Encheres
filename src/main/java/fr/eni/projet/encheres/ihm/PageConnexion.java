package fr.eni.projet.encheres.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PageConnexion
 */
@WebServlet("/PageConnexion")
public class PageConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageConnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtenir la valeur de la variable que tu souhaites transmettre
	    String identifiant = "identifiant";

	    // Ajouter la variable à l'objet HttpServletRequest
	    request.setAttribute("identifiant", identifiant);

	    // Rediriger la requête vers la servlet de destination
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/Enchere-Eni/PagesListeEncheresConnecté");
	    dispatcher.forward(request, response);
		this.getServletContext().getRequestDispatcher("/html/PageConnexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();	
		String identifiant = request.getParameter("Identifiant");
		System.out.println(identifiant);
		doGet(request, response);
	}

}
