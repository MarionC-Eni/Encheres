package fr.eni.projet.encheres.bll;

// import fr.eni.encheres.BusinessException;
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
	    public void inscription(Utilisateur utilisateur, String motDePasse) throws BusinessException {
	        try {
	            validateUtilisateur(utilisateur, motDePasse);
	            DAOUtilisateur.ajouterUtilisateur(utilisateur, motDePasse);
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de l'inscription de l'utilisateur", e);
	        }
	    }

	    // Méthode pour la connexion d'un utilisateur
	    public Utilisateur seConnecter(String pseudo, String motDePasse) throws BusinessException {
	        try {
	            Utilisateur utilisateur = DAOUtilisateur.selectByPseudo(pseudo);
	            if (utilisateur == null (utilisateur.getPseudo) {
	                return utilisateur;
	            } else {
	                throw new BusinessException("Un pseudo est obligatoire pour se connecter.");
	            }
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de la connexion de l'utilisateur", e);
	        }
	    }


	    // Méthode pour afficher le profil d'un utilisateur
	    public Utilisateur afficherProfil(int idUtilisateur) throws BusinessException {
	        try {
	            return DAOUtilisateur.selectById(noUtilisateur);
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de l'affichage du profil de l'utilisateur", e);
	        }
	    }

	    // Méthode pour modifier le profil d'un utilisateur
	    public void modifierProfil(Utilisateur utilisateur) throws BusinessException {
	        try {
	            validateUtilisateur(utilisateur); 
	            DAOUtilisateur.mettreAJourUtilisateur(utilisateur);
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de la modification du profil de l'utilisateur", e);
	        }
	    }

	    // Méthode pour supprimer un compte utilisateur
	    public void supprimerCompte(Utilisateur utilisateur) throws BusinessException {
	        try {
	            DAOUtilisateur.supprimerUtilisateur(utilisateur);
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de la suppression du compte de l'utilisateur", e);
	        }
	    }

	    

	    // Méthode pour retrouver son mot de passe
	    
	    public void retrouverMotDePasse(String pseudo, String email) throws BusinessException {
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

	    // Validation des données pour l'inscription et la modification du profil
	    
	    private void validateUtilisateur(Utilisateur utilisateur, String motDePasse) throws BusinessException {
	    
	        // Ajouter ici les validations nécessaires pour l'utilisateur
	        // Exemple : Vérification des champs obligatoires, des valeurs valides, etc.
	        if (utilisateur.getPseudo() == null || utilisateur.getPseudo().isEmpty()) {
	            throw new BusinessException("Le pseudo ne peut pas être vide.");
	        }
	        if (utilisateur.getEmail() == null || utilisateur.getEmail().isEmpty()) {
	            throw new BusinessException("L'email ne peut pas être vide.");
	        }
	        if (motDePasseNonHash == null || motDePasse.isEmpty()) {
	            throw new BusinessException("Le mot de passe ne peut pas être vide.");
	        }
	        // Ajouter d'autres validations selon vos besoins

	       
	}





}

