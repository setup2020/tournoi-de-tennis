package cm.aupas.core.service;

import java.sql.SQLException;

import cm.aupas.core.entity.Joueur;
import cm.aupas.core.repository.JoueurRepositoryImpl;

public class JoueurService {

	private JoueurRepositoryImpl joueurRepository;
	
	public JoueurService() {
		this.joueurRepository=new JoueurRepositoryImpl();
	}
	
	public void createJoueur(Joueur joueur)  {
		joueurRepository.create(joueur);
		
	}
	public Joueur getJoueur(Long id) {
		return joueurRepository.getById(id);
	}
	public void renomme(Long id , String nouveauxNom) {
	Joueur	joueur=getJoueur(id);
		joueur.setNom(nouveauxNom);
		
	}
}
