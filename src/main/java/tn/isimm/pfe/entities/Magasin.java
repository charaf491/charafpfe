package tn.isimm.pfe.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Magasin {
	@Id 
	@GeneratedValue
	private Long id ;
	private String designation ;

	private String adresse  ;

	private String numTel ;
	private String fax ;
	private String amin ;
	
	//private String mass2oul ;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getAmin() {
		return amin;
	}
	public void setAmin(String amin) {
		this.amin = amin;
	}
		
}
