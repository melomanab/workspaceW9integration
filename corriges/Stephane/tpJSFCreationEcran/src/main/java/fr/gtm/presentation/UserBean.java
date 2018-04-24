package fr.gtm.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;



import fr.gtm.domaine.Client;
import fr.gtm.service.ServiceClient;

@ManagedBean(name="userbean")
@SessionScoped
public class UserBean {
	
	@ManagedProperty(value="TOTO")
	private String nom;
	
	@ManagedProperty(value="Toto")
	private String prenom;
	
	private String datedenaissance;
	
	@ManagedProperty(value="homme")
	private String genre;
	
	@ManagedProperty(value="participant@objis.com")
	private String email;
	
	private String niveaudeservice;
	
	// Constructeur
	
	public UserBean() {
		super();
	}
	
	// getters et setters
	
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

	
	public Object appelTraitement() {  // la Signature (retour Object) est documentée dans doc JSF commandButton / attribut action
		
		ServiceClient servC = new ServiceClient();
		Client unClient = new Client();
		unClient.setNom(this.getNom());
		unClient.setPrenom(this.getPrenom());
		if (servC.createNewClient(unClient)) {
		return "allGood";
		}
		return "error";
	}
	
}
