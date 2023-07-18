package fr.eni.projet.encheres.bo;


import java.time.LocalDateTime;

public class Enchere {
	private LocalDateTime dateEnchere;
	private int montant_enchere;
	
	public Enchere(LocalDateTime dateEnchere, int montant_enchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
	}

	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [dateEnchere=");
		builder.append(dateEnchere);
		builder.append(", montant_enchere=");
		builder.append(montant_enchere);
		builder.append("]");
		return builder.toString();
	} 
	
	
}