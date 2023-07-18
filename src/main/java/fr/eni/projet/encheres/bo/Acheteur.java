package fr.eni.projet.encheres.bo;

public class Acheteur extends Utilisateur {

	public Acheteur(int noUtilisateur, String pseudo, String nom, String prenom, String email, int telephone,
			String rue, int codePostal, String ville, String motDePasse, int credit, boolean adminsitrateur) {
		super(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, adminsitrateur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Acheteur [getNoUtilisateur()=");
		builder.append(getNoUtilisateur());
		builder.append(", getPseudo()=");
		builder.append(getPseudo());
		builder.append(", getNom()=");
		builder.append(getNom());
		builder.append(", getPrenom()=");
		builder.append(getPrenom());
		builder.append(", getEmail()=");
		builder.append(getEmail());
		builder.append(", getTelephone()=");
		builder.append(getTelephone());
		builder.append(", getRue()=");
		builder.append(getRue());
		builder.append(", getCodePostal()=");
		builder.append(getCodePostal());
		builder.append(", getVille()=");
		builder.append(getVille());
		builder.append(", getMotDePasse()=");
		builder.append(getMotDePasse());
		builder.append(", getCredit()=");
		builder.append(getCredit());
		builder.append(", isAdminsitrateur()=");
		builder.append(isAdminsitrateur());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append("]");
		return builder.toString();
	}



	}

