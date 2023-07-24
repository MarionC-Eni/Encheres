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
    public void sinscrire(String pseudo, String nom, String prenom, String email, String telephone, String rue, int codePostal, String ville, String motDePasse, int credit, boolean administrateur) throws BusinessException {
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
            u.setAdministrateur(administrateur);

            // Vérification du pseudo unique
            if (DAOUtilisateur.pseudoExiste(pseudo)) {
                throw new BusinessException("Ce pseudo est déjà pris. Veuillez en choisir un autre.");
           }

            // Vérification de l'e-mail unique
            if (DAOUtilisateur.emailExiste(email)) {
                throw new BusinessException("Cette adresse e-mail est déjà utilisée par un autre utilisateur.");
            }
            
            // Ajout de l'utilisateur à la base de données
            DAOUtilisateur.ajouterUtilisateur(u);
        } catch (Exception e) {
            throw new BusinessException("Erreur lors de l'inscription de l'utilisateur");
        }
    }

    // Méthode de validation des champs pour l'utilisateur
    private void validateUtilisateur(Utilisateur u, String motDePasse, String telephone, String rue, int codePostal, String ville, String pseudo, String nom, String email, String prenom) throws BusinessException {
    	
        // Vérification du pseudo obligatoire
        if (u.getPseudo() == null || u.getPseudo().isEmpty()) {
            throw new BusinessException("Le champ pseudo ne peut pas être vide.");
        }

        // Vérification de l'e-mail obligatoire
        if (u.getEmail() == null || u.getEmail().isEmpty()) {
            throw new BusinessException("Le champ e-mail ne peut pas être vide.");
        }

        // Vérification du mot de passe obligatoire
        if (u.getMotDePasse() == null || motDePasse.isEmpty()) {
            throw new BusinessException("Le champ mot de passe ne peut pas être vide.");
        }
        // Vérification du nom obligatoire
        if (u.getNom() == null || nom.isEmpty()) {
            throw new BusinessException("Le champ nom ne peut pas être vide.");
            
        }    // Vérification du prenom obligatoire
        if (u.getPrenom() == null || prenom.isEmpty()) {
            throw new BusinessException("Le champ prenom ne peut pas être vide.");
            
        }    // Vérification de la ville obligatoire
        if (u.getVille() == null || ville.isEmpty()) {
            throw new BusinessException("Le champ ville ne peut pas être vide.");
            
        }    // Vérification du code postal obligatoire
        if (u.getCodePostal() == 0 ){
            throw new BusinessException("Le champ code postal ne peut pas être vide.");
            
        }    // Vérification de la rue obligatoire
        if (u.getRue() == null || rue.isEmpty()) {
            throw new BusinessException("Le champ rue ne peut pas être vide.");
        }
        // Vérification du numero de telephone obligatoire
        if (u.getTelephone() == null|| telephone.isEmpty() ){
            throw new BusinessException("Le champ code postal ne peut pas être vide.");
        }
    }

	    //  Méthode pour la connexion d'un utilisateur
    public Utilisateur seConnecter(String identifiant, String motDePasse) throws BusinessException {

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(identifiant);
        
        utilisateur.setPseudo(identifiant);

        utilisateur.setMotDePasse(motDePasse);

        this.DAOUtilisateur.seConnecter(utilisateur);

        return utilisateur;
    }
	    
	 // Méthode pour supprimer un compte utilisateur
	    public void supprimerUtilisateur(Utilisateur u) throws BusinessException {
	        try {
	            DAOUtilisateur.supprimerUtilisateur(u);
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de la suppression de l'utilisateur");
	        }
	    }

		    }

	

	    // Méthode pour afficher le profil d'un utilisateur
	  /** public Utilisateur afficherProfil(int noUtilisateur) throws BusinessException {
	        try {
	            return DAOUtilisateur.obtenirUtilisateurParId(noUtilisateur);
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de l'affichage du profil de l'utilisateur");
	        }
	    }
}
*/
	    // Méthode pour modifier le profil d'un utilisateur
	   /* public void mettreAJourUtilisateurProfil(Utilisateur u, String pseudo, String motDePasse, String nom, String prenom, String email, String telephone, String rue, int codePostal, String ville) throws BusinessException {
	        try {
	            validateUtilisateur(u); 
	            DAOUtilisateur.mettreAJourUtilisateur(u);
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de la modification du profil de l'utilisateur");
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







