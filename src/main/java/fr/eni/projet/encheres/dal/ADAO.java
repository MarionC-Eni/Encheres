package fr.eni.projet.encheres.dal;

import java.util.List;

import fr.eni.projet.encheres.bo.Utilisateur;

public interface ADAO {


		public void ajouterUtilisateur(Utilisateur utilisateur);
		
		public void mettreAJourUtilisateur(Utilisateur utilisateur);
				
		public void supprimerUtilisateur(Utilisateur utilisateur);
				
		Utilisateur obtenirUtilisateurParId(int id);
				
		List<Utilisateur> obtenirTousLesUtilisateurs();
	}

