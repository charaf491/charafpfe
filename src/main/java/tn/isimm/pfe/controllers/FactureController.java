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

import tn.isimm.pfe.entities.Facture;
import tn.isimm.pfe.repositories.FactureRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/facture")
public class FactureController {
	@Autowired
	FactureRepository ASSR;

	@GetMapping("AfficherFactures")
	List<Facture> Afficherts() {
		return ASSR.findAll();
	}

	@PostMapping("AjoutFacture")
	String Ajouter(@RequestBody Facture Action) { ASSR.save(Action); return "Facture Ajouté avec succés"; }

	@DeleteMapping("DeleteFacture/{id}")
	String deleteFacture(@PathVariable Long id ) {

		if (ASSR.existsById(id)== false) {
			return "Action n'existe pas" ; 
		}
		
		ASSR.deleteById(id);
		return "Delete Facture affectué" ; 
	}
	
	@PutMapping("UpdateFacture")
	String update(@RequestBody Facture Action) {
		Facture f = ASSR.findById(Action.getId()).get();

		if(Action.getMarjaaelfatoura()!="") {f.setMarjaaelfatoura(Action.getMarjaaelfatoura());}
		f.setPrix(Action.getPrix());

		ASSR.save(f);
		return "Facture updated avec succés";
	}
}
