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
		String noUtilisateurStr = request.getParameter("noUtilisateur");

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


	/**	TEST 1:	HttpSession session = request.getSession();	
	    // Récuperer l'identifiant de l'utilisateur stocké dans la session
		Utilisateur utilisateur = (Utilisateur) session.getAttribute(noUtilisateur);


		UtilisateurManager um = new UtilisateurManager();
		// utilise la DAO en fonction de la pk de la table utilisateur
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


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
