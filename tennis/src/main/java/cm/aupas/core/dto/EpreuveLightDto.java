package cm.aupas.core.dto;

import cm.aupas.core.entity.Epreuve;
import cm.aupas.core.entity.Tournoi;

public class EpreuveLightDto {

	private Long id;
	private Short annee;
	private Character type;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Short getAnnee() {
		return annee;
	}
	public void setAnnee(Short annee) {
		this.annee = annee;
	}
	
	public Character getType() {
		return type;
	}
	public void setType(Character type) {
		this.type = type;
	}
	

}
