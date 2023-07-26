package fr.eni.projet.encheres.dal.dbo.utilisateur;

import java.util.List;

import fr.eni.projet.encheres.bo.Utilisateur;

public interface DAOUtilisateur {

	// première méthode de notre interface pour créer un nouvel utilisateur
	public void ajouterUtilisateur(Utilisateur utilisateur);
	
	
	public Utilisateur seConnecter(String email, String motDePasse);
	public boolean pseudoExiste(String pseudo);
	public boolean emailExiste(String email);
	
	public Utilisateur obtenirUtilisateurParId(int noUtilisateur);

	public void mettreAJourUtilisateur(Utilisateur utilisateur);

	public void supprimerUtilisateurById(int noUtilisateur);
	

	// on a créé cette méthode mais on ne l'utilise pas encore
	List<Utilisateur> obtenirTousLesUtilisateurs();
	
	
}

