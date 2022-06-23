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

import tn.isimm.pfe.entities.SousCategorie;
import tn.isimm.pfe.repositories.SousCategorieRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/subCategory")
public class SousCategorieController {
	@Autowired
	SousCategorieRepository ASSR;

	@GetMapping("AfficherSousCategories")
	List<SousCategorie> Afficherts() {
		return ASSR.findAll();
	}

	@PostMapping("AjoutSousCategorie")
	String Ajouter(@RequestBody SousCategorie Action) {
		ASSR.save(Action);
		return "SousCategorie Ajouté avec succés";
	}
 
	@DeleteMapping("DeleteSousCategorie/{id}")
	String deleteSousCategorie(@PathVariable Long id ) {
		if (ASSR.existsById(id)== false) {
			return "Action n'existe pas" ; 
		}
		
		ASSR.deleteById(id);
		return "Delete SousCategorie affectué" ; 
	}
	
	@PutMapping("UpdateSousCat")
	String update(@RequestBody SousCategorie Action) {
		SousCategorie f = ASSR.findById(Action.getId()).get();

		if(Action.getDesignation()!="") {f.setDesignation(Action.getDesignation());}
		
		ASSR.save(f);
		return "Sous categorie updated avec succés";
	}
}
