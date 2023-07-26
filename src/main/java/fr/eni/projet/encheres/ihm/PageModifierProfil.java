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
		Integer noUtilisateur = (Integer) session.getAttribute("identifiant");
		System.out.println(noUtilisateur);
		System.out.println("identifiant");
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
		Integer noUtilisateur = (Integer) session.getAttribute("identifiant");
		
        // Récupérer les données du formulaire de modification
        String pseudo = request.getParameter("pseudo");
        String nom = request.getParameter("nom");
        String prenom =  request.getParameter("prenom");
        String email =  request.getParameter("email");
        String telephone =  request.getParameter("telephone");
        String rue = request.getParameter("rue");
        int codePostal = Integer.parseInt(request.getParameter("codePostal")); 
        String ville = request.getParameter("ville");
        String motDePasse = request.getParameter("motDePasse");


        // Mettre à jour les informations de l'utilisateur
        Utilisateur utilisateur = new Utilisateur ();
        utilisateur.setNoUtilisateur(noUtilisateur);
        utilisateur.setPseudo(pseudo);
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(email);
        utilisateur.setTelephone(telephone);
        utilisateur.setRue(rue);
        utilisateur.setCodePostal(codePostal);
        utilisateur.setVille(ville);
        utilisateur.setMotDePasse(motDePasse);
        
        UtilisateurManager utilisateurManager = new UtilisateurManager();
        //Utilisateur utilisateur = null;
        
        try {
			utilisateurManager.mettreAJourUtilisateur(utilisateur);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.setAttribute("Profilajour", "Votre profil a été mis à jour");
        
		doGet(request, response);
	}

}
