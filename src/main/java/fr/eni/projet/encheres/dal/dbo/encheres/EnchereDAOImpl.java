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

	
	public void ajouterEnchere(Enchere Enchere) {
		try {Connection connection = ConnectionProvider.getConnection();
		PreparedStatement pStmt = connection.prepareStatement(INSERT_ENCHERE);
		
		pStmt.setInt(1, Utilisateur.getNoUtilisateur());
		pStmt.setInt(2, Article.getNoArticle());
		pStmt.setDate(3, Enchere.getDateEnchere());
		pStmt.setInt(4, Enchere.getmontantEnchere());
		
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
	public Enchere obtenirEnchereParId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Enchere> obtenirToutesLesEncheres() {
		try {Connection connection = ConnectionProvider.getConnection();
		Statement Stmt = connection.createStatement();
		ResultSet rs = Stmt.executeQuery(SELECT_ALL_ENCHERES);
		List<Enchere> Encheres = new ArrayList<>();
				while (rs.next()) {
				
		            Enchere Enchere = new Enchere(null);

		            // Utilisation des méthodes setter pour définir les valeurs de l'Enchere
		            Enchere.setDateEnchere(rs.getInt("no_Enchere"));
		            Enchere.setMontantEnchere(rs.getString("MontantEnchere"));

		            Encheres.add(Enchere);
		        }

	return Encheres;
				
	} catch (SQLException e) {
		e.printStackTrace();
	}

		return null;
	}
}