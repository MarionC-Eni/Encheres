package fr.eni.projet.encheres.dal.dbo.utilisateur;

public abstract class DaoFactory {

	/** cette classe est utilisée pour créer des instances d'implémentations concrètes de DAO. 
	 elle fournit la méthode getDAOUtilisateur que l'on utilise dans la bll > utilisateurmanager
	 */
	public static DAOUtilisateur getDAOUtilisateur() {
		return new UtilisateurDAOImpl();
	}
}