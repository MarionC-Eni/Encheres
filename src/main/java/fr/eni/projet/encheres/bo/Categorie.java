package fr.eni.projet.encheres.bo;

public class Categorie {

	private static int noCategorie;
	private String libelle;
	
	// Constructeur
	public Categorie(int noCategorie, String libelle) {
		super();
		Categorie.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	
	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	
	// getter and setters
	public static int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		Categorie.noCategorie = noCategorie;
		
	}
	
	
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	

	// tOstring
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categorie [noCategorie=");
		builder.append(noCategorie);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append("]");
		return builder.toString();
	}


}
