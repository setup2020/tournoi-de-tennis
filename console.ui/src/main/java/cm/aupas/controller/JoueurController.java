package cm.aupas.controller;

import java.sql.SQLException;
import java.util.Scanner;

import cm.aupas.core.entity.Joueur;
import cm.aupas.core.service.JoueurService;

public class JoueurController {
	private JoueurService joueurService;
	public JoueurController() {
		this.joueurService=new JoueurService();
		
	}
	public void afficheDetailJoueur() {
		Scanner scanner= new Scanner(System.in);
		System.out.println("entrez une id d\'un joueur");
		long id=scanner.nextLong();
		Joueur joueur=joueurService.getJoueur(id);
		System.out.println("joueur "+joueur.getNom());
		
	}

	
	public void createJoueur()  {
		Scanner scanner= new Scanner(System.in);
		System.out.println("entrez le nom du joueur");
		String nom=scanner.nextLine();
		
		System.out.println("entrez le prenom du joueur");
		String prenom=scanner.nextLine();
		
		System.out.println("entrez le sexe du joueur");
		Character sexe=scanner.nextLine().charAt(0);
		Joueur joueur=new Joueur();
		joueur.setNom(nom);
		joueur.setPrenom(prenom);
		joueur.setSexe(sexe);
		joueurService.createJoueur(joueur);
		System.out.println("Joueur cree "+joueur.getId());
	}
	
	public void renommeJoueur() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entrez le id du joueur");
		Long id=scanner.nextLong();
		scanner.nextLine();
		System.out.println("Entrez le nom du joueur");
		String nom=scanner.nextLine();
		joueurService.renomme(id, nom);
		System.out.println("Le nom du joueur a ete modifier");
		
	}
}
