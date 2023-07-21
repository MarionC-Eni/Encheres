package fr.eni.projet.encheres.dal.dbo.articles;

import java.util.List;

import fr.eni.projet.encheres.bo.Article;

public interface DAOArticle {


		public void ajouterArticle(Article Article);
		
		public void mettreAJourArticle(Article Article);
				
		public void supprimerArticle(int noArticle);
				
		Article obtenirArticleParId(int no_article);
				
		List<Article> obtenirTousLesArticles(int noUtilisateur);
		
	}

