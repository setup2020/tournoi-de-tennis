package cm.aupas.controller;

import cm.aupas.core.service.ScoreService;

import java.util.Scanner;

public class ScoreController {

    private ScoreService scoreService;
   public ScoreController(){
       scoreService=new ScoreService();
   }

    public void supprimerMatch(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("quel est le score que vous voulez supprimer?");
        long identifiant=scanner.nextLong();
        scoreService.deleteScore(identifiant);

    }
}
