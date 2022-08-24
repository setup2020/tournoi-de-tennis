package cm.aupas.controller;

import java.util.Scanner;

import cm.aupas.core.dto.EpreuveFullDto;
import cm.aupas.core.dto.JoueurDto;
import cm.aupas.core.entity.Epreuve;
import cm.aupas.core.service.EpreuveService;

public class EpreuveController {
	private EpreuveService epreuveService;
	
	public  EpreuveController() {
		this.epreuveService=new EpreuveService();
	}

	public void afficheDetailEpreuve() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("quel est l\'identifiant de l\'epreuve");
		long identifiant=scanner.nextLong();
		EpreuveFullDto epreuve=this.epreuveService.getEpreuveDetaillee(identifiant);
		

	}
	
	public void afficheEpreuveAvecTournoi() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("quel est l\'identifiant de l\'epreuve");
		long identifiant=scanner.nextLong();
		EpreuveFullDto epreuve=this.epreuveService.getEpreuveAvecTournoi(identifiant);
		

	}
}
