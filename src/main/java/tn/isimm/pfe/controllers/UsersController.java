package tn.isimm.pfe.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.isimm.pfe.entities.Users;
import tn.isimm.pfe.repositories.UsersRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UsersController {
	@Autowired
	UsersRepository ASSR;

	@GetMapping("AfficherUsers")
	List<Users> Afficherts() {
		return ASSR.findAll();
	}
 
	@GetMapping("AjoutUsers/{nom}/{prenom}/{cin}/{email}/{numTel}/{structure}/{password}/{magasin}/{code}")
	String Ajouter( @PathVariable String nom, @PathVariable String prenom,
			@PathVariable String cin, @PathVariable String email, @PathVariable String numTel,
			@PathVariable String structure, @PathVariable String password, @PathVariable String magasin,
			@PathVariable String code) {
		
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		LocalDateTime now = LocalDateTime.now();  

		Users a = new Users();
		a.setCin(cin);
		a.setCode(code);
		a.setEmail(email);
		a.setNom(nom);
		a.setNumTel(numTel);
		a.setPassword(password);
		a.setPrenom(prenom);
		a.setTmps(now + "");
		
		ASSR.save(a);
		return "Users Ajouté avec succés";
	}
	
	@PutMapping("UpdateProduitUser")
	String update(@RequestBody Users Action) {
		Users f = ASSR.findById(Action.getId()).get();

		if(Action.getCin()!="") {f.setCin(Action.getCin());}
		if(Action.getCode()!="") {f.setCode(Action.getCode());}
		if(Action.getEmail()!="") {f.setEmail(Action.getEmail());}
		if(Action.getNom()!="") {f.setNom(Action.getNom());}
		if(Action.getMarque()!="") {f.setMarque(Action.getMarque());}
		if(Action.getMinQuant()!="") {f.setMinQuant(Action.getMinQuant());}
		if(Action.getTaille()!="") {f.setTaille(Action.getTaille());}
		if(Action.getType()!="") {f.setType(Action.getType());}
		f.setPrixUnitaire(Action.getPrixUnitaire());
		
		ASSR.save(f);
		return "User updated avec succés";
	}

	@DeleteMapping("DeleteUsers/{id}")
	String deleteUsers(@PathVariable Long id) {
		if (ASSR.existsById(id) == false) {
			return "Action n'existe pas";
		}

		ASSR.deleteById(id);
		return "Delete Users affectué";
	}
	
	@GetMapping("Login/{login}/{password}")
	Users Login(@PathVariable String login , @PathVariable String password) {
		return ASSR.findByEmailAndPassword(login, password).get(0) ; 
	}
	

	
}
