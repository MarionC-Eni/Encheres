package fr.eni.projet.encheres.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bll.UtilisateurManager;
import fr.eni.projet.encheres.bo.Utilisateur;

/**
 * Servlet implementation class PageMonProfil
 */
@WebServlet("/PageMonProfil")
public class PageMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PageMonProfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
<<<<<<< HEAD
		
		System.out.println(session.getAttribute("identifiant"));

	    // Récuperer l'identifiant de l'utilisateur stocké dans la session >> on caste l'objet en integer, puis le integer en int
		int noUtilisateur = (Integer) session.getAttribute("identifiant");		

		UtilisateurManager um = new UtilisateurManager();
		// utilise la DAO en fonction de la pk de la table utilisateur
		Utilisateur utilisateur = null;

		try {
			utilisateur = um.obtenirUtilisateurParId(noUtilisateur);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    request.setAttribute("utilisateur", utilisateur);

	    // pour afficher la jsp
		this.getServletContext().getRequestDispatcher("/html/PageMonProfil.jsp").forward(request, response);
	}

		
		
		/**	TEST 1:	String noUtilisateurStr = request.getParameter("noUtilisateur");

		if (noUtilisateurStr != null && !noUtilisateurStr.isEmpty()) {
			try {   
				// Convertir la chaîne en entier (int)
				int noUtilisateur = Integer.parseInt(noUtilisateurStr);

				// Utiliser le DAO pour récupérer les informations de l'utilisateur à partir de la base de données
				UtilisateurManager um = new UtilisateurManager(); // Vous devrez implémenter cette classe
				Utilisateur utilisateur = null;

				utilisateur = um.obtenirUtilisateurParId(noUtilisateur);


				// Transférer les informations de l'utilisateur à la JSP pour affichage
				request.setAttribute("utilisateur", utilisateur);

				// pour afficher la jsp
				this.getServletContext().getRequestDispatcher("/html/PageMonProfil.jsp").forward(request, response);


			} catch (NumberFormatException e) {
				// Gérer l'exception si la chaîne n'est pas un entier valide
				e.printStackTrace(); // Vous pouvez remplacer cette ligne par un message d'erreur approprié ou toute autre action souhaitée
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}}

*/
		
		
=======
		int noUtilisateur = (int) session.getAttribute("Identifiant");
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();

		try {
			utilisateurManager.obtenirUtilisateurParId(noUtilisateur);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		this.getServletContext().getRequestDispatcher("/html/PageMonProfil.jsp").forward(request, response);
	}

>>>>>>> 54265a1b0f53180633b3df09edb0aaa2920f014f

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
