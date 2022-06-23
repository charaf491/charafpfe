package tn.isimm.pfe.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;

import tn.isimm.pfe.entities.BonDeCommande;
import tn.isimm.pfe.repositories.BonDeCommandeRepository;
import tn.isimm.pfe.services.ReportBonDeCommande;

@RestController
@CrossOrigin("*")
@RequestMapping("/bonDeCommande")
public class BonDeCommandeController {
	@Autowired
	BonDeCommandeRepository ASSR;

	@GetMapping("AfficherCommandes")
	List<BonDeCommande> Afficherts() {
		return ASSR.findAll();
	}

	@GetMapping("AjoutCommande/{Destinateur}/{Destinatair}/{type}/{prix}/{dateDemission}/{quantite}/{demandeFourniture}")
	String Ajouter(
			       @PathVariable String Destinateur ,
				   @PathVariable String Destinatair , 
				   @PathVariable String type , 
				   @PathVariable int prix , 
				   @PathVariable String dateDemission ,
				   @PathVariable int quantite , 
				   @PathVariable String demandeFourniture 
				   
				   ) {

		 BonDeCommande Action = new BonDeCommande() ; 
		
	     Action.setDateDemission(dateDemission) ; 
	     Action.setDemandeFourniture(demandeFourniture) ; 
	     Action.setQuantite(quantite) ; 
	     Action.setType(type) ;
	     Action.setPrix(prix); 
	     
	     ASSR.save(Action);
		return "BonDeCommande Ajouté avec succés";

	}

	@DeleteMapping("DeleteCommande/{id}")
	String deleteBonDeCommande(@PathVariable Long id ) {

		if (ASSR.existsById(id)== false) {
			return "Action n'existe pas" ; 
		}
		
		ASSR.deleteById(id);
		return "Delete BonDeCommande affectué" ; 
	}
	
	@PutMapping("UpdateCommande")
	String update(@RequestBody BonDeCommande Action) {
		BonDeCommande f = ASSR.findById(Action.getId()).get();

		if(Action.getDateDemission()!="") {f.setDateDemission(Action.getDateDemission());}
		if(Action.getDemandeFourniture()!="") {f.setDemandeFourniture(Action.getDemandeFourniture());}
		if(Action.getType()!=null) {f.setType(Action.getType());}
		f.setPrix(Action.getPrix());
		f.setQuantite(Action.getQuantite());
		
		ASSR.save(f);
		return "Bon de commande updated avec succés";
	}
	
	@GetMapping("Rapport/pdf/{id}")
	public void exportToPDF(HttpServletResponse response ,@PathVariable long id ) throws DocumentException, IOException {
		
	    response.setContentType("application/pdf");
	    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String currentDateTime = dateFormatter.format(new Date());
	         
	    String headerKey = "Content-Disposition";
	    String headerValue = "attachment; filename= Rapport_Veh_Chauff_" + currentDateTime + ".pdf";
	       
	    response.setHeader(headerKey, headerValue);
	         
	    List<BonDeCommande> chauff = ASSR.findAll();
	    List<BonDeCommande> chauff1 = new ArrayList<BonDeCommande>();
	    
	    for (int i = 0; i < chauff.size(); i++) {
		    if (chauff.get(i).getId() == id  ) {
		        chauff1.add(chauff.get(i)) ;
		    }
	    }

	    ReportBonDeCommande exporter = new ReportBonDeCommande(chauff1);
	       
	    exporter.export(response);
	}
	   
/*	   
	@GetMapping("Rapport/pdf/{destinataire}/{date}")
	public void exportToPDF1(HttpServletResponse response ,@PathVariable String destinataire , @PathVariable String date  ) throws DocumentException, IOException {
	    response.setContentType("application/pdf");
	    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String currentDateTime = dateFormatter.format(new Date());
	         
	    String headerKey = "Content-Disposition";
	    String headerValue = "attachment; filename= Rapport_Veh_Chauff_" + currentDateTime + ".pdf";
	       
	    response.setHeader(headerKey, headerValue);
	         
	    List<BonDeCommande> chauff = ASSR.findAll();
	    List<BonDeCommande> chauff1 = new ArrayList<BonDeCommande>();
	        
	    for (int i = 0; i < chauff.size(); i++) {
	        if (chauff.get(i).getDestinatair().equals(destinataire)  && chauff.get(i).getDateDemission().equals(date)    ) {
	        	chauff1.add(chauff.get(i)) ;
	        }
		}
	        
	    ReportBonDeCommande exporter = new ReportBonDeCommande(chauff1);
	    
	    exporter.export(response);
	}
	   
    @GetMapping("AfficherBonDeCommande/{destinataire}/{date}")
	List<BonDeCommande> AfficheBC(@PathVariable String destinataire , @PathVariable String date) { 
		List<BonDeCommande> chauff = ASSR.findAll();
	    List<BonDeCommande> chauff1 = new ArrayList<BonDeCommande>();
	    
	    for (int i = 0; i < chauff.size(); i++) {
	        if (chauff.get(i).getDestinatair().equals(destinataire)  && chauff.get(i).getDateDemission().equals(date)    ) {
	        	chauff1.add(chauff.get(i)) ;
	        }
		}
	    
		return chauff1;
	}
*/
	
}
