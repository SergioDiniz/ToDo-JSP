package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Contato;
import connection.ConnectionJDBC;

public class ContatoDAO {

	private Connection con;

	public ContatoDAO() throws SQLException, ClassNotFoundException {
		this.con = new ConnectionJDBC().createConnection();
	}
	
	
	public void adicionar(Contato contato) throws SQLException{
		String sql = "insert into contatos (nome, email, endereco, data_nascimento) values (?,?,?,?)";
		
		try {
			PreparedStatement stat = con.prepareStatement(sql);
			
			stat.setString(1, contato.getNome());
			stat.setString(2, contato.getEmail());
			stat.setString(3, contato.getEndereco());
			stat.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stat.execute();
			System.out.println("Adicionado!");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}
	}
	
	
}
