package fr.eni.projet.encheres.ihm;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.encheres.bo.Utilisateur;
import fr.eni.projet.encheres.dal.dbo.utilisateur.DAOUtilisateur;
import fr.eni.projet.encheres.dal.dbo.utilisateur.DaoFactory;

/**
 * Servlet implementation class TestBdd
 */
@WebServlet("/TestBdd2")
public class TestBdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestBdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/** DAOArticle adao1 = DaoFactory.getAdao();
		LocalDate dateDebut = LocalDate.of(2023, 7, 19); 
	    LocalDate dateFin = LocalDate.of(2023, 7, 20); 
		Article y = new Article(1, "Lampe", "blanche", 9.0, 8.0, true, dateDebut, dateFin);
		adao1.ajouterArticle(y);
		*/
		
	/** 	DAOUtilisateur adao1 = (DAOUtilisateur) DaoFactory.getAdao();
		Utilisateur y = new Utilisateur("ZANALIA", "NICOLAS", "nicolas@gmail.com", "0695063302", "2 rue Bisounours", 44300, "Nantes", "admin2023", 150, false);
		adao1.ajouterUtilisateur(y);
		
	}
	
	*/
		
		DAOUtilisateur adao1 = (DAOUtilisateur) DaoFactory.getDAOUtilisateur();
		Utilisateur y = new Utilisateur ("ZANALIA","COUDERT", "NICOLAS", "nicolas@gmail.com", "0695063302", "2 rue Bisounours", 44300, "Nantes", "admin2023", 150, false);
		adao1.ajouterUtilisateur(y);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
