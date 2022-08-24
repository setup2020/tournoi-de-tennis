package cm.aupas.core.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cm.aupas.core.HibernateUtil;
import cm.aupas.core.dto.TournoiDto;
import cm.aupas.core.entity.Tournoi;
import cm.aupas.core.repository.TournoiRepositoryImpl;

public class TournoiService {
	
	TournoiRepositoryImpl tournoiRepository;
	
	public TournoiService(){
		tournoiRepository=new TournoiRepositoryImpl();
	}

	public TournoiDto getDetailTournoi(Long id) {
		
		Session session = null;
		Tournoi tournoi = null;
		Transaction tx=null;
		TournoiDto dto=null;

		try {
			session=HibernateUtil.getSessionFactory().openSession();
			tx=session.beginTransaction();
			tournoi=session.get(Tournoi.class, id);
			dto=new TournoiDto();
			dto.setId(tournoi.getId());
			dto.setCode(tournoi.getCode());
			dto.setNom(tournoi.getNom());
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return dto;
	}
	
}
