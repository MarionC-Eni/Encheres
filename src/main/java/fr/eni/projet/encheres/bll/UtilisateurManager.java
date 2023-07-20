package fr.eni.projet.encheres.bll;

	 import fr.eni.projet.encheres.BusinessException;
	 import fr.eni.projet.encheres.bo.Utilisateur;
	 import fr.eni.projet.encheres.dal.dbo.utilisateur.DAOUtilisateur;
	 import fr.eni.projet.encheres.dal.dbo.utilisateur.DaoFactory;


	public class UtilisateurManager {
	    private final DAOUtilisateur DAOUtilisateur;
	    
	    // Constructeur 
	    public UtilisateurManager() {
	        this.DAOUtilisateur = DaoFactory.getDAOUtilisateur();
	    }

	    // Méthode pour l'inscription d'un nouvel utilisateur



	    public void sinscrire (String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse, String credit, String administrateur) throws BusinessException {

            try {
                Utilisateur u = new Utilisateur();
                u.setPseudo(pseudo);
                u.setNom(nom);
                u.setPrenom(prenom);
                u.setPseudo(email);
                u.setMotDePasse(telephone);
                u.setEmail(rue);
                u.setPrenom(codePostal);
                u.setMotDePasse(ville);
                u.setEmail(motDePasse);
                u.setPrenom(credit);
                u.setEmail(administrateur);

                //validateUtilisateur(utilisateur, motDePasse);
                DAOUtilisateur.ajouterUtilisateur(u);
            } catch (Exception e) {
                throw new BusinessException("Erreur lors de l'inscription de l'utilisateur");
            }
        }
	}
	        

	    // Méthode pour la connexion d'un utilisateur
	   /* public Utilisateur seConnecter(String pseudo, String motDePasse) throws BusinessException {
	        try {
	            Utilisateur utilisateur = DAOUtilisateur.selectByPseudo(pseudo);
	            if (utilisateur != null)  {
	                return utilisateur;
	            } else {
	                throw new BusinessException("Un pseudo est obligatoire pour se connecter.");
	            }
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de la connexion de l'utilisateur");
	        }
	    }


	    // Méthode pour afficher le profil d'un utilisateur
	    public Utilisateur afficherProfil(int noUtilisateur) throws BusinessException {
	        try {
	            return DAOUtilisateur.obtenirUtilisateurParId(noUtilisateur);
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de l'affichage du profil de l'utilisateur");
	        }
	    }

	    // Méthode pour modifier le profil d'un utilisateur
	   /* public void mettreAJourUtilisateurProfil(Utilisateur utilisateur) throws BusinessException {
	        try {
	            validateUtilisateur(utilisateur); 
	            DAOUtilisateur.mettreAJourUtilisateur(utilisateur);
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de la modification du profil de l'utilisateur");
	        }
	    }

	    // Méthode pour supprimer un compte utilisateur
	   /** public void supprimerUtilisateur(Utilisateur utilisateur) throws BusinessException {
	        try {
	        	DAOUtilisateur.supprimerUtilisateur(utilisateur, motDePasse);
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de la suppression du compte de l'utilisateur", e);
	        }
	    }

	    

	    // Méthode pour retrouver son mot de passe
	    
	  /**  public void retrouverMotDePasse(String pseudo, String email) throws BusinessException {
	        try {
	            Utilisateur utilisateur = DAOUtilisateur.selectByPseudoAndEmail(pseudo, email);
	            if (utilisateur != null) {
	                // Envoyer un email avec un lien pour réinitialiser le mot de passe
	            } else {
	                throw new BusinessException("Pseudo ou email incorrect.");
	            }
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de la récupération du mot de passe", e);
	        }
	    }
	    **/

	    // Validation des données pour l'inscription et la modification du profil
	    
	  /**  private void validateUtilisateur(Utilisateur utilisateur, String motDePasse) throws BusinessException {
	    
	        // Ajouter ici les validations nécessaires pour l'utilisateur
	        // Exemple : Vérification des champs obligatoires, des valeurs valides, etc.
	        if (utilisateur.getPseudo() == null || utilisateur.getPseudo().isEmpty()) {
	            throw new BusinessException("Le pseudo ne peut pas être vide.");
	        }
	        if (utilisateur.getEmail() == null || utilisateur.getEmail().isEmpty()) {
	            throw new BusinessException("L'email ne peut pas être vide.");
	        }
	        if (motDePasse == null || motDePasse.isEmpty()) {
	            throw new BusinessException("Le mot de passe ne peut pas être vide.");
	        }
	        // Ajouter d'autres validations selon vos besoins

	       
	}
**/






