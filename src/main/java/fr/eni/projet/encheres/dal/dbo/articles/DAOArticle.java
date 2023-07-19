package fr.eni.projet.encheres.dal.dbo.articles;

import java.util.List;

import fr.eni.projet.encheres.bo.Article;

public interface ADAOArticle {


		public void ajouterArticle(Article Article);
		
		public void mettreAJourArticle(Article Article);
				
		public void supprimerArticle(Article Article);
				
		Article obtenirArticleParId(int no_article);
				
		/**List<Article> obtenirTousLesArticles();
		 * 
		 */
	}

