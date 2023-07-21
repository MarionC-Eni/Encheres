package fr.eni.projet.encheres.bll;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bo.Article;
import fr.eni.projet.encheres.bo.Enchere;
import fr.eni.projet.encheres.dal.dbo.articles.DAOArticle;
import fr.eni.projet.encheres.dal.dbo.articles.DaoFactory;
import fr.eni.projet.encheres.dal.dbo.encheres.DAOEnchere;
import fr.eni.projet.encheres.dal.exception.DALException;

public class EnchereManager {

    private DAOArticle articleDao;
    private DAOEnchere enchereDao;

    public EnchereManager() {
        articleDao = DaoFactory.getDAOArticle();
        enchereDao = fr.eni.projet.encheres.dal.dbo.encheres.DaoFactory.getDAOEnchere();
    }

    // Proposer son article à la vente
    public void proposerArticleVente(Article article) throws BusinessException {
        // Ajoutez ici la logique pour valider l'article à vendre, par exemple :
    	
    	
        // Vérification des champs obligatoires, des valeurs valides, etc.
        // ...

        // Appel à la couche DAL pour ajouter l'article à la base de données
        try {
            articleDao.ajouterArticle(article);
        } catch (Exception e) {
            throw new DALException("Une erreur s'est produite lors de la proposition de l'article à la vente.", e);
        }
    }

    // Faire-créer une enchère
    public void creerEnchere(Enchere enchere) throws BusinessException {
        // Ajoutez ici la logique pour valider l'enchère à créer, par exemple :
        // Vérification des champs obligatoires, des valeurs valides, etc.
        // ...

        // Appel à la couche DAL pour ajouter l'enchère à la base de données
        try {
            enchereDao.ajouterEnchere(enchere);
        } catch (Exception e) {
            throw new DALException("Une erreur s'est produite lors de la création de l'enchère.", e);
        }
    }

    // Accepter l'enchère
    public void accepterEnchere(Enchere enchere) throws BusinessException {
        // Ajoutez ici la logique pour accepter l'enchère, par exemple :
        // Vérification des conditions pour accepter l'enchère
        // ...

        // Appel à la couche DAL pour mettre à jour l'enchère dans la base de données
        try {
            enchereDao.accepterEnchere(enchere);
        } catch (Exception e) {
            throw new DALException("Une erreur s'est produite lors de l'acceptation de l'enchère.", e);
        }
    }

    // Refuser-annuler l'enchère
    public void refuserAnnulerEnchere(Enchere enchere) throws BusinessException {
        // Ajoutez ici la logique pour refuser ou annuler l'enchère, par exemple :
        // Vérification des conditions pour refuser ou annuler l'enchère
        // ...

        // Appel à la couche DAL pour mettre à jour l'enchère dans la base de données
        try {
            enchereDao.refuserAnnulerEnchere(enchere);
        } catch (Exception e) {
            throw new DALException("Une erreur s'est produite lors du refus ou de l'annulation de l'enchère.", e);
        }
    }

    // Renchérir
    public void rencherir(Enchere enchere, int nouveauMontant) throws BusinessException {
        // Ajoutez ici la logique pour renchérir, par exemple :
        // Vérification des conditions pour renchérir (montant supérieur à l'enchère actuelle, etc.)
        // ...

        // Appel à la couche DAL pour mettre à jour l'enchère dans la base de données
        try {
            enchereDao.rencherir(enchere, nouveauMontant);
        } catch (Exception e) {
            throw new BusinessException("Une erreur s'est produite lors du renchérissement.", e);
        }
    }
}