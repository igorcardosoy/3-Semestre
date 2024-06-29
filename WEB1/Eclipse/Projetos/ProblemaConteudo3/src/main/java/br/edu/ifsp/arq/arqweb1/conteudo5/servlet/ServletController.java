package br.edu.ifsp.arq.arqweb1.conteudo5.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.arqweb1.conteudo5.model.Person;
import br.edu.ifsp.arq.arqweb1.conteudo5.model.PersonUtil;

@WebServlet("/ServletPersons")
public class ServletController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletController() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String data = req.getParameter("persons");
		List<Person> personList = PersonUtil.getPersons(data);
		
		req.setAttribute("list", personList);
		
		RequestDispatcher dispacher = req.getRequestDispatcher("/result.jsp");
		dispacher.forward(req, resp);
	}

}
