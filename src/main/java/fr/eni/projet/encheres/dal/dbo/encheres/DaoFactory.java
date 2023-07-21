package fr.eni.projet.encheres.dal.dbo.encheres;

import fr.eni.projet.encheres.dal.dbo.encheres.DAOEnchere;
import fr.eni.projet.encheres.dal.dbo.encheres.EnchereDAOImpl;


public abstract class DaoFactory {

	public static DAOEnchere getDAOEnchere() {
		return new EnchereDAOImpl();
	}
}