package fr.eni.projet.encheres.bll;

import java.util.List;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bo.Article;
import fr.eni.projet.encheres.dal.dbo.articles.DAOArticle;
import fr.eni.projet.encheres.dal.dbo.articles.DaoFactory;
import fr.eni.projet.encheres.dal.exception.DALException;

public class ArticleManager {

    // Ajouter un article
    public void ajouterArticle(Article article) throws BusinessException, DALException {
        validerArticle(article);
        DAOArticle articleDao = DaoFactory.getDAOArticle();
        try {
            articleDao.ajouterArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Probleme dans l'ajout à la bdd!");
        }
    }
    
    // Valider un article
    private void validerArticle(Article article) throws BusinessException {
        if (article == null) {
            throw new BusinessException("L'objet Article est null!");
        }

        if (article.getNomArticle() == null || article.getNomArticle().isBlank()) {
            throw new BusinessException("Le champ Titre est obligatoire!");
        }

        if (article.getPrixVente() == 0) {
            throw new BusinessException("Le champ Prix est obligatoire!");
        }
        // Ajoutez d'autres validations si nécessaire
    }

    // Modifier un article
    public void mettreAJourArticle(Article article) throws BusinessException, DALException {
        // Validation
        validerArticle(article);
        DAOArticle articleDao = DaoFactory.getDAOArticle();
        try {
            articleDao.mettreAJourArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Probleme dans la modification de l'article!");
        }
    }

    // Supprimer un article
    public void supprimerArticle(int noArticle) throws BusinessException, DALException {
        // Vous pouvez ajouter des validations ou vérifications ici si nécessaire
        DAOArticle articleDao = DaoFactory.getDAOArticle();
        try {
            articleDao.supprimerArticle(noArticle);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Probleme dans la suppression de l'article!");
        }
    }

    // Lister les articles d'un utilisateur
    public List<Article> obtenirTousLesArticles(int noUtilisateur) throws BusinessException, DALException {
        // Vous pouvez ajouter des validations ou vérifications ici si nécessaire
        DAOArticle articleDao = DaoFactory.getDAOArticle();
        try {
            return articleDao.obtenirTousLesArticles(noUtilisateur);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Probleme lors de la récupération des articles!");
        }
    }
    
	
    

   
}