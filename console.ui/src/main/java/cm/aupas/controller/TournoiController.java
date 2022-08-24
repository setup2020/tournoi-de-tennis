package cm.aupas.controller;

import java.util.Scanner;

import cm.aupas.core.dto.TournoiDto;
import cm.aupas.core.service.TournoiService;

public class TournoiController {

	TournoiService tournoiService;
	TournoiController(){
		tournoiService=new TournoiService();
	}
	
	public void afficheDetailTournoi() {
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("Entrez l\'identifiant du tournoi");
		long identifiant =scanner.nextLong();
		 TournoiDto tournoi= tournoiService.getDetailTournoi(identifiant);
		 System.out.println("Le tournoi trouvé est "+tournoi.getNom());
	}
}
