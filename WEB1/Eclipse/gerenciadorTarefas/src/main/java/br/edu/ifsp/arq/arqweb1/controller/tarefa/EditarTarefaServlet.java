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
 * Servlet implementation class EditarTarefaServlet
 */
@WebServlet("/editarTarefa")
public class EditarTarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarTarefaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest 
			request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		TarefaDAO tdao = TarefaDAO.getInstance();
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute("usuario");
		String url = "/editarTarefa.jsp";
		
		if(session == null || user == null) {					
			url = "/login.jsp";
		}else {
			Tarefa t = tdao.buscarTarefaPorId(id,user);
			request.setAttribute("tarefa", t);
		}
		
		
		
		getServletContext().getRequestDispatcher(url).
			forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/gerenciarTarefas";
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("texto");
		int id = Integer.parseInt(request.getParameter("id"));
		TarefaDAO tdao = TarefaDAO.getInstance();
		
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute("usuario");		
		
		if(session == null || user == null) {					
			url = "/login.jsp";
		}else {
			Tarefa t = new Tarefa(id, nome, descricao, user);
			tdao.editTarefa(t,user);
		}		
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	public Tarefa buscarTarefa(int id, List<Tarefa> listaDeTarefas) {
		
		for(Tarefa t : listaDeTarefas) {
			if(t.getId() == id) {
				return t;
			}
		}
		
		return null;
	}
	
}
