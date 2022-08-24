package cm.aupas.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.sql.DataSource;

import cm.aupas.core.DataSourceProvider;
import cm.aupas.core.entity.Joueur;
import cm.aupas.core.entity.Match;

public class MatchDaoImpl {
	public void create(Match match) throws SQLException {
		Connection conn = null;
		try {
			DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();

			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			
			PreparedStatement prepareStatement = conn
					.prepareStatement("INSERT INTO MATCH_TENNIS (ID_EPREUVE,ID_VAINQUEUR,ID_FINALISTE) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
			prepareStatement.setLong(1, match.getEpreuve().getId());
			prepareStatement.setLong(2, match.getVainqueur().getId());
			prepareStatement.setLong(3, match.getFinaliste().getId());
			prepareStatement.executeUpdate();
			ResultSet rs=prepareStatement.getGeneratedKeys();
			if(rs.next()) {
			 match.setId(rs.getLong(1));
			}
			PreparedStatement prepareStatement1 = conn
					.prepareStatement("INSERT INTO SCORE_VAINQUEUR (ID_MATCH,SET_1,SET_2,SET_3,SET_4,SET_5) VALUES (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			prepareStatement1.setLong(1, match.getScore().getMatch().getId());
			prepareStatement1.setLong(2,match.getScore().getSet1());
			prepareStatement1.setLong(3, match.getScore().getSet2());
			if(match.getScore().getSet4()==null) {
				prepareStatement.setLong(5, Types.TINYINT);
			}else {
				prepareStatement1.setLong(5, match.getScore().getSet4());
			}
			prepareStatement1.setLong(4, match.getScore().getSet3());
			
			
			
			if(match.getScore().getSet5()==null) {
				prepareStatement1.setLong(6, Types.TINYINT);
			}else {
				prepareStatement1.setLong(6, match.getScore().getSet5());
			}
			prepareStatement.executeUpdate();
			ResultSet rs1=prepareStatement1.getGeneratedKeys();
			if(rs1.next()) {
				match.getScore().setId(rs1.getLong(1));
				
			}
			System.out.println("Joueur cree");
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if(conn!=null) {
					conn.rollback();
				}
			} catch(SQLException e1) {
				e1.printStackTrace();
			} 
			

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

}
