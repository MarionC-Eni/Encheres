package fr.eni.projet.encheres.bo;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Date;

public class Article {
	
	private int noArticle;
	private String nomArticle;
	private String description;
	private double prixVente;
	private double miseAPrix;
	private boolean etatVente;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	
	// Constructeur
	
	
	
	public Article(int noArticle, String nomArticle, String description, double prixVente, double miseAPrix,
			boolean etatVente, LocalDate dateDebut, LocalDate dateFin) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.prixVente = prixVente;
		this.miseAPrix = miseAPrix;
		this.etatVente = etatVente;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	public Article() {
		super();
	}

	// Constructeur sans noArticle
	
	public Article(String nomArticle, String description, double prixVente, double miseAPrix, boolean etatVente,
			LocalDate dateDebut, LocalDate dateFin) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.prixVente = prixVente;
		this.miseAPrix = miseAPrix;
		this.etatVente = etatVente;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	// Getter & Setter 
	
	public int getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}
	public double getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(double miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public boolean isEtatVente() {
		return etatVente;
	}
	public void setEtatVente(boolean etatVente) {
		this.etatVente = etatVente;
	}
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	
	// Methode toString
	
	@Override
	public String toString() {
		return "Article [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", prixVente=" + prixVente + ", miseAPrix=" + miseAPrix + ", etatVente=" + etatVente + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + "]";
	}
	
}
	
