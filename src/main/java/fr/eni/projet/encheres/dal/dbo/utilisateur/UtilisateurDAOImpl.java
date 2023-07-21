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

public class UtilisateurDAOImpl implements DAOUtilisateur {

	private static final String INSERT_USER = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_ALL_USERS = "SELECT * FROM UTILISATEURS";

	
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		try {Connection connection = ConnectionProvider.getConnection();
		PreparedStatement pStmt = connection.prepareStatement(INSERT_USER);
		
		pStmt.setString(1, utilisateur.getPseudo());
		pStmt.setString(2, utilisateur.getNom());
		pStmt.setString(3, utilisateur.getPrenom());
		pStmt.setString(4, utilisateur.getEmail());
        pStmt.setString(5, utilisateur.getTelephone()); // Truncate 'telephone' value if necessary
		pStmt.setString(6, utilisateur.getRue());
		pStmt.setInt(7, utilisateur.getCodePostal());
		pStmt.setString(8, utilisateur.getVille());
		pStmt.setString(9, utilisateur.getMotDePasse());
		pStmt.setInt(10, utilisateur.getCredit());
		pStmt.setBoolean(11, utilisateur.isadministrateur());
		
		pStmt.executeUpdate();
/**
 * System.out.printf("L'utilisateur %s a bien été ajouté", Utilisateur.getNom()););	// phase de test : on affiche pas cette ligne	
 */
		
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}
	
	
	public void mettreAJourUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}
	public void supprimerUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	public List<Utilisateur> obtenirTousLesUtilisateurs() {
		List<Utilisateur> utilisateurs = new ArrayList<>();

		try {Connection connection = ConnectionProvider.getConnection();
		Statement Stmt = connection.createStatement();
		ResultSet rs = Stmt.executeQuery(SELECT_ALL_USERS);
				while (rs.next()) {
				
		            Utilisateur utilisateur = new Utilisateur(null, null, null, null, null, null, 0, null, null, 0, false);

		            // Utilisation des méthodes setter pour définir les valeurs de l'utilisateur
		            utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
		            utilisateur.setPseudo(rs.getString("pseudo"));
		            utilisateur.setNom(rs.getString("nom"));
		            utilisateur.setPrenom(rs.getString("prenom"));
		            utilisateur.setEmail(rs.getString("email"));
		            utilisateur.setTelephone(rs.getString("telephone"));
		            utilisateur.setRue(rs.getString("rue"));
		            utilisateur.setCodePostal(rs.getInt("code_postal"));
		            utilisateur.setVille(rs.getString("ville"));
		            utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
		            utilisateur.setCredit(rs.getInt("credit"));
		            utilisateur.setadministrateur(rs.getBoolean("administrateur"));

		            utilisateurs.add(utilisateur);
		        }

	return utilisateurs;
				
	} catch (SQLException e) {
		e.printStackTrace();
	}

		return null;
	}
	
	public boolean pseudoExiste(String pseudo) {
		// méthode qui vérifie si un pseudo (passé en paramètre) existe déjà dans la base de données des utilisateurs
	    try {
	        Connection connection = ConnectionProvider.getConnection();
	        String query = "SELECT COUNT(*) AS count FROM UTILISATEURS WHERE pseudo = ?";
	        PreparedStatement pstmt = connection.prepareStatement(query);
	        pstmt.setString(1, pseudo);
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            int count = rs.getInt("count");
	            return count > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public boolean emailExiste(String email) {
		// méthode qui vérifie si un email (passé en paramètre) existe déjà dans la base de données des utilisateurs
	    try {
	        Connection connection = ConnectionProvider.getConnection();
	        String query = "SELECT COUNT(*) AS count FROM UTILISATEURS WHERE pseudo = ?";
	        PreparedStatement pstmt = connection.prepareStatement(query);
	        pstmt.setString(1, email);
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            int count = rs.getInt("count");
	            return count > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}


}