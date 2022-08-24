package cm.aupas.core.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Epreuve {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Short annee;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_TOURNOI")
	private Tournoi tournoi;
	
	@Column(name="TYPE_EPREUVE")
	private Character type;
	
	@ManyToMany
	@JoinTable(name="participants",
	joinColumns= @JoinColumn(name="ID_EPREUVE"),
	inverseJoinColumns= @JoinColumn(name="ID_JOUEUR")
	)
	private Set<Joueur> participants;
	
	
	
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
	public Tournoi getTournoi() {
		return tournoi;
	}
	public void setTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
	}
	public Character getType() {
		return type;
	}
	public void setType(Character type) {
		this.type = type;
	}
	public Set<Joueur> getParticipants() {
		return participants;
	}
	
	public void setParticipants(Set<Joueur> participants) {
		this.participants = participants;
	}
	

}
