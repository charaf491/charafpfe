package tn.isimm.pfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Fournisseurs{

	@Id
	@GeneratedValue
	private Long id ;
	private String codeF;
	private String email ;
	private String typeF ;
	private String numTel;
	private String fax ;
	private String pays ;
	private String adresse ;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodeF() {
		return codeF;
	}
	public void setCodeF(String codeF) {
		this.codeF = codeF;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTypeF() {
		return typeF;
	}
	public void setTypeF(String typeF) {
		this.typeF = typeF;
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
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
}
