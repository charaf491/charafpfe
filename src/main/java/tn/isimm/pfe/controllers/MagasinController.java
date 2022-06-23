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

import tn.isimm.pfe.entities.Magasin;
import tn.isimm.pfe.repositories.MagasinRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/magasin")
public class MagasinController {
	@Autowired
	MagasinRepository ASSR;

	@GetMapping("AfficherMagasin")
	List<Magasin> Afficherts() {
		return ASSR.findAll();
	}

	@PostMapping("AjoutMagasin")
	String Ajouter(@RequestBody Magasin Action) {
		ASSR.save(Action);
		return "Magasin Ajouté avec succés";
	}

	@DeleteMapping("DeleteMagasin/{id}")
	String deleteMagasin(@PathVariable Long id ) {
		if (ASSR.existsById(id)== false) {
			return "Action n'existe pas" ; 
		}
		
		ASSR.deleteById(id);
		return "Delete Magasin affectué" ; 
	}
	
	@PutMapping("UpdateMagasin")
	String update(@RequestBody Magasin Action) {
		Magasin f = ASSR.findById(Action.getId()).get();

		if(Action.getAdresse()!="") {f.setAdresse(Action.getAdresse());}
		if(Action.getAmin()!="") {f.setAmin(Action.getAmin());}
		if(Action.getDesignation()!="") {f.setDesignation(Action.getDesignation());}
		if(Action.getFax()!="") {f.setFax(Action.getFax());}
		if(Action.getNumTel()!="") {f.setNumTel(Action.getNumTel());}

		ASSR.save(f);
		return "Magasin updated avec succés";
	}
}
