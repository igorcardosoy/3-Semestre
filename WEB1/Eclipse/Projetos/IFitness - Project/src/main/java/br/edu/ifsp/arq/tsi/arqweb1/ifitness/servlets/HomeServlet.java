package br.edu.ifsp.arq.tsi.arqweb1.ifitness.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.Activity;
import br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.User;
import br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.util.activities.ActivitiesReader;
import br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.util.users.UsersReader;

@WebServlet("/homeServlet")
public class HomeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public HomeServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User)req.getAttribute("user");
		
		RequestDispatcher dispatcher = null;
		
		if(user != null) {
			// buscar a lista de atividades do usuário logado
			List<Activity> userActivities = 
					ActivitiesReader.readByUser(user);
			req.setAttribute("userActivities", userActivities);
			req.setAttribute("name", user.getName());
			dispatcher = req.getRequestDispatcher("/home.jsp");
		}else {
			Cookie[] cookies = req.getCookies();
			if(cookies != null) {
				for(Cookie c: cookies) {
					if(c.getName().equals("loggedUser")) {
						user = UsersReader.findUserByEmail(c.getValue());
					}
				}
			}
			if(user != null) {
				// buscar a lista de atividades do usuário logado
				List<Activity> userActivities = 
						ActivitiesReader.readByUser(user);
				req.setAttribute("userActivities", userActivities);
				req.setAttribute("name", user.getName());
				dispatcher = req.getRequestDispatcher("/home.jsp");
			}else {
				req.setAttribute("result", "loginError");
				dispatcher = req.getRequestDispatcher("/login.jsp");
			}
			
		}
		
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}





