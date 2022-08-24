package cm.aupas.core;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import com.mysql.cj.jdbc.MysqlDataSource;
public class DataSource {

	public static void main(String[] args) throws SQLException {
	BasicDataSource dataSource=new BasicDataSource();
	dataSource.setInitialSize(5);
	dataSource.setUrl("jdbc:mysql://localhost:3306/db_tennis");
	dataSource.setUsername("root");
	dataSource.setPassword("");
 
	}

}
