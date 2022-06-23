package tn.isimm.pfe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.isimm.pfe.entities.Fournisseurs;
import tn.isimm.pfe.repositories.FournisseursRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/frn")
public class FournisseursController {
	@Autowired
	FournisseursRepository ASSR;

	@GetMapping("AfficherFrn")
	List<Fournisseurs> Afficherts() {
		return ASSR.findAll();
	}

	@PostMapping("AjoutFrn")
	String Ajouter(@RequestBody Fournisseurs Action) {
		ASSR.save(Action);
		return "Fournisseurs Ajouté avec succés";
	} 

	@DeleteMapping("DeleteFrn/{id}")
	String deleteFournisseurs(@PathVariable Long id ) {

		if (ASSR.existsById(id)== false) {
			return "Action n'existe pas" ; 
		}
		
		ASSR.deleteById(id);
		return "Delete Fournisseurs affectué" ; 
	}
	
	@PutMapping("UpdateFrn")
	String update(@RequestBody Fournisseurs Action) {
		Fournisseurs f = ASSR.findById(Action.getId()).get();

		if(Action.getAdresse()!="") {f.setAdresse(Action.getAdresse());}
		if(Action.getCodeF()!="") {f.setCodeF(Action.getCodeF());}
		if(Action.getEmail()!="") {f.setEmail(Action.getEmail());}
		if(Action.getFax()!="") {f.setFax(Action.getFax());}
		if(Action.getNumTel()!="") {f.setNumTel(Action.getNumTel());}
		if(Action.getPays()!="") {f.setPays(Action.getPays());}
		if(Action.getTypeF()!="") {f.setTypeF(Action.getTypeF());}
		
		ASSR.save(f);
		return "Fournisseur updated avec succés";
	}
	
	/* 
	 {
	    "id": 1,
	    "codeF": "reggui",
	    "email": "f@f.f",
	    "typeF": "grossiste",
	    "numTel": "0000000",
	    "fax": "0000000",
	    "pays": "tunisie",
	    "adresse": "gabes"
	}
	*/
}
