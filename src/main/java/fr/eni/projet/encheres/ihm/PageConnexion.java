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
		// Initialisation de la session, c'est une interface qui fait partie de la biblio java
		HttpSession session = request.getSession();
		
		// Obtenir la valeur de la variable que tu souhaites transmettre
		if(session.getAttribute("identifiant")!= null) {
			response.sendRedirect("/Enchere-Eni/PagesListeEncheresConnecte");
			return;
		}

		// Permet de lire notre page web PageConnexion
		this.getServletContext().getRequestDispatcher("/html/PageConnexion.jsp").forward(request, response);
			
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//session.setAttribute("identifiant", 5);

		// On recupere les infos dont on a besoin soit juste email et mdp
		String email = request.getParameter("email");
		String motDePasse = request.getParameter("motDePasse");
		

		// On a créée une instance de UtilisateurManager pour pouvoir faire appel a la methode de la classe UtilisateurManager
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		// Maintenant que l'instance est créée on peut accéder aux methodes fournis par la classe
		try {
			// Appeler la méthode seConnecter de la classe UtilisateurManager pour enregistrer le nouvel utilisateur dans la base de données

			Utilisateur utilisateur = utilisateurManager.seConnecter(email,motDePasse);
			// Ligne pour afficher dans la console que l'utilisateur est bien connecté
			System.out.println(utilisateur);
				
			// cette condition permet de prendre en compte quand un utilisateur se trompe d'identifiant ou de mdp
			if (utilisateur == null) { 
				request.setAttribute("error", "identifiants invalides");
			} 
			
			/** 
			 * // cette condition permet de prendre en compte quand un utilisateur utilise un pseuo déjà pris >>> code incomplet
			
						if (utilisateur == null) { 
							request.setAttribute("error", " Pseudo déjà utilisé ");
						}
						
			*/
			
			else {
				
				// Notre variable session est definie ligne 56
				// La methode setAttribute associe la clé "identifiant" et la valeur utilisateur.getNoUtilisateur());
				session.setAttribute("identifiant", utilisateur.getNoUtilisateur());
				
				// Ligne pour afficher dans la console que l'utilisateur est bien connecté
				System.out.println(utilisateur.getNoUtilisateur());
				
				// Rediriger l'utilisateur vers la servlet "connecté"
				response.sendRedirect("/Enchere-Eni/PagesListeEncheresConnecte");
				
				return;
			}

		
		} catch (BusinessException e) {
			e.printStackTrace();
			// Rediriger l'utilisateur vers une page d'erreur ou une autre page appropriée
		}
		
		// Cette ligne nous permet de prendre en compte la condition du doGet ligne 40 à 44 
		doGet(request, response);

	}
}
