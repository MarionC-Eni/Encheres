package fr.eni.projet.encheres.dal.dbo.articles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import fr.eni.projet.encheres.bo.Article;
import fr.eni.projet.encheres.bo.Categorie;
import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.ConnectionProvider;

public class ArticleDAOImpl implements DAOArticle {

	private static final String INSERT_ARTICLES = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES (?,?,?,?,?,?,?,?)";

	//private static final String SELECT_ALL_ARTICLES = "SELECT * FROM ARTICLES_VENDUS";

	public void ajouterArticle(Article Article) {
		try {Connection connection = ConnectionProvider.getConnection();
		PreparedStatement pStmt = connection.prepareStatement(INSERT_ARTICLES);
		
		// pStmt.setInt(1, Article.getNoArticle()); > cette colonne est autoincrémentée
		pStmt.setString(1, Article.getNomArticle());
		pStmt.setString(2, Article.getDescription());
		pStmt.setDate(3, Date.valueOf(Article.getDateDebut())); // Conversion LocalDate en java.sql.Date
		pStmt.setDate(4, Date.valueOf(Article.getDateFin())); // Conversion LocalDate en java.sql.Date
		pStmt.setDouble(5, Article.getPrixVente());
		pStmt.setDouble(6, Article.getMiseAPrix());
		int categorieIdFictif = -1;
		pStmt.setInt(7, categorieIdFictif);
		int categorieIdFictif2 = -1;
		pStmt.setInt(8, categorieIdFictif2);
		//pStmt.setInt(7, -1); // il faut remplacer "-1" par "Utilisateur.getNoUtilisateur()" >> Utilisation d'une valeur fictive pour la clé étrangère 'no_utilisateur'
		//pStmt.setInt(8, -1); // il faut remplacer "-1" par "Categorie.getNoCategorie() n" >> Utilisation d'une valeur fictive pour la clé étrangère 'no_categorie'
		
		
		
		pStmt.executeUpdate();
		System.out.printf("L'Article %s a bien été ajouté", Article.getNomArticle());
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	

	public void mettreAJourArticle(Article Article) {
		// TODO Auto-generated method stub
		
	}

	
	public void supprimerArticle(Article Article) {
		// TODO Auto-generated method stub
		
	}

	public Article obtenirArticleParId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	}

	
/**	public List<Article> obtenirTousLesArticles() {
		try {Connection connection = ConnectionProvider.getConnection();
		Statement Stmt = connection.createStatement();
		ResultSet rs = Stmt.executeQuery(SELECT_ALL_ARTICLES);
		List<Article> Articles = new ArrayList<>();
				while (rs.next()) {
					Articles.add(
							new Article( 				
							rs.getString("nom"),
							rs.getString("description")
							)
					);
				}
				
					
	return Articles;
				
	} catch (SQLException e) {
		e.printStackTrace();
	}

		return null;
	}
	*/


