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
<<<<<<< Updated upstream
import fr.eni.projet.encheres.bll.UtilisateurManager;
=======
>>>>>>> Stashed changes

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
		HttpSession session = request.getSession();
		// Obtenir la valeur de la variable que tu souhaites transmettre

		if(session.getAttribute("identifiant")!= null) {
			response.sendRedirect("/Enchere-Eni/PagesListeEncheresConnecte");
			return;
		}

		this.getServletContext().getRequestDispatcher("/html/PageConnexion.jsp").forward(request, response);
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//session.setAttribute("identifiant", 5);
		
		   String email = request.getParameter("email");
		   String motDePasse = request.getParameter("motDePasse");
		    // récupérer les autres paramètres du formulaire d'inscription

		    UtilisateurManager utilisateurManager = new UtilisateurManager();

		    try {
		        // Appeler la méthode sinscrire de la classe UtilisateurManager pour enregistrer le nouvel utilisateur dans la base de données
		        utilisateurManager.seConnecter(email,motDePasse);

		        // Si l'inscription est réussie, stocker l'identifiant de l'utilisateur dans la session
		        //HttpSession session = request.getSession();
<<<<<<< Updated upstream
		        //String identifiant = utilisateurManager.getUtilisateurByPseudoMdp(email, motDePasse).getNoUtilisateur();
		        session.setAttribute("email", email);
		        session.setAttribute("motDePasse",motDePasse);
=======
		        String identifiant = utilisateurManager.getUtilisateurByPseudoMdp(email, motDePasse).getNoUtilisateur();
		        session.setAttribute("identifiant", identifiant);
>>>>>>> Stashed changes

		        // Rediriger l'utilisateur vers la servlet "connecté"
		        response.sendRedirect("/Enchere-Eni/PagesListeEncheresConnecte");
		    } catch (BusinessException e) {
		        e.printStackTrace();
		        // Rediriger l'utilisateur vers une page d'erreur ou une autre page appropriée
		        response.sendRedirect("/PageConnexion");
		    }
<<<<<<< Updated upstream
			
		//doGet(request, response);
	}
	
	

=======
		}
>>>>>>> Stashed changes
}
