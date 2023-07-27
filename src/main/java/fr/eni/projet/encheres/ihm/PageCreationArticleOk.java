package fr.eni.projet.encheres.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bll.ArticleManager;
import fr.eni.projet.encheres.dal.exception.DALException;

/**
 * Servlet implementation class PageCreationCompteOk
 */
@WebServlet("/PageCreationArticleOk")
public class PageCreationArticleOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageCreationArticleOk() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		
	       //ici on appelle la méthode Suppression
		    ArticleManager articleManager = new ArticleManager();
		    
	
	        try {
	  	
				articleManager.obtenirLastArticle();
				System.out.println("on a le dernier article");
        
			} catch (BusinessException e) {
				e.printStackTrace();
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        return Article;
		
		
		// renvoi au message de felicitation
		this.getServletContext().getRequestDispatcher("/html/PageCreationArticleOk.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
