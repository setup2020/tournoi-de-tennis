package cm.aupas.core.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.sql.DataSource;

import cm.aupas.core.DataSourceProvider;
import cm.aupas.core.HibernateUtil;
import cm.aupas.core.entity.Match;
import cm.aupas.core.entity.Score;
import org.hibernate.Session;

public class ScoreRepositoryImpl {
	public void create(Score score) throws SQLException {
		Connection conn = null;
		try {
			DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();

			conn = dataSource.getConnection();
			PreparedStatement prepareStatement = conn
					.prepareStatement("INSERT INTO SCORE_VAINQUEUR (ID_MATCH,SET_1,SET_2,SET_3,SET_4,SET_5) VALUES (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			prepareStatement.setLong(1, score.getMatch().getId());
			prepareStatement.setLong(2, score.getSet1());
			prepareStatement.setLong(3, score.getSet2());
			if(score.getSet4()==null) {
				prepareStatement.setLong(5, Types.TINYINT);
			}else {
				prepareStatement.setLong(5, score.getSet4());
			}
			prepareStatement.setLong(4, score.getSet3());
			
			
			
			if(score.getSet5()==null) {
				prepareStatement.setLong(6, Types.TINYINT);
			}else {
				prepareStatement.setLong(6, score.getSet5());
			}
			prepareStatement.executeUpdate();
			ResultSet rs=prepareStatement.getGeneratedKeys();
			if(rs.next()) {
			 score.setId(rs.getLong(1));
				
			}
			System.out.println("Score cree");
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}


	public void delete(Long id){

		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		Score score=session.get(Score.class,id);
		session.delete(score);
		System.out.println("Score supprimer");
	}

}
