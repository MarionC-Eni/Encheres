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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// On récupere la ligne 92 de la servlet PageConnexion dans la variable noUtilisateur
		// getAttribute() renvoie un Object donc on doit effectuer un casting explicite pour obtenir un Integer
		Integer noUtilisateur = (Integer) session.getAttribute("identifiant");
		
		// Verification qu'on retournait bien le noUtilisateur ( seulement visible dans la console )
		System.out.println(noUtilisateur);
		System.out.println("identifiant");
		
		// Condition qui valide le fait qu'on ne peut pas modifier le profil s'il n'existe pas
        if (noUtilisateur == null) {
            response.sendRedirect("/PageConnexion");
            return;
        }
        
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
	
        // A EXPLIQUER  Cette ligne permet de récuperer l'objet utilisateur modifié dans d'autre partie du code A EXPLIQUER
    	request.setAttribute("utilisateur", utilisateur);

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
        
        
        try {
			utilisateurManager.mettreAJourUtilisateur(utilisateur);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
        

        // Ligne 12-13 PageModifierProfil.jsp 
        request.setAttribute("Profilajour", "Votre profil a été mis à jour");
        
		doGet(request, response);
	}

}
