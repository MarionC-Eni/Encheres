package fr.eni.projet.encheres.bo;

public class Credit {
	
	private String pseudo;
	private int noUtilisateur;
	private double noCredit;
	
	
	// Constructeur
	
	public Credit(String pseudo, int noUtilisateur, double noCredit) {
		this.pseudo = pseudo;
		this.noUtilisateur = noUtilisateur;
		this.noCredit = noCredit;
	}
	
	
	// Constructeur sans noUtilisateur et noCredit
	
	public Credit(String pseudo) {
		this.pseudo = pseudo;
	}
	
	// Getter & Setter 
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	public double getNoCredit() {
		return noCredit;
	}
	public void setNoCredit(double noCredit) {
		this.noCredit = noCredit;
	}
	
	// Methode toString
	
	@Override
	public String toString() {
		return "Credit [pseudo=" + pseudo + ", noUtilisateur=" + noUtilisateur + ", noCredit=" + noCredit + "]";
	}
	
	
	

}
