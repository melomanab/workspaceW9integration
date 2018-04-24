package com.objis.formationjsf.domaine;

public class User {

	private String nom;

	private String prenom;
	
	private String datedenaissance;
	
	private String genre;
	
	private String email;
	
	private String niveaudeservice;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDatedenaissance() {
		return datedenaissance;
	}

	public void setDatedenaissance(String datedenaissance) {
		this.datedenaissance = datedenaissance;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNiveaudeservice() {
		return niveaudeservice;
	}

	public void setNiveaudeservice(String niveaudeservice) {
		this.niveaudeservice = niveaudeservice;
	}

	@Override
	public String toString() {
		return "User [nom=" + nom + ", prenom=" + prenom + ", datedenaissance=" + datedenaissance + ", genre=" + genre
				+ ", email=" + email + ", niveaudeservice=" + niveaudeservice + "]";
	}


	
}
