package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Contato;
import dao.ContatoDAO;

/**
 * Servlet implementation class ListarContatos
 */
@WebServlet("/listarContatos")
public class ListarContatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarContatos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		
		
		List<Contato> contatos = new ArrayList<>();
		
		try {
			
			ContatoDAO contatoDAO = new ContatoDAO();
			contatos = contatoDAO.listar();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		out.println("<html>");
        out.println("<body>");
        out.println("<h1>Listar Contatos</h1><br/>");
        for (Contato contato : contatos) {
        	out.println(contato.getNome() + "<br/>");
		}
        out.println("</body>");
        out.println("</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
