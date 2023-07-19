package fr.eni.projet.encheres.dal.dbo.articles;

public abstract class DaoFactory {

	public static ADAOArticle getAdao() {
		return new ArticleDAOImpl();
	}
}
