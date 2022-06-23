package tn.isimm.pfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BonDeCommande {
	@Id
	@GeneratedValue
	private Long id ;
	
	public  String type ;
	private float prix;
	private String dateDemission ;
	private int quantite ;
	private String demandeFourniture ;
	
	/*
	private String Destinateur ;
	private String Destinatair ;
	*/
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getDateDemission() {
		return dateDemission;
	}
	public void setDateDemission(String dateDemission) {
		this.dateDemission = dateDemission;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getDemandeFourniture() {
		return demandeFourniture;
	}
	public void setDemandeFourniture(String demandeFourniture) {
		this.demandeFourniture = demandeFourniture;
	}
	
}