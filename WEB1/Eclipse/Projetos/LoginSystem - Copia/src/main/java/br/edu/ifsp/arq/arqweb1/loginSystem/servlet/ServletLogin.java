package br.edu.ifsp.arq.arqweb1.loginSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.arqweb1.loginSystem.model.dao.*;
import br.edu.ifsp.arq.arqweb1.loginSystem.model.entities.User;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public ServletLogin() {
		super();
		userDao = UserDaoImple.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user = userDao.getUser(email, password);
		
		if (user != null) {
			req.getSession().setAttribute("user", user);
			req.getSession().setAttribute("userNome", user.getEmail());
			
			resp.sendRedirect("index.jsp");
		} else {
			throw new ServletException();
		}
	}
	
	
	
	

}
