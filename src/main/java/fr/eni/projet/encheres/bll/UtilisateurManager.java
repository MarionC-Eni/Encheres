package fr.eni.projet.encheres.bll;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.dbo.utilisateur.DAOUtilisateur;
import fr.eni.projet.encheres.dal.dbo.utilisateur.DaoFactory;

public class UtilisateurManager {
	
    private final DAOUtilisateur DAOUtilisateur;

    // Constructeur BLL qui crée une instance de DAOUtilisateur pour faire appel à la classe DaoFactory
    public UtilisateurManager() {
        this.DAOUtilisateur = DaoFactory.getDAOUtilisateur();
    }

    // Méthode pour l'inscription d'un nouvel utilisateur
    public void sinscrire(String pseudo, String nom, String prenom, String email, String telephone, String rue, int codePostal, String ville, String motDePasse, int credit, boolean administrateur) throws BusinessException {
        
    	// on a créé un nouvel objet Utilisateur et on a initialisé ses propriétés
    	try {
            Utilisateur u = new Utilisateur();
            u.setPseudo(pseudo); // Définit le pseudo de l'utilisateur avec la valeur de la variable 'pseudo'
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

            // Vérification du pseudo unique qui affiche le message d'erreur dans la console uniquement  > code incomplet servlet page connexion
            if (DAOUtilisateur.pseudoExiste(pseudo)) {
                throw new BusinessException("Ce pseudo est déjà pris. Veuillez en choisir un autre.");
           }

            // Vérification de l'e-mail unique qui affiche le message d'erreur dans la console uniquement > code incomplet servlet page connexion
            if (DAOUtilisateur.emailExiste(email)) {
                throw new BusinessException("Cette adresse e-mail est déjà utilisée par un autre utilisateur.");
            }
            
            // cette ligne permet l'ajout de l'utilisateur à la base de données grâce à la méthode ajouterUtilisateur de la DAO
            DAOUtilisateur.ajouterUtilisateur(u);
            
        } catch (BusinessException be) {
        	// cette exception est liée à la méthode ajouterUtilisateur
			throw be;
		}
        catch (Exception e) {
        	// cette exception est liée la méthode sinscrire
              throw new BusinessException("Erreur lors de l'inscription de l'utilisateur");
        }
    }

    
   
	//  Méthode pour la connexion d'un utilisateur : le détail est dans la DAO
    public Utilisateur seConnecter(String identifiant, String motDePasse) throws BusinessException {

    	Utilisateur utilisateur = this.DAOUtilisateur.seConnecter(identifiant, motDePasse);
		return utilisateur;
		
    }
	    
	 // Méthode pour supprimer un compte utilisateur (avec un try catch qui renvoie un message d'erreur) : le détail est dans la DAO
	    public void supprimerUtilisateurById(int noUtilisateur) throws BusinessException {
	        try {
	            DAOUtilisateur.supprimerUtilisateurById(noUtilisateur);
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de la suppression de l'utilisateur");
	        }
	    }

		    
	    // Méthode pour afficher le profil d'un utilisateur à partir de son ID : le détail est dans la DAO
	    public Utilisateur obtenirUtilisateurParId(int noUtilisateur) throws BusinessException {
	        try {
	            return DAOUtilisateur.obtenirUtilisateurParId(noUtilisateur);
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de l'affichage du profil de l'utilisateur");
	        }
	    }


	    // Méthode pour modifier le profil d'un utilisateur à partir de son ID : le détail est dans la DAO
	    public void mettreAJourUtilisateur(Utilisateur utilisateur) throws BusinessException {
	        try {
	        	DAOUtilisateur.mettreAJourUtilisateur(utilisateur);
	        } catch (Exception e) {
	            throw new BusinessException("Erreur lors de la modification du profil de l'utilisateur");
	       }
	    }
}

/** 
voici des pistes d'amélioration pour cette classe Utilisateur Manager :

1. autre syntaxe possible pour la méthode mettreAJourUtilisateurProfil:
public Utilisateur mettreAJourUtilisateurProfil(Utilisateur u, String pseudo, String motDePasse, String nom, String prenom, String email, String telephone, String rue, int codePostal, String ville) throws BusinessException {
    Utilisateur utilisateur = this.DAOUtilisateur.mettreAJourUtilisateurProfil(u, pseudo, motDePasse, nom, prenom, email, telephone, rue, codePostal, ville);
    return utilisateur;
}


2. création d'un nouvelle méthode	   
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




3. on avait créé cette méthode pour valider les champs du formulaire, mais on ne l'utilise pas encore :
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

*/





