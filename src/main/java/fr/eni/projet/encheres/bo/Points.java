package fr.eni.projet.encheres.bo;

public class Points {
	
	private int noUtilisateur;
	private String pseudo;
	private int noPoints;
	
	
	// Constructeur sans noPoints et noUtilisateur
	
	public Points(String pseudo) {
		this.pseudo = pseudo;
	}
	
	// Constructeur 
	
	public Points(int noUtilisateur, String pseudo, int noPoints) {
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.noPoints = noPoints;
	}
	
	// Getter & Setter
	
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
	public int getNoPoints() {
		return noPoints;
	}
	public void setNoPoints(int noPoints) {
		this.noPoints = noPoints;
	}
	
	// Methode toString
	
	@Override
	public String toString() {
		return "Points [noUtilisateur=" + noUtilisateur + ", pseudo=" + pseudo + ", noPoints=" + noPoints + "]";
	}

}
