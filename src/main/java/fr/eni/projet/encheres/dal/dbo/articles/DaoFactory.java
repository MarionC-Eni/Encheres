package fr.eni.projet.encheres.dal.dbo.articles;

import fr.eni.projet.encheres.dal.dbo.utilisateur.DAOUtilisateur;

public abstract class DaoFactory {

	public static DAOArticle getDAOArticle() {
		return new ArticleDAOImpl();
	}

	public static DAOUtilisateur getDAOUtilisateur() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
