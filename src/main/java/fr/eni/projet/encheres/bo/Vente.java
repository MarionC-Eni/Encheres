package fr.eni.projet.encheres.bo;

public class Vente {
	
	private int noVente;

	
	
	public int getNoVente() {
		return noVente;
	}



	public void setNoVente(int noVente) {
		this.noVente = noVente;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vente [noVente=");
		builder.append(noVente);
		builder.append("]");
		return builder.toString();
	}	

	
	
}
