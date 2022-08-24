package cm.aupas.core.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cm.aupas.core.HibernateUtil;
import cm.aupas.core.entity.Epreuve;

public class EpreuveRepositoryImpl {

	public Epreuve getById(Long id) {
		Session session = null;
		Epreuve epreuve=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			tx=session.beginTransaction();
			epreuve=session.get(Epreuve.class,id);
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();

		}  finally {
			if(session!=null) {
				session.close();
			}
		}
		return epreuve;
	}

}
