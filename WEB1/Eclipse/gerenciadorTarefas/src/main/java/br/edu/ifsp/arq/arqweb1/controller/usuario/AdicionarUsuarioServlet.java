package br.edu.ifsp.arq.arqweb1.controller.usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.arqweb1.dao.UsuarioDAO;
import br.edu.ifsp.arq.arqweb1.model.Usuario;

@WebServlet("/adicionarUsuario")
public class AdicionarUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static UsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        usuarioDAO = UsuarioDAO.getInstance();
    }

    public AdicionarUsuarioServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/login.jsp";
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String mensagem = "";

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            mensagem = "Você deve preencher todos os campos";
            url = "/adicionarUsuario.jsp";
            request.setAttribute("msg", mensagem);
        } else {
            Usuario usuario = new Usuario(nome, email, senha);
            usuarioDAO.addUsuario(usuario);
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
