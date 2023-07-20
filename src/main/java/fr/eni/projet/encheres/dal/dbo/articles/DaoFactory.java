package fr.eni.projet.encheres.dal.dbo.articles;

public abstract class DaoFactory {

	public static DAOArticle getDAOArticle() {
		return new ArticleDAOImpl();
	}
}
