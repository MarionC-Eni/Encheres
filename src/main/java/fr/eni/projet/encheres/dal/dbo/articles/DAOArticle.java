package fr.eni.projet.encheres.dal.dbo.articles;

import java.util.List;

import fr.eni.projet.encheres.bo.Article;
import fr.eni.projet.encheres.bo.Categorie;
import fr.eni.projet.encheres.bo.Utilisateur;

public interface DAOArticle {


	public void ajouterArticle(Article article, Utilisateur utilisateur, Categorie categorie);
		
		public void mettreAJourArticle(Article Article);
				
		public void supprimerArticleParId(int noArticle);
				
		Article obtenirArticleParId(int no_article);
				
		List<Article> obtenirTousLesArticles(int noUtilisateur);
		
		
		
	}

