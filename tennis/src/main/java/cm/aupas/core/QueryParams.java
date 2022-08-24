package cm.aupas.core;

import java.sql.*;

public class QueryParams {
	public static void main(String... args) {
		Connection conn = null;
		try {
			// paramettre
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db_tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris",
					"root", "");
			PreparedStatement prepareStatement = conn.prepareStatement("SELECT ID,NOM,PRENOM FROM JOUEUR WHERE ID=?");
			long identifiant = 12L;
			prepareStatement.setLong(1, identifiant);
			ResultSet rs1 = prepareStatement.executeQuery();
			System.out.println("requete avec paramettre !!");
			if (rs1.next()) {
				final String nom = rs1.getString("NOM");
				final String prenom = rs1.getString("PRENOM");
				final Long id = rs1.getLong("ID");
				System.out
						.println("Le joueur/ la joueuse representé par le numero " + id + " est " + prenom + " " + nom);

			} else {
				System.out.println("aucun joueur trouvé");
			}
			rs1.close();
			prepareStatement.close();
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
}
