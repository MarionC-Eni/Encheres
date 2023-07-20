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

	    
	    public void sinscrire (String pseudo, String nom, String prenom, String email, String telephone, String rue, int codePostal, String ville, String motDePasse, int credit, boolean administrateur) throws BusinessException {


            try {
                Utilisateur u = new Utilisateur();
                u.setPseudo(pseudo);
                u.setNom(nom);
                u.setPrenom(prenom);
                u.setEmail(email);
                u.setTelephone(telephone);
                u.setRue(rue);
                u.setCodePostal(codePostal);
                u.setVille(ville);
                u.setMotDePasse(motDePasse);
                u.setCredit(credit);
                u.setadministrateur(administrateur);
                
              //  if (DAOUtilisateur.pseudoExiste(pseudo)) {
              // throw new BusinessException("Ce pseudo est déjà pris. Veuillez en choisir un autre.");
            
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
	            Utilisateur utilisateur = DAOUtilisateur.selectByPseudo&motDePasse(pseudo, motDePasse);
	            if (utilisateur != null)  {
	                return utilisateur;
	            } else {
	                throw new BusinessException("Un pseudo est obligatoire pour se connecter.");
	            }
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de la connexion de l'utilisateur");
	        }
	    }
		// modif bidon pour push

	    // Méthode pour afficher le profil d'un utilisateur
	    public Utilisateur afficherProfil(int noUtilisateur) throws BusinessException {
	        try {
	            return DAOUtilisateur.obtenirUtilisateurParId(noUtilisateur);
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de l'affichage du profil de l'utilisateur");
	        }
	    }

	    // Méthode pour modifier le profil d'un utilisateur
	   /* public void mettreAJourUtilisateurProfil(String pseudo, String motDePasse, String nom, String prenom, String email, String telephone, String rue, int codePostal, String ville, Utilisateur u) throws BusinessException {
	        try {
	            validateUtilisateur(u); 
	            DAOUtilisateur.mettreAJourUtilisateur(u);
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de la modification du profil de l'utilisateur");
	        }
	    }

	    // Méthode pour supprimer un compte utilisateur
	   /** public void supprimerUtilisateur(Utilisateur u) throws BusinessException {
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






