package fr.eni.projet.encheres.dal.dbo.encheres;

import java.util.List;

import fr.eni.projet.encheres.bo.Enchere;

public interface DAOEnchere {


	public void ajouterEnchere(Enchere enchere);

	public void mettreAJourEnchere(Enchere enchere);

	public void supprimerEnchere(Enchere enchere);

	Enchere obtenirEnchereParId(int noEnchere);

	List<Enchere> obtenirToutesLesEncheres();
}

