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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/html/PageCreerCompte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
        UtilisateurManager utilisateurManager = new UtilisateurManager();
        try {
			utilisateurManager.sinscrire(pseudo, nom, prenom, email,telephone,rue,codePostal,ville,motDePasse,credit,administrateur);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        doGet(request, response);

	}
}
