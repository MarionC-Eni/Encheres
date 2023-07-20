package fr.eni.projet.encheres.dal.dbo.encheres;

import java.util.List;

import fr.eni.projet.encheres.bo.Article;
import fr.eni.projet.encheres.bo.Enchere;
import fr.eni.projet.encheres.bo.Utilisateur;

public interface DAOEnchere {


	public void ajouterEnchere(Enchere enchere, Utilisateur utilisateur, Article article);

	public void mettreAJourEnchere(Enchere enchere);

	public void supprimerEnchere(Enchere enchere);

	List<Enchere> obtenirToutesLesEncheres();
}

