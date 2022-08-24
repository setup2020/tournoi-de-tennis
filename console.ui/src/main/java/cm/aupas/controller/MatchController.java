package cm.aupas.controller;

import java.util.Scanner;

import cm.aupas.core.dto.EpreuveFullDto;
import cm.aupas.core.dto.JoueurDto;
import cm.aupas.core.dto.MatchDto;
import cm.aupas.core.dto.ScoreFullDto;
import cm.aupas.core.entity.Match;
import cm.aupas.core.service.MatchService;

public class MatchController {
	
	private MatchService matchService;
	
	MatchController(){
		matchService=new MatchService();
	}
	
	public void afficheDetailMatch() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Quel est l'identifiant du match dont vous voulez afficher les informations ?");
		long identifiant=scanner.nextLong();
		MatchDto dto=matchService.getMatch(identifiant);
		System.out.println("Il s'agit d'u match de "+dto.getEpreuve().getAnnee()+" qui c'est deroulé a "+ dto.getEpreuve().getTournoi().getNom());

		System.out.println("les sets du match sont :");
		System.out.println(dto.getScore().getSet1());
		if(dto.getScore().getSet2()!=null){
			System.out.println(dto.getScore().getSet2());
		}
		if(dto.getScore().getSet3()!=null){
			System.out.println(dto.getScore().getSet3());
		}
		if(dto.getScore().getSet4()!=null){
			System.out.println(dto.getScore().getSet4());
		}
		if(dto.getScore().getSet5()!=null){
			System.out.println(dto.getScore().getSet5());
		}
		
	}
	
	public void getOne(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Quel est l'identifiant du match dont vous voulez afficher les informations ?");
		long identifiant=scanner.nextLong();
		Match dto=matchService.getOneMatch(identifiant);
		System.out.println("Il s'agit du match de "+dto.getId());
	}

	public void tapisVert(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Quel est l'identifiant du match dont vous voulez modifier les informations ?");
		long identifiant=scanner.nextLong();
		matchService.tapisVert(identifiant);
	}

	public void AjouterMatch(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("quel est l'identifiant de l'epreuve ?");
		long epreuveId=scanner.nextLong();
		scanner.nextLine();
		System.out.println("quel est l'identifiant du vainqueur ?");
		long vainqueurId=scanner.nextLong();
		scanner.nextLine();
		System.out.println("quel est l'identifiant du finaliste ?");
		long finaliseId=scanner.nextLong();
		MatchDto  dto=new MatchDto();
		dto.setEpreuve(new EpreuveFullDto());
		dto.getEpreuve().setId(epreuveId);
		dto.setFinaliste(new JoueurDto());
		dto.getFinaliste().setId(finaliseId);
		dto.setVainqueur(new JoueurDto());
		dto.getVainqueur().setId(vainqueurId);

		scanner.nextLine();

		System.out.println("quel est la valuer du set 1?");
		byte set1=scanner.nextByte();
		scanner.nextLine();

		System.out.println("quel est la valuer du set 2?");
		byte set2=scanner.nextByte();
		scanner.nextLine();

		System.out.println("quel est la valuer du set 3?");
		byte set3=scanner.nextByte();
		scanner.nextLine();

		System.out.println("quel est la valuer du set 4?");
		byte set4=scanner.nextByte();
		scanner.nextLine();

		System.out.println("quel est la valuer du set 5?");
		byte set5=scanner.nextByte();
		scanner.nextLine();

		ScoreFullDto scoreFullDto=new ScoreFullDto();
		scoreFullDto.setSet1(set1);
		scoreFullDto.setSet2(set2);
		scoreFullDto.setSet3(set3);
		scoreFullDto.setSet4(set4);
		scoreFullDto.setSet5(set5);

		dto.setScore(scoreFullDto);
		matchService.createMatch(dto);


	}
	public void supprimerMatch(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("quel est le match que vous voulez supprimer?");
		long identifiant=scanner.nextLong();
		matchService.deleteMath(identifiant);

	}
}
