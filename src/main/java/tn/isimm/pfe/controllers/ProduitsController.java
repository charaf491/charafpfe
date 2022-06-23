package tn.isimm.pfe.controllers;

import java.util.List;

import java.util.Optional;

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

import tn.isimm.pfe.entities.Produits;
import tn.isimm.pfe.repositories.ProduitsRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/produit")
public class ProduitsController {
	@Autowired
	ProduitsRepository ASSR;

	@GetMapping("AfficherProduits")
	List<Produits> Afficherts() {
		return ASSR.findAll();
	}

	@PostMapping("AjoutProduit")
	String Ajouter(@RequestBody Produits Action) {
		ASSR.save(Action);
		return "Produits Ajouté avec succés";
	}

	@DeleteMapping("DeleteProduit/{id}")
	String deleteProduits(@PathVariable Long id ) {
		if (ASSR.existsById(id)== false) {
			return "Action n'existe pas" ; 
		}
		
		ASSR.deleteById(id);
		return "Delete Produits affectué" ; 
	}
	
	@GetMapping("AfficherProduitById/{id}")
	Optional<Produits> AffichertsById(@PathVariable Long id) {
		return ASSR.findById(id);
	}
	
	@PutMapping("UpdateProduit")
	String update(@RequestBody Produits Action) {
		Produits f = ASSR.findById(Action.getId()).get();

		if(Action.getTVA()!="") {f.setTVA(Action.getTVA());}
		if(Action.getCodeAbar()!="") {f.setCodeAbar(Action.getCodeAbar());}
		if(Action.getCouleur()!="") {f.setCouleur(Action.getCouleur());}
		if(Action.getCurrentQuant()!="") {f.setCurrentQuant(Action.getCurrentQuant());}
		if(Action.getEtat()!="") {f.setEtat(Action.getEtat());}
		if(Action.getMarque()!="") {f.setMarque(Action.getMarque());}
		if(Action.getMinQuant()!="") {f.setMinQuant(Action.getMinQuant());}
		if(Action.getTaille()!="") {f.setTaille(Action.getTaille());}
		if(Action.getType()!="") {f.setType(Action.getType());}
		f.setPrixUnitaire(Action.getPrixUnitaire());
		
		ASSR.save(f);
		return "Produit updated avec succés";
	}
}
