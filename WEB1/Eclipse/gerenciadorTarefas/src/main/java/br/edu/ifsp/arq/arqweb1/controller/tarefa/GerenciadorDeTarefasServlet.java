package br.edu.ifsp.arq.arqweb1.controller.tarefa;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifsp.arq.arqweb1.dao.TarefaDAO;
import br.edu.ifsp.arq.arqweb1.model.Tarefa;
import br.edu.ifsp.arq.arqweb1.model.Usuario;

/**
 * Servlet implementation class GerenciadorDeTarefasServlet
 */
@WebServlet("/gerenciarTarefas")
public class GerenciadorDeTarefasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerenciadorDeTarefasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TarefaDAO tdao = TarefaDAO.getInstance();
		String url = "/gerenciadorDeTarefas.jsp";
		
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute("usuario");
		
		if(session == null || user == null) {					
			url = "/login.jsp";
		}else {
			List<Tarefa> lt = tdao.getTarefas(user);
			request.setAttribute("listaDeTarefas", lt);
		}	
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
