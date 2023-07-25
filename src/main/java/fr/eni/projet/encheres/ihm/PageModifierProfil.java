package fr.eni.projet.encheres.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.encheres.bo.Utilisateur;

/**
 * Servlet implementation class PageModifierProfil
 */
@WebServlet("/PageModifierProfil")
public class PageModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageModifierProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int noUtilisateur = (Integer) session.getAttribute("identifiant");
        if (noUtilisateur == null) {
            response.sendRedirect("/PageConnexion");
            return;
        }
		this.getServletContext().getRequestDispatcher("/html/PageModifierProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

        if (utilisateur == null) {
            // Si l'utilisateur n'est pas connecté, rediriger vers la page de connexion
            response.sendRedirect("/PageModifierProfil");
            return;
        }

        // Récupérer les données du formulaire de modification
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String rue = request.getParameter("rue");
        int codePostal = request.getParameter("codePostal");
        String ville = request.getParameter("ville");
        String motDePasse = request.getParameter("motDePasse");
        String pseudo = request.getParameter("pseudo");

        // Mettre à jour les informations de l'utilisateur
        utilisateur.setPseudo("pseudo");
        utilisateur.setNom("nom");
        utilisateur.setPrenom("prenom");
        utilisateur.setEmail("email");
        utilisateur.setTelephone("telephone");
        utilisateur.setRue("rue");
        utilisateur.setCodePostal("codePostal");
        utilisateur.setVille("ville");
        utilisateur.setMotDePasse("motDePasse");
        
        response.sendRedirect("Enchere-Eni/PageModifierProfil");
        
		doGet(request, response);
	}

}
