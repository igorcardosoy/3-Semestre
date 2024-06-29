package br.edu.ifsp.arq.arqweb1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cursos")
public class CursosServlet extends HttpServlet{

	private static final long serialVersionUID = 2L;

	public CursosServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	    
	    String fullName = req.getParameter("fullName");
	    String emailString = req.getParameter("email");
	    String[] emailStringArray = req.getParameterValues("emails");
	    String[] options = req.getParameterValues("options");
	    String selectedOptions = "";
	   
	    if(options != null) {
	    	StringBuilder sb = new StringBuilder();
	    	
			for (int i = 0; i < options.length; i++) {
				sb.append(options[i]);
				if (i < options.length - 1) {
					sb.append(", ");
				}
			}
			
			selectedOptions = sb.toString();
		} else {
			selectedOptions = "Nenhum curso selecionado";
		}

	    resp.setContentType("text/html;charset=UTF-8");
	    
	    PrintWriter writer = resp.getWriter();
	    
	    writer.println("<html>");
		    writer.println("<head>");
			    writer.println("\t<meta charset=\"UTF-8\"  >");
			    writer.println("\t<title>Página de resposta - Register App </title>");
			    writer.println("<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\" />");
		    writer.println("</head>");
		    writer.println("<body>");
			    writer.println("<section>");
			    	writer.println("\t<h1>Cadastro realizado com sucesso!</h1>");
			    	writer.println("\t<h2>Nome completo: " + fullName + "</h2>");
			    	writer.println("\t<h2>Email: " + emailString + "</h2>");
			    	
					for (String email : emailStringArray) {
						writer.println("\t<h2>Emails adicionais: " + email + "</h2>");
					}
			    	
			    	if(options != null) {
						if (options.length > 1) {
							writer.println("\t<h2>Cursos selecionados: " + selectedOptions + "</h2>");
						} else {
							writer.println("\t<h2>Curso selecionado: " + selectedOptions + "</h2>");
						}
					} else {
						writer.println("\t<h2>Nenhum curso selecionado</h2>");
					}
		    	writer.println("<section>");
		    writer.println("</body>");
	    writer.println("</html>");
	    
	    writer.close();
	    
	    
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
