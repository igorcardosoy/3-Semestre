package br.edu.ifsp.arq.arqweb1.controller.tarefa;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.arqweb1.model.Tarefa;

/**
 * Servlet implementation class ExcluirTarefaServlet
 */
@WebServlet("/excluirTarefa")
public class ExcluirTarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirTarefaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String url = "/gerenciadorDeTarefas.jsp";
		List<Tarefa> listaDeTarefas = (List<Tarefa>) getServletContext().getAttribute("listaDeTarefas");
		
		Tarefa t = buscarTarefa(id, listaDeTarefas);
		
		if(t != null) {
			listaDeTarefas.remove(t);
		}else {
			String mensagem = "Moio";
			request.setAttribute("msg", mensagem);
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
	
	public Tarefa buscarTarefa(int id, List<Tarefa> listaDeTarefas) {
		
		for(Tarefa t : listaDeTarefas) {
			if(t.getId() == id) {
				return t;
			}
		}
		
		return null;
	}

}
