package cm.aupas.core.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import cm.aupas.core.entity.Epreuve;
import cm.aupas.core.entity.Tournoi;

public class EpreuveFullDto {

	private Long id;
	private Short annee;
	private TournoiDto tournoi;
	private Character type;
	private Set<JoueurDto> participants;
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
	public TournoiDto getTournoi() {
		return tournoi;
	}
	public void setTournoi(TournoiDto tournoi) {
		this.tournoi = tournoi;
	}
	public Set<JoueurDto> getParticipants() {
		return participants;
	}
	public void setParticipants(Set<JoueurDto> participants) {
		this.participants = participants;
	}
	

}
