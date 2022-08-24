package cm.aupas.core.service;

import java.util.HashSet;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cm.aupas.core.HibernateUtil;
import cm.aupas.core.dto.EpreuveFullDto;
import cm.aupas.core.dto.EpreuveLightDto;
import cm.aupas.core.dto.JoueurDto;
import cm.aupas.core.dto.TournoiDto;
import cm.aupas.core.entity.Epreuve;
import cm.aupas.core.entity.Joueur;
import cm.aupas.core.repository.EpreuveRepositoryImpl;

public class EpreuveService {
	private EpreuveRepositoryImpl epreuveRepository;
	

	public EpreuveService() {
	epreuveRepository=new EpreuveRepositoryImpl();
	}
	
	public EpreuveFullDto getEpreuveDetaillee(Long id) {
		Session session = null;
		Epreuve epreuve=null;
		EpreuveFullDto dto=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			epreuve=epreuveRepository.getById(id);
			System.out.println("===================>"+epreuve.getParticipants().size());
			
			
			dto=new EpreuveFullDto();
			dto.setAnnee(epreuve.getAnnee());
			dto.setId(epreuve.getId());
			dto.setType(epreuve.getType());
			TournoiDto tournoi=new TournoiDto();
			tournoi.setCode(epreuve.getTournoi().getCode());
			tournoi.setId(epreuve.getTournoi().getId());
			tournoi.setNom(epreuve.getTournoi().getNom());
			dto.setTournoi(dto.getTournoi());

			
			
			
			tx.commit();
		} catch(Throwable e) {
			e.getStackTrace();
		} finally {
			if(session!=null) {
				session.close();
			}
		}
		return dto;
	}
	
	public EpreuveLightDto getEpreuveSansTournoi(Long id) {
		Session session = null;
		Epreuve epreuve=null;
		EpreuveLightDto dto=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			epreuve=epreuveRepository.getById(id);
			Hibernate.initialize(epreuve.getTournoi());
			tx.commit();
			dto=new EpreuveLightDto();
			dto.setAnnee(epreuve.getAnnee());
			dto.setId(epreuve.getId());
			dto.setType(epreuve.getType());
			System.out.println("L\'epreuve est "+epreuve.getAnnee()+" "+epreuve.getTournoi().getNom()); 
		} catch (Throwable e) {
			e.printStackTrace();

		}  finally {
			if(session!=null) {
				session.close();
			}
		}
		return dto;
	}

	public EpreuveFullDto getEpreuveAvecTournoi(Long id) {
		Session session = null;
		Epreuve epreuve=null;
		Transaction tx=null;
		EpreuveFullDto dto=null;
		try {
			session=HibernateUtil.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			epreuve=epreuveRepository.getById(id);
			Hibernate.initialize(epreuve.getTournoi());
			tx.commit();
			dto=new EpreuveFullDto();
			dto.setAnnee(epreuve.getAnnee());
			dto.setId(epreuve.getId());
			dto.setType(epreuve.getType());
			TournoiDto tournoi=new TournoiDto();
			tournoi.setCode(epreuve.getTournoi().getCode());
			tournoi.setId(epreuve.getTournoi().getId());
			tournoi.setNom(epreuve.getTournoi().getNom());
			dto.setTournoi(dto.getTournoi());
		} catch (Throwable e) {
			e.printStackTrace();

		}  finally {
			if(session!=null) {
				session.close();
			}
		}
		return dto;
	}

}
