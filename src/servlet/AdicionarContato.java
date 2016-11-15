package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import beans.Contato;
import dao.ContatoDAO;

/**
 * Servlet implementation class AdicionarContato
 */
@WebServlet("/adicionarContato")
public class AdicionarContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarContato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		
		String nome =  request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		
		String dataString = request.getParameter("dataNascimento");
		Date date = null;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(date);
		
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		
		try {
			
			ContatoDAO contatoDAO = new ContatoDAO();
			contatoDAO.adicionar(contato);
			
			out.println("Cadastrado!");
			
		} catch (SQLException | ClassNotFoundException e) {
			//out.println("ERROR!" + e.getMessage());
			throw new ServletException(e);
			
		}
		
	}

}
