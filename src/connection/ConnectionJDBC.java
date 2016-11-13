package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

	private final String url = "jdbc:postgresql://localhost:5432/TODOJSP";
	private final String user = "postgres";
	private final String password = "12345";
	
	public Connection createConnection() throws SQLException{
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("DB Connected!");
		return con;
	}
	
	
}
