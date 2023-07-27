package fr.eni.projet.encheres.ihm;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bll.ArticleManager;
import fr.eni.projet.encheres.bll.UtilisateurManager;
import fr.eni.projet.encheres.bo.Categorie;
import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.exception.DALException;

/**
 * Servlet implementation class PageVendreUnArticle
 */
@WebServlet("/PageVendreUnArticle")
public class PageVendreUnArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageVendreUnArticle() {
        super();
    }

    

    	/**
    	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		HttpSession session = request.getSession();	

    		Integer noUtilisateur = (Integer) session.getAttribute("identifiant");		

    		System.out.println(session.getAttribute("identifiant"));
    		
    		
    		// Condition qui valide le fait qu'on ne peut pas modifier le profil s'il n'existe pas
            if (noUtilisateur == null) {
                response.sendRedirect("/PageConnexion");
                return;
            }
            
            
    		this.getServletContext().getRequestDispatcher("/html/PageVendreUnArticle.jsp").forward(request, response);

        }
    	

    	/**
    	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    	       String nomArticle = request.getParameter("nomArticle");
    	       System.out.println(nomArticle);

    	       String description = request.getParameter("description");
    	       double prixVente = Double.parseDouble(request.getParameter("prixVente"));
    	       double miseAPrix = Double.parseDouble(request.getParameter("miseAPrix"));
    	       //test1 : boolean etatVente = Boolean.parseBoolean(request.getParameter("etatVente"));
    	      boolean etatVente = true;
    	       
    	       String dateDebutString = request.getParameter("dateDebut");
    	       LocalDate dateDebut = LocalDate.parse(dateDebutString);
    	      // essai n°1: LocalDate dateDebut = LocalDate.parse(request.getParameter("dateDebut"));
    	       
    	       String dateFinString = request.getParameter("dateFin");
    	       LocalDate dateFin = LocalDate.parse(dateFinString);
    	       // essai n°1: LocalDate dateFin = LocalDate.parse(request.getParameter("dateFin"));
    	   
    	       /**essai d'ajout du numero utilisateur
    	       Utilisateur noUtilisateur;
			request.setAttribute("noUtilisateur", noUtilisateur);
			*/

    	     
    	   ArticleManager articleManager = new ArticleManager();
    	       
    	      /** tentative n°1:
    	       *   // On instancie utilisateur et categorie pour pouvoir faire appek à la methode ajouterArticle
    	       *  Utilisateur utilisateur = new Utilisateur();
    	       */
    	       
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
    	 
    	    
    	    
    	    
    	       Categorie categorie = new Categorie();

    	     
    	            try {
    					try {
    						articleManager.ajouterArticle(nomArticle,description,prixVente,miseAPrix,etatVente,dateDebut,dateFin,utilisateur,categorie);
    					} catch (BusinessException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
    					// on comprend pas pourquoi ça marche avec 2 try catch
    				} catch (DALException e) {
    					e.printStackTrace();
    				}

    	      
    		
    		
    		
    		doGet(request, response);
    	}

    }

