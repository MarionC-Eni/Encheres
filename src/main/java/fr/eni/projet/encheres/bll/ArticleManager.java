package fr.eni.projet.encheres.bll;

import java.time.LocalDate;
import java.util.List;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bo.Article;
import fr.eni.projet.encheres.bo.Categorie;
import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.dbo.articles.DAOArticle;
import fr.eni.projet.encheres.dal.dbo.articles.DaoFactory;
import fr.eni.projet.encheres.dal.dbo.utilisateur.DAOUtilisateur;
import fr.eni.projet.encheres.dal.exception.DALException;

public class ArticleManager {

	private final DAOArticle DAOArticle ;
	
	// Constructeur BLL qui créer une instance de DAOArticle pour faire appel a la classe DaoFactory
	public ArticleManager() {
        this.DAOArticle = DaoFactory.getDAOArticle();
    }
	
    // Ajouter un article
	public void ajouterArticle(String nomArticle, String description, double prixVente, double miseAPrix, boolean etatVente, LocalDate dateDebut, LocalDate dateFin, Utilisateur utilisateur, Categorie categorie)  throws BusinessException, DALException {
        DAOArticle articleDao = DaoFactory.getDAOArticle();
        
        /** // on a essayé de relier les 2 DaoFactory pour récupérer la clé étrangère
        try {
			try {
				DAOUtilisateur utilisateurDao = DaoFactory.getDAOUtilisateur();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        */
        
        

        try {
        	
        	/**
        	test >> // Récupérer le numéro d'utilisateur (clé étrangère)
            Utilisateur utilisateur;

			try {
				utilisateur = DAOUtilisateur.obtenirUtilisateurParId(noUtilisateur);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
      
        	Article a = new Article(); 
        	a.setNomArticle(nomArticle);
        	a.setDescription(description);
        	a.setPrixVente(prixVente);
        	a.setMiseAPrix(miseAPrix);
        	a.setEtatVente(etatVente);
        	a.setDateDebut(dateDebut);
        	a.setDateFin(dateFin);
        	
            //  validerArticle(article); Nous ferons ça plus tard

        	// ArticleManager utilise l'objet Utilisateur comme paramètre dans la méthode ajouterArticle
        	// c'est nécessaire pour passer directement l'objet Utilisateur depuis la servlet.
        	  	
            DAOArticle.ajouterArticle(a, utilisateur, categorie);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Probleme dans l'ajout à la bdd!");
        }
    }
    
    // Valider un article
   /** private void validerArticle(Article article) throws BusinessException {
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
    }*/

    // Supprimer un article
    public void supprimerArticle1ParId(int noArticle) throws BusinessException, DALException {
        // Vous pouvez ajouter des validations ou vérifications ici si nécessaire
       // DAOArticle articleDao = DaoFactory.getDAOArticle();
        try {
             DAOArticle.supprimerArticle1ParId(noArticle);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Probleme dans la suppression de l'article!");
        }
    }
    public Article obtenirArticleParId(int noArticle) throws BusinessException, DALException  {
    	// DAOArticle articleDao = DaoFactory.getDAOArticle();
         try {
             return DAOArticle.obtenirArticleParId(noArticle);
         } catch (Exception e) {
             e.printStackTrace();
             throw new DALException("Erreur lors de l'affichage de l'article!");
         }
    	
    }
/*
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
    
	
    
*/
   
}