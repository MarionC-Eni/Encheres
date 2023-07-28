package fr.eni.projet.encheres.ihm;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bll.ArticleManager;
import fr.eni.projet.encheres.bll.UtilisateurManager;
import fr.eni.projet.encheres.bo.Categorie;
import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.bo.Article;
import fr.eni.projet.encheres.dal.exception.DALException;

/**
 * Servlet implementation class PageModifierVente
 */
@WebServlet("/PageModifierVente")
public class PageModifierVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageModifierVente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    ArticleManager articleManager = new ArticleManager();
	    
        int noArticle = Integer.parseInt((String) request.getParameter("noArticle"));

        Article article = null;
        
        try {
  	
		article = articleManager.obtenirArticleParId(noArticle);
        
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
        request.setAttribute("article", article);
		
		this.getServletContext().getRequestDispatcher("/html/PageModifierVente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	//modèle de la page modification article
    int noArticle = Integer.parseInt((String) request.getParameter("noArticle"));

    // Récupérer les données du formulaire de modification
	String nomArticle = request.getParameter("nomArticle");
    String description = request.getParameter("description");
    double prixVente = Double.parseDouble(request.getParameter("prixVente"));
    double miseAPrix = Double.parseDouble(request.getParameter("miseAPrix"));
    String dateDebutString = request.getParameter("dateDebut");
    LocalDate dateDebut = LocalDate.parse(dateDebutString);    
    String dateFinString = request.getParameter("dateFin");
    LocalDate dateFin = LocalDate.parse(dateFinString);
	

        // Mettre à jour les informations de l'article
        Article article = new Article();
        Categorie categorie = new Categorie();
        Utilisateur utilisateur = null;

		Integer noUtilisateur = (Integer) request.getSession().getAttribute("identifiant");
	       
			// On a créée une instance de UtilisateurManager pour pouvoir faire appel a la methode de la classe UtilisateurManager
	        UtilisateurManager utilisateurManager = new UtilisateurManager();
	        
	        try {
	        	// Notre variable utilisateur stocke le resultat de la requete obternirUtilisateurParId
				utilisateur = utilisateurManager.obtenirUtilisateurParId(noUtilisateur);
			} catch (BusinessException e) {
				e.printStackTrace();
			}

	    article.setNoArticle(noArticle);
    	article.setNomArticle(nomArticle);
    	article.setDescription(description);
    	article.setDateDebut(dateDebut);
    	article.setDateFin(dateFin);
    	article.setPrixVente(prixVente);
    	article.setMiseAPrix(miseAPrix);
    	//article.setEtatVente(true);
    	utilisateur.setNoUtilisateur(noUtilisateur);
    	categorie.setNoCategorie(1);
    

        ArticleManager articleManager = new ArticleManager();
        
        
        try {
			articleManager.mettreAJourArticle(article, utilisateur);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        // renvoi vers PageModifierVente.jsp 		
		
        request.setAttribute("Ventemodifiee", "Votre article a été modifié");

		doGet(request, response);
	}

}
