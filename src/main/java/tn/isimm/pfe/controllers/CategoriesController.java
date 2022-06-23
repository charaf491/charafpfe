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

import tn.isimm.pfe.entities.Categories;
import tn.isimm.pfe.repositories.CategoriesRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoriesController {

	@Autowired
	CategoriesRepository ASSR;

	@GetMapping("AfficherCategories")
	List<Categories> Afficherts() {
		return ASSR.findAll();
	}

	@PostMapping("AjoutCategory")
	String Ajouter(@RequestBody Categories Action) {
		ASSR.save(Action);
		return "Categories Ajouté avec succés";
	}

	@DeleteMapping("DeleteCategory/{id}")
	String deleteCategories(@PathVariable Long id ) {
		if (ASSR.existsById(id)== false) {
			return "Action n'existe pas" ; 
		}
		
		ASSR.deleteById(id);
		return "Delete Categories affectué" ; 
	}
	
	@PutMapping("UpdateCategory")
	String update(@RequestBody Categories Action) {
		Categories f = ASSR.findById(Action.getId()).get();

		if(Action.getDesignation()!="") {f.setDesignation(Action.getDesignation());}
		
		ASSR.save(f);
		return "Categorie updated avec succés";
	}
}
