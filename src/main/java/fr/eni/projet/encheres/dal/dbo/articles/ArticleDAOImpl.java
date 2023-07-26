package fr.eni.projet.encheres.dal.dbo.articles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;
import fr.eni.projet.encheres.bo.Article;
import fr.eni.projet.encheres.bo.Categorie;
import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.ConnectionProvider;

public class ArticleDAOImpl implements DAOArticle {

	private static final String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES (?,?,?,?,?,?,?,?)";
	private static final String SELECT_ALL_ARTICLES = null;

	//private static final String SELECT_ALL_ARTICLES = "SELECT * FROM ARTICLES_VENDUS";

	public void ajouterArticle(Article article, Utilisateur utilisateur, Categorie categorie) {
		try {Connection connection = ConnectionProvider.getConnection();
		PreparedStatement pStmt = connection.prepareStatement(INSERT_ARTICLE);
		
		// pStmt.setInt(1, Article.getNoArticle()); > cette colonne est autoincrémentée
		pStmt.setString(1, article.getNomArticle());
		pStmt.setString(2, article.getDescription());
		pStmt.setDate(3, Date.valueOf(article.getDateDebut())); // Conversion LocalDate en java.sql.Date
		pStmt.setDate(4, Date.valueOf(article.getDateFin())); // Conversion LocalDate en java.sql.Date
		pStmt.setDouble(5, article.getPrixVente());
		pStmt.setDouble(6, article.getMiseAPrix());
		pStmt.setInt(7, utilisateur.getNoUtilisateur());
		pStmt.setInt(8, categorie.getNoCategorie());
			
		pStmt.executeUpdate();
	
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	

	public void mettreAJourArticle(Article Article) {
		
	}

	
	public void supprimerArticle(Article Article) {
		
	}

	public Article obtenirArticleParId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	/** public List<Article> obtenirTousLesArticles() {
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

	@Override
	public void supprimerArticle(int noArticle) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<Article> obtenirTousLesArticles(int noUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}
	}


