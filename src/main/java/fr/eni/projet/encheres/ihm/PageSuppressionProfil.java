package fr.eni.projet.encheres.ihm;

import java.io.IOException;
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
 * Servlet implementation class PageSuppressionProfil
 */
@WebServlet("/PageSuppressionProfil")
public class PageSuppressionProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageSuppressionProfil() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		this.getServletContext().getRequestDispatcher("/html/PageProfilSupprime.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer noUtilisateur = (Integer) session.getAttribute("identifiant");
		

         
       UtilisateurManager utilisateurManager = new UtilisateurManager();
        
        try {
        	// Notre methode supprimerUtilisateurById permet de retrouver l'utilisateur par son noUtilisateur
			utilisateurManager.supprimerUtilisateurById(noUtilisateur);
			session.invalidate(); // Supprimer la session de l'utilisateur après la suppression
	        request.setAttribute("Profilsupprime", "Votre profil a été supprimé");
	    
		} catch (BusinessException e) {
			e.printStackTrace();
		}
        
        
		doGet(request, response);

   

}
}