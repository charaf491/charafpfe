package tn.isimm.pfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Produits {
	
	@Id
	@GeneratedValue
	private Long id ;
	private String codeAbar ;
	private String marque ;
	private String couleur ;
	private String taille ;
	private String etat ;

	private String type ;

	private String prixUnitaire ;
	private String minQuant ;
	private String currentQuant ;
	private String TVA ;
	
	/*
	private String idFournisseur ;
	private String idMagasin ;
	private String idCategorie ;
	private String idSousCategorie ;
	*/
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodeAbar() {
		return codeAbar;
	}
	public void setCodeAbar(String codeAbar) {
		this.codeAbar = codeAbar;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(String prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public String getMinQuant() {
		return minQuant;
	}
	public void setMinQuant(String minQuant) {
		this.minQuant = minQuant;
	}
	public String getCurrentQuant() {
		return currentQuant;
	}
	public void setCurrentQuant(String currentQuant) {
		this.currentQuant = currentQuant;
	}
	public String getTVA() {
		return TVA;
	}
	public void setTVA(String tVA) {
		TVA = tVA;
	}
	
}
