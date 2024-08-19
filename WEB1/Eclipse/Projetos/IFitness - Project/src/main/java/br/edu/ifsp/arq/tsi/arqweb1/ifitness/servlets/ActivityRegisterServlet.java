package br.edu.ifsp.arq.tsi.arqweb1.ifitness.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.Activity;
import br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.ActivityType;
import br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.User;
import br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.util.activities.ActivitiesReader;
import br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.util.activities.ActivitiesWriter;
import br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.util.users.UsersReader;

@WebServlet("/activityRegister")
public class ActivityRegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ActivityRegisterServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		ActivityType type = ActivityType.valueOf
				(req.getParameter("type"));
		LocalDate date = LocalDate.parse(req.getParameter("date"));
		Double distance = 
				Double.parseDouble(req.getParameter("distance"));
		Double duration = 
				Double.parseDouble(req.getParameter("duration"));
		// buscar o usuário logado
		User user = getLoggedUser(req);
		
		RequestDispatcher dispatcher = null;
		
		if(user != null) {
			Activity activity = new Activity();
			activity.setType(type);
			activity.setDate(date);
			activity.setDistance(distance);
			activity.setDuration(duration);
			activity.setUser(user);
			if(id == 0) {
				if(ActivitiesWriter.write(activity)) {
					req.setAttribute("result", "registered");
					dispatcher = 
							req.getRequestDispatcher("/activity-register.jsp");
				}
			}else {
				activity.setId(id);
				if(ActivitiesWriter.update(activity)) {
					req.setAttribute("result", "registered");
					dispatcher = 
							req.getRequestDispatcher("/activity-register.jsp");
				}
			}
			
		}else {
			req.setAttribute("result", "notRegistered");
			dispatcher = 
					req.getRequestDispatcher("/activity-register.jsp");
		}
		dispatcher.forward(req, resp);
	}

	private User getLoggedUser(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie c: cookies) {
				if(c.getName().equals("loggedUser")) {
					return UsersReader.findUserByEmail(c.getValue());
				}
			}
		}
		return null;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		Long id = Long.parseLong(req.getParameter("activity-id"));
		Activity activity = ActivitiesReader.findById(id);
		RequestDispatcher dispatcher = null;
		if(activity != null) {
			if(action.equals("update")) {
				req.setAttribute("activity", activity);
				dispatcher = 
						req.getRequestDispatcher("/activity-register.jsp");
			}
			if(action.equals("delete")) {
				ActivitiesWriter.delete(activity);
				dispatcher = req.getRequestDispatcher("/homeServlet");
			}
		}else {
			dispatcher = req.getRequestDispatcher("/homeServlet");
		}
		dispatcher.forward(req, resp);
	}
	
	

}











