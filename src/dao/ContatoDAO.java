package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

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
			stat.close();
			System.out.println("Adicionado!");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}
	}
	
	
	public Contato pesquisar(String email) throws SQLException{
		Contato contato = new Contato();
		String sql = "select * from contatos where email ilike ?";
		
		try {
			PreparedStatement stat = con.prepareStatement(sql);
			
			stat.setString(1, email);
			ResultSet result = stat.executeQuery();
			
			result.next();
			
			contato = setContato(result);
			
			result.close();
			stat.close();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}
		
		return contato;
	}
	
	
	public List<Contato> listar() throws SQLException{
		ArrayList<Contato> contatos = new ArrayList<>();
		String sql = "select * from contatos";
		
		try {
			PreparedStatement stat = con.prepareStatement(sql);
			ResultSet result = stat.executeQuery();
			
			while(result.next()){
				contatos.add(setContato(result));
			}
			
			result.close();
			stat.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}
		
		
		return contatos;
		
	}
	
	
	public void remover(String email) throws SQLException{
		String sql = "delete from contatos where email ilike ?";
		
		try {
			
			PreparedStatement stat = con.prepareStatement(sql);
			stat.setString(1, email);
			
			stat.execute();
			stat.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}
	}
	
	public void atualizar(Contato contato){
		
	}
	
	
	private Contato setContato(ResultSet result) throws SQLException{
		Contato contato = new Contato();
		contato.setId(result.getLong("id"));
		contato.setNome(result.getString("nome"));
		contato.setEmail(result.getString("email"));
		contato.setEndereco(result.getString("endereco"));
		
		Calendar data = Calendar.getInstance();
		data.setTime(result.getDate("data_nascimento"));
		contato.setDataNascimento(data);
		
		return contato;
	}
	
	
}
