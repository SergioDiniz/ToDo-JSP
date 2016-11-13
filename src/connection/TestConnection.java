package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import beans.Contato;
import dao.ContatoDAO;

public class TestConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
//		Connection con = new ConnectionJDBC().createConnection();
//		con.close();
//		System.out.println("Connection closed!");
		
		Contato contato = new Contato();
		contato.setNome("Sergio");
		contato.setEmail("sergio2@g.com");
		contato.setEndereco("rua pedro muniz de brito");
		contato.setDataNascimento(Calendar.getInstance());
		
		
		ContatoDAO cd = new ContatoDAO();
		
		cd.adicionar(contato);
		
		
		
	}

}
