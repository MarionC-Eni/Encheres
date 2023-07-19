package fr.eni.projet.encheres.dal.test;


import fr.eni.projet.encheres.bo.Article;
import fr.eni.projet.encheres.dal.dbo.articles.ADAOArticle;
import fr.eni.projet.encheres.dal.dbo.articles.DaoFactory;

public class App {

	public static void main(String[] args) {

		
		ADAOArticle adao1 = DaoFactory.getAdao();
		Article y = new Article(1, "Lampe", "blanche", 10, 9, false, null, null);
		adao1.ajouterArticle(y);
		
		/** ADAOArticle adao2 = DaoFactory.getAdao();
		Article x = new Article("Ordinateur", "Dell");
		adao2.ajouterArticle(x);
		*/
	
		
/**		ADAOArticle adao = DaoFactory.getAdao();
		System.out.println(adao.obtenirTousLesArticles());
	
*/
	}


}
