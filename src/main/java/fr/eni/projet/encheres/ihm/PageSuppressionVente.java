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
import fr.eni.projet.encheres.bo.Article;
import fr.eni.projet.encheres.dal.dbo.articles.DAOArticle;
import fr.eni.projet.encheres.dal.exception.DALException;


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
		
		/**
        //ici on appelle la méthode RechercheArticleparsonID
	    // Creation d'une variable initialisée à null pour pouvoir l'utiliser 
      
	// On a créée une instance de ArticleManager pour pouvoir faire appel a la methode de la classe ArticleManager
       ArticleManager articleManager = new ArticleManager();
       try {
        	// Notre variable article stocke le resultat de la requete obternirarticleParId
			article = articleManager.obtenirArticleParId(noArticle);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	 
       */
        
        //ici on appelle la méthode Suppression
	    ArticleManager articleManager = new ArticleManager();

        try {
  	
			int noArticle = (Integer) null;
			articleManager.supprimerArticleParId(noArticle );
	        request.setAttribute("Ventesupprime", "Votre vente a été supprimé");
        
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
		doGet(request, response);

	}
}
