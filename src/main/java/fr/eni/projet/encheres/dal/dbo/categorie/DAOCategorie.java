package fr.eni.projet.encheres.dal.dbo.categorie;

import java.util.List;

import fr.eni.projet.encheres.bo.Categorie;

public interface DAOCategorie {


	public void ajouterCategorie(Categorie categorie);

	public void mettreAJourCategorie(Categorie categorie);

	public void supprimerCategorie(Categorie categorie);

	Categorie obtenirCategorieParId(int noCategorie);

	List<Categorie> obtenirToutesLesCategories();
}

