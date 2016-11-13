package connection;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = new ConnectionJDBC().createConnection();
		con.close();
		System.out.println("Connection closed!");
	}

}
