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
        
        if(request.getAttribute("noArticle")!= null) {
            response.sendRedirect("/Enchere-Eni/PageVendreUnArticle");
            return;
        }
        
        
           //ici on appelle la méthode Suppression
            ArticleManager articleManager = new ArticleManager();
            
            // getParameter nous renvoie un objet mais comme noArticle on y a stocké une chaine de caractère, donc un string
            // mais on sait que noArticle est un entier, on caste le string en Integer, le integer refait un cast en type primitif
            int noArticle = Integer.parseInt((String) request.getParameter("noArticle"));


            try {
          
                articleManager.supprimerArticleParId(noArticle);
                request.setAttribute("Ventesupprime", "Votre article a été supprimé");
            
            } catch (BusinessException e) {
                e.printStackTrace();
            } catch (DALException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        
       /** Article article = null;
        int noArticle = (int) request.getAttribute("noArticle");
       
        ArticleManager articleManager = new ArticleManager();
        
        try {
            article = articleManager.obtenirArticleParId(noArticle);
        } catch (BusinessException e) {
            e.printStackTrace();
        } catch (DALException e) {
            e.printStackTrace();
        }
    
        request.setAttribute("article", article);
        */
        
        this.getServletContext().getRequestDispatcher("/html/PageVenteSupprime.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        doGet(request, response);

    }
}