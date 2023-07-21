package fr.eni.projet.encheres.dal.dbo.encheres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.encheres.bo.Article;
import fr.eni.projet.encheres.bo.Enchere;
import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.ConnectionProvider;

public class EnchereDAOImpl implements DAOEnchere {

	private static final String INSERT_ENCHERE = "INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?,?, ?,?)";
	private static final String SELECT_ALL_ENCHERES = "SELECT * FROM ENCHERES";

	
	public void faireEnchere(Enchere enchere, Utilisateur utilisateur, Article article) {
		try {Connection connection = ConnectionProvider.getConnection();
		PreparedStatement pStmt = connection.prepareStatement(INSERT_ENCHERE);
		
		 // Assurez-vous que l'objet Utilisateur est associé à l'objet Enchere avant d'appeler la méthode ajouterEnchere()
		
        pStmt.setInt(1, utilisateur.getNoUtilisateur());
        pStmt.setInt(2, article.getNoArticle());
        pStmt.setTimestamp(3, new java.sql.Timestamp(enchere.getDateEnchere().getTime()));        
        pStmt.setInt(4, enchere.getmontantEnchere());
		
		pStmt.executeUpdate();
/**
 * System.out.printf("L'Enchere %s a bien été ajoutée", Enchere.getNom()););	// phase de test : on affiche pas cette ligne	
 */
		
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}
	
	
	public void mettreAJourEnchere(Enchere Enchere) {
		// TODO Auto-generated method stub
		
	}
	public void supprimerEnchere(Enchere Enchere) {
		// TODO Auto-generated method stub
	}
	
	
	public List<Enchere> obtenirToutesLesEncheres()  {
		try {Connection connection = ConnectionProvider.getConnection();
		Statement Stmt = connection.createStatement();
		ResultSet rs = Stmt.executeQuery(SELECT_ALL_ENCHERES);
		List<Enchere> Encheres = new ArrayList<>();
				while (rs.next()) {
				
		           Enchere enchere = new Enchere(
		           rs.getDate("date_enchere"),
	                rs.getInt("montant_enchere")
	                );
		            Encheres.add(enchere);
		        }

	return Encheres;
				
	} catch (SQLException e) {
		e.printStackTrace();
	}

		return null;
	}


	@Override
	public void accepterEnchere(Enchere enchere) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void refuserEnchere(Enchere enchere) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void Rencherir(Enchere enchere) {
		// TODO Auto-generated method stub
		
	}




}