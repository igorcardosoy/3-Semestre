package br.edu.ifsp.arq.arqweb1;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/calcAge")
public class AgeCalcServlet extends HttpServlet{

	private static final long serialVersionUID = 2L;

	public AgeCalcServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	    
	    String age = req.getParameter("date");
	    
	    LocalDate birthDate = LocalDate.parse(age);
	    LocalDate currentDate = LocalDate.now();
	    
	   
	    
		if (birthDate.isAfter(currentDate)) {
            throw new ServletException();
		}
	    
	    int ageInYears = currentDate.getYear() - birthDate.getYear();
	    
		if (currentDate.getMonthValue() <= birthDate.getMonthValue()
				&& currentDate.getDayOfMonth() < birthDate.getDayOfMonth()) {
			ageInYears--;
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
					writer.println("<h1>Idade</h1>");
					writer.println("<p> A idade é: " + ageInYears + " anos</p>");
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
