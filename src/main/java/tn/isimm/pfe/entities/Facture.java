package tn.isimm.pfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Facture {

	@Id
	@GeneratedValue
	private Long id ;
	
	private String marjaaelfatoura ;
	private float prix ;
	
	/*
	private Long idFournisseur ;
	private Long idBonDeCommande ;
	*/
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarjaaelfatoura() {
		return marjaaelfatoura;
	}
	public void setMarjaaelfatoura(String marjaaelfatoura) {
		this.marjaaelfatoura = marjaaelfatoura;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
}
