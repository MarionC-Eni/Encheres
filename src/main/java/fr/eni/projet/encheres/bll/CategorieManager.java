package fr.eni.projet.encheres.bll;

import fr.eni.projet.encheres.bo.Categorie;
import fr.eni.projet.encheres.dal.dbo.categorie.DAOCategorie;
import fr.eni.projet.encheres.dal.dbo.categorie.DaoFactory;
import fr.eni.projet.encheres.BusinessException;
import java.util.List;

public class CategorieManager {

    private DAOCategorie daoCategorie;

    public CategorieManager() {
        daoCategorie = DaoFactory.getAdao();
    }

    // Méthode pour ajouter une nouvelle catégorie
    public Categorie ajouterCategorie(String libelle) throws BusinessException {
        try {
        	
            // Vérifier si la catégorie existe déjà
            List<Categorie> categories = daoCategorie.obtenirToutesLesCategories();
            for (Categorie categorie : categories) {
                if (categorie.getLibelle().equalsIgnoreCase(libelle)) {
                    throw new BusinessException("Cette catégorie existe déjà.");
                }
            }

            // Créer la nouvelle catégorie et l'ajouter à la base de données
            Categorie nouvelleCategorie = new Categorie(libelle);
            daoCategorie.ajouterCategorie(nouvelleCategorie);
            return nouvelleCategorie;
        } catch (Exception e) {
            throw new BusinessException("Erreur lors de l'ajout de la catégorie : " + e.getMessage());
        }
    }

    // Méthode pour récupérer une catégorie par son identifiant
    public Categorie getCategorieById(int noCategorie) throws BusinessException {
        try {
            return daoCategorie.obtenirCategorieParId(noCategorie);
        } catch (Exception e) {
            throw new BusinessException("Erreur lors de la récupération de la catégorie : " + e.getMessage());
        }
    }

    // Méthode pour mettre à jour une catégorie
    public void mettreAJourCategorie(Categorie categorie) throws BusinessException {
        try {
            // Vérifier si la catégorie existe déjà
            List<Categorie> categories = daoCategorie.obtenirToutesLesCategories();
            boolean categorieExiste = false;
            for (Categorie c : categories) {
                if (c.getNoCategorie() == categorie.getNoCategorie()) {
                    categorieExiste = true;
                    break;
                }
            }
            if (!categorieExiste) {
                throw new BusinessException("Cette catégorie n'existe pas.");
            }

            // Mettre à jour la catégorie dans la base de données
            daoCategorie.mettreAJourCategorie(categorie);
        } catch (Exception e) {
            throw new BusinessException("Erreur lors de la mise à jour de la catégorie : " + e.getMessage());
        }
    }

    // Méthode pour supprimer une catégorie
    public void supprimerCategorie(int noCategorie) throws BusinessException {
        try {
            // Vérifier si la catégorie existe avant de la supprimer
            Categorie categorie = daoCategorie.obtenirCategorieParId(noCategorie);
            if (categorie == null) {
                throw new BusinessException("Cette catégorie n'existe pas.");
            }

            // Supprimer la catégorie de la base de données
            daoCategorie.supprimerCategorie(categorie);
        } catch (Exception e) {
            throw new BusinessException("Erreur lors de la suppression de la catégorie : " + e.getMessage());
        }
    }
}
