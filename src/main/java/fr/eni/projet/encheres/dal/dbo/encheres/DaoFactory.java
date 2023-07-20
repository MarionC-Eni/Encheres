package fr.eni.projet.encheres.dal.dbo.encheres;

import fr.eni.projet.encheres.dal.dbo.categorie.DAOCategorie;
import fr.eni.projet.encheres.dal.dbo.categorie.CategorieDAOImpl;


public abstract class DaoFactory {

	public static DAOCategorie getAdao() {
		return new CategorieDAOImpl();
	}
}