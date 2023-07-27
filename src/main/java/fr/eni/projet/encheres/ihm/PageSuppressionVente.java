package fr.eni.projet.encheres.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bll.ArticleManager;
import fr.eni.projet.encheres.bll.UtilisateurManager;
import fr.eni.projet.encheres.bo.Utilisateur;

/**
 * Servlet implementation class PageSuppressionVente
 */
@WebServlet("/PageSuppressionVente")
public class PageSuppressionVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageSuppressionVente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/html/PageVenteSupprime.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleManager arcticleManager = new ArticleManager();
	   	HttpSession session = request.getSession();	
		
		Integer noUtilisateur = (Integer) session.getAttribute("identifiant");		

		System.out.println(session.getAttribute("identifiant"));
		
	    // Creation d'une variable initialisée à null pour pouvoir l'utiliser ligne 56
        Utilisateur utilisateur = null;
       
		// On a créée une instance de UtilisateurManager pour pouvoir faire appel a la methode de la classe UtilisateurManager
        UtilisateurManager utilisateurManager = new UtilisateurManager();
        
        try {
        	// Notre variable utilisateur stocke le resultat de la requete obternirUtilisateurParId
			utilisateur = utilisateurManager.obtenirUtilisateurParId(noUtilisateur);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	 
        try {
        
        	// Notre methode supprimerUtilisateurById permet de retrouver l'utilisateur par son noUtilisateur
			//utilisateurManager.supprimerUtilisateurById(noUtilisateur);
			arcticleManager.supprimerArticleParId(noArticle);
	        request.setAttribute("Ventesupprime", "Votre vente a été supprimé");
        
		} catch (BusinessException e) {
			e.printStackTrace();
		}
        
        
		doGet(request, response);


}
