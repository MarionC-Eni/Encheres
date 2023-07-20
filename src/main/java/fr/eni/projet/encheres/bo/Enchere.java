package fr.eni.projet.encheres.bo;


import java.sql.Date;

public class Enchere {
	private Date dateEnchere;
	private int montantEnchere;

	
	public Enchere(Date dateEnchere, int montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date date) {
		this.dateEnchere = date;
	}

	public int getmontantEnchere() {
		return montantEnchere;
	}

	public void setmontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [dateEnchere=");
		builder.append(dateEnchere);
		builder.append(", montantEnchere=");
		builder.append(montantEnchere);
		builder.append("]");
		return builder.toString();
	} 
	
	
}