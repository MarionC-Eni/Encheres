package fr.eni.projet.encheres.dal.dbo.utilisateur;

import java.sql.CallableStatement;
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
	private static final String UPDATE_USER = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ? WHERE no_utilisateur = ?";
	private static final String DELETE_USER = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
	private static final String SELECT_ONE_USER = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
	private static final String SELECT_BY_IDENTIFIANT = "SELECT * FROM utilisateurs WHERE email = ? AND mot_de_passe = ?";


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
		pStmt.setBoolean(11, utilisateur.isAdministrateur());

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

		try {Connection connection = ConnectionProvider.getConnection();
		PreparedStatement pStmt = connection.prepareStatement(UPDATE_USER);

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
		pStmt.setBoolean(11, utilisateur.isAdministrateur());
		pStmt.setInt(12, utilisateur.getNoUtilisateur());

		pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void supprimerUtilisateurById(int noUtilisateur) {
		// TODO Auto-generated method stub

		try {Connection connection = ConnectionProvider.getConnection();
		PreparedStatement pStmt = connection.prepareStatement(DELETE_USER);

	/** Je n'ai besoin que du numero utilsiateur pour le supprier :
	 * 	pStmt.setString(1, utilisateur.getPseudo());
		pStmt.setString(2, utilisateur.getNom());
		pStmt.setString(3, utilisateur.getPrenom());
		pStmt.setString(4, utilisateur.getEmail());
		pStmt.setString(5, utilisateur.getTelephone()); // Truncate 'telephone' value if necessary
		pStmt.setString(6, utilisateur.getRue());
		pStmt.setInt(7, utilisateur.getCodePostal());
		pStmt.setString(8, utilisateur.getVille());
		pStmt.setString(9, utilisateur.getMotDePasse());
		pStmt.setInt(10, utilisateur.getCredit());
		pStmt.setBoolean(11, utilisateur.isAdministrateur());
		
		*/
		pStmt.setInt(1, noUtilisateur);

		pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
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
			utilisateur.setAdministrateur(rs.getBoolean("administrateur"));

			utilisateurs.add(utilisateur);
		}

		return utilisateurs;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

		
	public Utilisateur obtenirUtilisateurParId(int noUtilisateur) {
		
		
		Utilisateur utilisateur = null;

	    try {
	        Connection connection = ConnectionProvider.getConnection();        
	        PreparedStatement cstmt = connection.prepareStatement(SELECT_ONE_USER);
	        cstmt.setInt(1, noUtilisateur);
	        ResultSet rs = cstmt.executeQuery();
	        // La méthode rs.next() est appelée pour 
	        // avancer le curseur du ResultSet vers la première ligne (s'il y en a une)
	        if (rs.next()) {
	            utilisateur = new Utilisateur();
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
	            utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	return utilisateur;
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
			String query = "SELECT COUNT(*) AS count FROM UTILISATEURS WHERE email = ?";
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


	


	
	public Utilisateur seConnecter(String email, String motDePasse) {
		    try {
		    	Connection connection = ConnectionProvider.getConnection();
		    	PreparedStatement pStmt = connection.prepareStatement(SELECT_BY_IDENTIFIANT);
		        pStmt.setString(1, email);
		        pStmt.setString(2, motDePasse);
		        ResultSet rs = pStmt.executeQuery();

		        // Vérifier si l'utilisateur a été trouvé dans la base de données
		        if (rs.next()) {
		            // Créer un objet Utilisateur avec les informations de la base de données
		            Utilisateur u = new Utilisateur();
		            u.setNoUtilisateur(rs.getInt("no_utilisateur"));
		            u.setPseudo(rs.getString("pseudo"));
		           u.setNom(rs.getString("nom"));
		           u.setPrenom(rs.getString("prenom"));
		            u.setEmail(rs.getString("email"));
		           u.setTelephone(rs.getString("telephone"));
		            u.setRue(rs.getString("rue"));
		            u.setCodePostal(rs.getInt("code_postal"));
		           u.setVille(rs.getString("ville"));
		           u.setMotDePasse(rs.getString("mot_de_passe"));
		           u.setCredit(rs.getInt("credit"));
		           u.setAdministrateur(rs.getBoolean("administrateur"));
		           return u ; } 		          
		    } catch (SQLException e) {
		        // Gérer les erreurs éventuelles
		        e.printStackTrace();
		    }
		    
		   return null ;
	}
}

	






	