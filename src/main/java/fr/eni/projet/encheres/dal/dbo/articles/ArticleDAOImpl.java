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
	private static final String DELETE_ARTICLE = "DELETE FROM ARTICLES_VENDUS WHERE no_article = ?";
	private static final String SELECT_ONE_ARTICLE = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?";
	private static final String SELECT_LAST_ARTICLE = "SELECT * FROM ARTICLES_VENDUS ORDER BY no_article DESC LIMIT 1";
	//private static final String SELECT_ALL_ARTICLES = null;

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
		// pStmt.setInt(8, categorie.getNoCategorie()); Categorie ID dans la BDD
		pStmt.setInt(8, 1);

		pStmt.executeQuery();
		
		/** 
	
	
	//	ResultSet rs = pStmt.getGeneratedKeys();
		
	tentative n°2	ResultSet rs = pStmt.executeQuery();
		   if (rs.next()) {
		     int pk = rs.getInt(1);
		     System.out.println("monarticle" + pk);
		     return pk;
		}
		
		
		*/
	
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		//cas d'erreur si on n'arrive pas à récupérer le noArticle de la bdd
	//	return 0;
	}
	
	
	public void mettreAJourArticle(Article Article) {
		
	}

	
	public void supprimerArticleParId(int noArticle) {
		
		try {Connection connection = ConnectionProvider.getConnection();
		PreparedStatement pStmt = connection.prepareStatement(DELETE_ARTICLE);
		
		pStmt.setInt(1, noArticle);
		pStmt.executeUpdate();
	
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
		
	
	public Article obtenirLastArticle() {
		Article article = null;
		Utilisateur utilisateur=null;
		Categorie categorie=null;
		
		 try {
		        Connection connection = ConnectionProvider.getConnection();        
		        PreparedStatement pstmt = connection.prepareStatement(SELECT_LAST_ARTICLE);
		        ResultSet rs = pstmt.executeQuery();
		        // La méthode rs.next() est appelée pour 
		        // avancer le curseur du ResultSet vers la première ligne (s'il y en a une)
		        if (rs.next()) {
		        	utilisateur = new Utilisateur();
		        	article = new Article();
		        	categorie = new Categorie();
		        	article.setNoArticle(rs.getInt("no_article"));
		        	article.setNomArticle(rs.getString("nom_article"));
		        	article.setDescription(rs.getString("description"));
		        	//article.setDateDebut(rs.getLocalDate("date_debut_encheres"));
		        	article.setDateDebut(rs.getDate("date_debut_encheres").toLocalDate());
		        	article.setDateFin(rs.getDate("date_fin_encheres").toLocalDate());
		        	article.setMiseAPrix(rs.getDouble("mise_a_prix"));
		        	article.setPrixVente(rs.getDouble("prix_vente"));
		        	article.setEtatVente(rs.getBoolean("etat_vente"));
		        	//importation clés étrangères
		        	utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
		        	categorie.setNoCategorie(rs.getInt("no_categorie"));
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		return article;
		}
		
		
		
		
	
	
	public Article obtenirArticleParId(int noArticle) {
		Article article = null;
		Utilisateur utilisateur=null;
		Categorie categorie=null;

	    try {
	        Connection connection = ConnectionProvider.getConnection();        
	        PreparedStatement cstmt = connection.prepareStatement(SELECT_ONE_ARTICLE);
	        cstmt.setInt(1, noArticle);
	        ResultSet rs = cstmt.executeQuery();
	        // La méthode rs.next() est appelée pour 
	        // avancer le curseur du ResultSet vers la première ligne (s'il y en a une)
	        if (rs.next()) {
	        	utilisateur = new Utilisateur();
	        	article = new Article();
	        	categorie = new Categorie();
	        	article.setNoArticle(rs.getInt("no_article"));
	        	article.setNomArticle(rs.getString("nom_article"));
	        	article.setDescription(rs.getString("description"));
	        	//article.setDateDebut(rs.getLocalDate("date_debut_encheres"));
	        	article.setDateDebut(rs.getDate("date_debut_encheres").toLocalDate());
	        	article.setDateFin(rs.getDate("date_fin_encheres").toLocalDate());
	        	article.setMiseAPrix(rs.getDouble("mise_a_prix"));
	        	article.setPrixVente(rs.getDouble("prix_vente"));
	        	article.setEtatVente(rs.getBoolean("etat_vente"));
	        	//importation clés étrangères
	        	utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
	        	categorie.setNoCategorie(rs.getInt("no_categorie"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	return article;
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
	public List<Article> obtenirTousLesArticles(int noUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}
	}


