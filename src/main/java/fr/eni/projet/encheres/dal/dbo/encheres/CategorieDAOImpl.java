package fr.eni.projet.encheres.dal.dbo.encheres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.encheres.bo.Categorie;
import fr.eni.projet.encheres.dal.ConnectionProvider;

public class CategorieDAOImpl implements DAOCategorie {

	private static final String INSERT_CATEGORIE = "INSERT INTO CATEGORIES (libelle) VALUES (?)";
	private static final String SELECT_ALL_CATEGORIES = "SELECT * FROM CATEGORIES";

	
	public void ajouterCategorie(Categorie Categorie) {
		try {Connection connection = ConnectionProvider.getConnection();
		PreparedStatement pStmt = connection.prepareStatement(INSERT_CATEGORIE);
		
		pStmt.setString(1, Categorie.getLibelle());
		
		pStmt.executeUpdate();
/**
 * System.out.printf("La Categorie %s a bien été ajoutée", Categorie.getNom()););	// phase de test : on affiche pas cette ligne	
 */
		
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}
	
	
	public void mettreAJourCategorie(Categorie Categorie) {
		// TODO Auto-generated method stub
		
	}
	public void supprimerCategorie(Categorie Categorie) {
		// TODO Auto-generated method stub
		
	}
	public Categorie obtenirCategorieParId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Categorie> obtenirToutesLesCategories() {
		try {Connection connection = ConnectionProvider.getConnection();
		Statement Stmt = connection.createStatement();
		ResultSet rs = Stmt.executeQuery(SELECT_ALL_CATEGORIES);
		List<Categorie> Categories = new ArrayList<>();
				while (rs.next()) {
				
		            Categorie Categorie = new Categorie(null);

		            // Utilisation des méthodes setter pour définir les valeurs de l'Categorie
		            Categorie.setNoCategorie(rs.getInt("no_Categorie"));
		            Categorie.setLibelle(rs.getString("libelle"));

		            Categories.add(Categorie);
		        }

	return Categories;
				
	} catch (SQLException e) {
		e.printStackTrace();
	}

		return null;
	}
}