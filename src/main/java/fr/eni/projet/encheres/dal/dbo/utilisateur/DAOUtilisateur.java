package fr.eni.projet.encheres.dal.dbo.utilisateur;

import java.util.List;

import fr.eni.projet.encheres.bo.Utilisateur;

public interface DAOUtilisateur {


	public void ajouterUtilisateur(Utilisateur utilisateur);

	public void mettreAJourUtilisateur(Utilisateur utilisateur);

	public void supprimerUtilisateurById(int noUtilisateur);
	
	public Utilisateur obtenirUtilisateurParId(int noUtilisateur);

	List<Utilisateur> obtenirTousLesUtilisateurs();
	
	public boolean pseudoExiste(String pseudo);
	
	public boolean emailExiste(String email);
	
	public Utilisateur seConnecter(String email, String motDePasse);
}

