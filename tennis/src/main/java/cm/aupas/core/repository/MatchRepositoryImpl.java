package cm.aupas.core.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cm.aupas.core.DataSourceProvider;
import cm.aupas.core.HibernateUtil;
import cm.aupas.core.entity.Joueur;
import cm.aupas.core.entity.Match;

public class MatchRepositoryImpl {
	public void create(Match match) throws SQLException {
	Session session=HibernateUtil.getSessionFactory().getCurrentSession();
	session.persist(match);
	System.out.println("Match cree");

	}
	public Match getById(Long id) {
		Session session = null;
		Match match=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			tx=session.beginTransaction();
			match=session.get(Match.class,id);
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		return match;
	}

	public void delete(Long id){

		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		Match match=session.get(Match.class,id);
		session.delete(match);
		System.out.println("Match supprimer");
	}

}
