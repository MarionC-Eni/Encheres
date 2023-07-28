package fr.eni.projet.encheres.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bll.UtilisateurManager;

/**
 * Servlet implementation class CreationCompte
 */
@WebServlet("/PageCreerCompte")
public class PageCreerCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageCreerCompte() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Permet de lire la page web PageCreerCompte
		this.getServletContext().getRequestDispatcher("/html/PageCreerCompte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Permet de stocker dans les variables ce qui a été ecrit dans le formulaire
        String pseudo = request.getParameter("pseudo");
        String nom = request.getParameter("nom");
        String prenom =  request.getParameter("prenom");
        String email =  request.getParameter("email");
        String telephone =  request.getParameter("telephone");
        String rue = request.getParameter("rue");
        int codePostal = Integer.parseInt(request.getParameter("codePostal")); 
        String ville = request.getParameter("ville");
        String motDePasse = request.getParameter("motDePasse");
        int credit = 100;
        boolean administrateur = false;
        
		// On a créée une instance de UtilisateurManager pour pouvoir faire appel a la methode de la classe UtilisateurManager
        UtilisateurManager utilisateurManager = new UtilisateurManager();
        try {
        	// ATTENTION la methode sinscire ne comprends pas le noUtilisateur
			utilisateurManager.sinscrire(pseudo,nom,prenom,email,telephone,rue,codePostal,ville,motDePasse,credit,administrateur);
		} catch (BusinessException e) {
			//String errorIdentifiant = be.getMessage();
		    //request.setAttribute("errorIdentifiant", "Adresse email ou mot de passe incorrect");
		    e.printStackTrace();
		}
   
        // Redirection vers la servlet qui gere le message " felicitation vous avez créée un compte" 
        // On aurait pu faire un ternaire pour gérer ça
        this.getServletContext().getRequestDispatcher("/PageCreationCompteOk").forward(request, response);

	}
}
