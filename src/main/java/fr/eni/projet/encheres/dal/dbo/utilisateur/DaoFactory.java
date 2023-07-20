package fr.eni.projet.encheres.dal.dbo.utilisateur;

public abstract class DaoFactory {

	public static DAOUtilisateur getDAOUtilisateur() {
		return new UtilisateurDAOImpl();
	}
}