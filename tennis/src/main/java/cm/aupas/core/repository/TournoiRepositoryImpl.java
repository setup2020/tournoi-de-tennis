package cm.aupas.core.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cm.aupas.core.HibernateUtil;
import cm.aupas.core.entity.Tournoi;

public class TournoiRepositoryImpl {

	public Tournoi getById(Long id) {
		Session session = null;
		Tournoi tournoi = null;
		Transaction tx=null;

		try {
			session=HibernateUtil.getSessionFactory().openSession();
			tx=session.beginTransaction();
			tournoi=session.get(Tournoi.class, id);
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return tournoi;
	}
}
