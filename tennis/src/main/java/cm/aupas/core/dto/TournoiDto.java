package cm.aupas.core.dto;

import cm.aupas.core.entity.Tournoi;

public class TournoiDto extends Tournoi {
	private Long id;
	private String nom;
	private String code;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
