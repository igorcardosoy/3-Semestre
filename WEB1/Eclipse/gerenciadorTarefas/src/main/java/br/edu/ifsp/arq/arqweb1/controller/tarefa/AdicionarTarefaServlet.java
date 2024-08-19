package br.edu.ifsp.arq.arqweb1.controller.tarefa;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class AdicionarTarefaServlet
 */
@WebServlet("/adicionarTarefa")
public class AdicionarTarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<Tarefa> listaDeTarefas;

	@Override
	public void init() throws ServletException {
		super.init();
		listaDeTarefas = new ArrayList<>();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdicionarTarefaServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/gerenciadorDeTarefas.jsp";
		String nome = request.getParameter("nome");
		String texto = request.getParameter("texto");
		String mensagem = "";

		if (nome.isEmpty() || texto.isEmpty()) {
			mensagem = "Voce deve preencher todos os campos";
			url = "/gerenciarTarefas";
			request.setAttribute("msg", mensagem);
		} else {
			HttpSession session = request.getSession();
			Usuario user = (Usuario) session.getAttribute("usuario");

			if (session == null || user == null) {
				url = "/login.jsp";
			} else {
				Tarefa t = new Tarefa(nome, texto, user);
				TarefaDAO tdao = TarefaDAO.getInstance();
				tdao.addTarefa(t);
			}

		}

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
