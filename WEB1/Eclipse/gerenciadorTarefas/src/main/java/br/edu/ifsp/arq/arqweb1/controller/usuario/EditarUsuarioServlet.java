package br.edu.ifsp.arq.arqweb1.controller.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.arqweb1.dao.UsuarioDAO;
import br.edu.ifsp.arq.arqweb1.model.Usuario;

@WebServlet("/editarUsuario")
public class EditarUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static UsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        usuarioDAO = UsuarioDAO.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usuario = usuarioDAO.getUsuarioPorId(id);
        request.setAttribute("usuario", usuario);
        String url = "/editarUsuario.jsp";

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/gerenciarUsuarios";
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        int id = Integer.parseInt(request.getParameter("id"));

        Usuario usuario = usuarioDAO.getUsuarioPorId(id);
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuarioDAO.editUsuario(usuario);

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
