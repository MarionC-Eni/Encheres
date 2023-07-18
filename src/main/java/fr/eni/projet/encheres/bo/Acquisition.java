package fr.eni.projet.encheres.bo;

import java.time.LocalDateTime;

public class Acquisition {
	
	private int noArticle;
	private double prixVente;
	private String vendeur;
	private int noUtilisateur;
	private String pseudo;
	private LocalDateTime date;
	
	// Constructeurs
	
	public Acquisition(int noArticle, double prix, String vendeur, int noUtilisateur, String pseudo,
			LocalDateTime date) {
		
		this.noArticle = noArticle;
		this.prixVente = prixVente;
		this.vendeur = vendeur;
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.date = date;
	}
	
	// Constructeur sans noUtilisateur et noArticle
	
	public Acquisition(double prix, String vendeur, String pseudo, LocalDateTime date) {
		super();
		this.prixVente = prixVente;
		this.vendeur = vendeur;
		this.pseudo = pseudo;
		this.date = date;
	}



	// Getter & Setter

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public double getPrixVente() {
		return prixVente;
	}

	public void setPrix(double prixVente) {
		this.prixVente = prixVente;
	}

	public String getVendeur() {
		return vendeur;
	}

	public void setVendeur(String vendeur) {
		this.vendeur = vendeur;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	// Methode toString
	
	@Override
	public String toString() {
		return "Acquisition [noArticle=" + noArticle + ", prixVente=" + prixVente + ", vendeur=" + vendeur + ", noUtilisateur="
				+ noUtilisateur + ", pseudo=" + pseudo + ", date=" + date + "]";
	}
	
	
	
	
	
	


}
