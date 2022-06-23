package tn.isimm.pfe.services;

import java.awt.Color;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import tn.isimm.pfe.entities.BonDeCommande;

import com.lowagie.text.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
public class ReportBonDeCommande {
	private List<BonDeCommande> BDC;
	
	   public ReportBonDeCommande( List<BonDeCommande> listeBDC) {
	        this.BDC = listeBDC;
	    }
	
	   private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(4);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	      
	         
	        cell.setPhrase(new Phrase("Destinateur", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Destinataire", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("type", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("prix", font));
	        table.addCell(cell);      
	        
	        cell.setPhrase(new Phrase("dateDemission", font));
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("quantite", font));
	        table.addCell(cell);   
	        
	        
	        cell.setPhrase(new Phrase("demandeFourniture", font));
	        table.addCell(cell);  
	        
	    }
	   
	   
	   private void writeTableData(PdfPTable table) {
	        for (BonDeCommande dep : BDC) {
//	        	 table.addCell(dep.getDestinatair().getNom());
//	        	 table.addCell(dep.getDestinateur().getNom());
	        	 table.addCell(dep.getType());	      
	             table.addCell(String.valueOf(dep.getPrix()));
	             table.addCell(dep.getDateDemission());
	             table.addCell(String.valueOf(dep.getQuantite()));
	             table.addCell(dep.getDemandeFourniture());
	        }
	    }
	   
	   
	   
	   
	   
	   
	   
	   public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A3);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	        
	        
	        document.open();
	        
	        

	        
	        Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font1.setSize(10);
	     
	        
	        Paragraph p1 = new Paragraph("Rapport généré en "+currentDateTime, font1);
	        p1.setAlignment(Paragraph.ALIGN_LEFT);
	        document.add(p1);
	        
	        
	        
	        
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);
	         
	        
	        
	        Paragraph p = new Paragraph("Rapport Bon de commande", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(7);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 1.5f,1.5f,1.5f,1.5f, 1.5f,2f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }
}
