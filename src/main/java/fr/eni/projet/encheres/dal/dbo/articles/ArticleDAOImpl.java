package fr.eni.projet.encheres.dal.dbo.articles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.encheres.bo.Article;
import fr.eni.projet.encheres.dal.ConnectionProvider;

public class ArticleDAOImpl implements ADAOArticle {

	private static final String INSERT_ARTICLES = "INSERT INTO Articles (nom, description) VALUES (?,?)";
	private static final String SELECT_ALL_ARTICLES = "SELECT * FROM Articles";

	
	@Override
	public void ajouterArticle(Article Article) {
		try {Connection connection = ConnectionProvider.getConnection();
		PreparedStatement pStmt = connection.prepareStatement(INSERT_ARTICLES);
		
		pStmt.setString(1, Article.getNomArticle());
		pStmt.setString(2, Article.getDescription());
		pStmt.executeUpdate();
		System.out.println("L'Article %s a bien été ajouté");
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}
	@Override
	public void mettreAJourArticle(Article Article) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void supprimerArticle(Article Article) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Article obtenirArticleParId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Article> obtenirTousLesArticles() {
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
}