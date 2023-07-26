package fr.eni.projet.encheres.ihm;

import java.io.IOException;
import java.time.LocalDate;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bo.Categorie;
import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.exception.DALException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.projet.encheres.bll.*;

/**
 * Servlet implementation class PageAjouterArticle
 */
@WebServlet("/PageAjouterArticle")
public class PageAjouterArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageAjouterArticle() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/html/PageAjouterArticle.jsp").forward(request, response);

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
	       boolean etatVente = Boolean.parseBoolean(request.getParameter("etatVente"));
	       LocalDate dateDebut = LocalDate.parse(request.getParameter("dateDebut"));
	       LocalDate dateFin = LocalDate.parse(request.getParameter("dateFin"));
	       
 
	     
	       ArticleManager articleManager = new ArticleManager();
	       Utilisateur utilisateur = new Utilisateur();
	       // On instancie utilisateur et categorie pour pouvoir faire appek à la methode ajouterArticle
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
