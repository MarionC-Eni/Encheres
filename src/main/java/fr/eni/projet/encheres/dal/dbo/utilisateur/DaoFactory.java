package fr.eni.projet.encheres.dal.dbo.utilisateur;

public abstract class DaoFactory {

	public static ADAOUtilisateur getAdao() {
		return new UtilisateurDAOImpl();
	}
}
