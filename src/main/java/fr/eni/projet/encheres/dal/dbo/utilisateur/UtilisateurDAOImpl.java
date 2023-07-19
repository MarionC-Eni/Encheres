package fr.eni.projet.encheres.dal.dbo.utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.ConnectionProvider;

public class UtilisateurDAOImpl implements ADAOUtilisateur {

	private static final String INSERT_USER = "INSERT INTO utilisateurs (nom, mail) VALUES (?,?)";
	private static final String SELECT_ALL_USERS = "SELECT * FROM utilisateurs";

	
	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		try {Connection connection = ConnectionProvider.getConnection();
		PreparedStatement pStmt = connection.prepareStatement(INSERT_USER);
		
		pStmt.setString(1, utilisateur.getNom());
		pStmt.setString(2, utilisateur.getEmail());
		pStmt.executeUpdate();
		System.out.println("L'utilisateur %s a bien été ajouté");		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}
	@Override
	public void mettreAJourUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void supprimerUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Utilisateur obtenirUtilisateurParId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Utilisateur> obtenirTousLesUtilisateurs() {
		try {Connection connection = ConnectionProvider.getConnection();
		Statement Stmt = connection.createStatement();
		ResultSet rs = Stmt.executeQuery(SELECT_ALL_USERS);
		List<Utilisateur> utilisateurs = new ArrayList<>();
				while (rs.next()) {
					utilisateurs.add(
							new Utilisateur( 
							rs.getInt("no_utilisateur"),
							rs.getString("nom"),
							rs.getString("email"), null, null, 0, null, 0, null, null, 0, false
							)
					);
				}
					
	return utilisateurs;
				
	} catch (SQLException e) {
		e.printStackTrace();
	}

		return null;
	}
}