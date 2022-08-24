package cm.aupas.core.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cm.aupas.core.DataSourceProvider;
import cm.aupas.core.HibernateUtil;
import cm.aupas.core.entity.Joueur;
import java.sql.ResultSet;
public class JoueurRepositoryImpl {
	public void create(Joueur joueur){
		Session session=null;
		Transaction tx=null;
		try {
			
			session=HibernateUtil.getSessionFactory().openSession();
			tx= session.beginTransaction();
			session.persist(joueur);
			tx.commit();
			
		} catch(Throwable e) {
			e.printStackTrace();
			if(tx!=null) {
				tx.rollback();
			}
		} finally {
			if(session!=null) {
				session.close();
			}
		}
		

	}

	public List<Joueur> list() throws SQLException {
		List joueurs = new ArrayList();
		Connection conn = null;
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
			conn = dataSource.getConnection();
			PreparedStatement prepareStatement = conn.prepareStatement("SELECT ID,NOM,PRENOM,SEXE FROM JOUEUR");
			ResultSet rs=prepareStatement.executeQuery();
			while(rs.next()) {
				Joueur joueur=new Joueur();
				joueur.setId(rs.getLong("ID"));
				joueur.setNom(rs.getString("NOM"));
				joueur.setPrenom(rs.getString("PRENOM"));
				joueur.setSexe(rs.getString("SEXE").charAt(0));
				joueurs.add(joueur);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Nombre de joueur"+joueurs.size());
		return joueurs;
	}


		public Joueur getById(Long id) {
			Session session = null;
			Joueur joueur=null;
			Transaction tx=null;
			try {
				session=HibernateUtil.getSessionFactory().openSession();
				tx=session.beginTransaction();
				joueur=session.get(Joueur.class,id);
				tx.commit();
			} catch (Throwable e) {
				e.printStackTrace();

			} 
			return joueur;
		}

}
