package br.edu.ifsp.arq.arqweb1.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.arq.arqweb1.model.Usuario;

public class UsuarioDAO {
	
	private static UsuarioDAO instance;
    private final String arquivoCSV = "/home/aluno/Downloads/usuarios.csv";

    // Construtor privado para evitar instancias diretas
    private UsuarioDAO() {}

    // Método estático para obter a única instância da classe
    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }
    
    public void addUsuario(Usuario usuario) {
    	try {    		
			FileWriter fw = new FileWriter(arquivoCSV, true);
			File f = new File(arquivoCSV);
			System.out.println(f.getAbsolutePath());
			PrintWriter pw = new PrintWriter(fw);
			usuario.setId(getUltimoId());
			pw.println(usuario);
			pw.close();
			fw.close();
		}  catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 4) {
                    int id = Integer.parseInt(partes[0]);
                    String nome = partes[1];
                    String email = partes[2];
                    String senha = partes[3];
                    usuarios.add(new Usuario(id, nome, email, senha));
                }
            }
            reader.close();            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    
    private void apagarArquivo() {
    	try {
			FileWriter fw = new FileWriter(arquivoCSV, false);
			PrintWriter pw = new PrintWriter(fw);			
			pw.print("");
			pw.close();
			fw.close();
		}  catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private int getUltimoId() {    	
    	List<Usuario> usuarios = getUsuarios();    	
    	if(usuarios.isEmpty()) {
    		return 0;
    	}else {
    		return usuarios.get(usuarios.size()-1).getId();
    	}
    }
    

    public Usuario getUsuarioPorEmail(String email) {
        List<Usuario> usuarios = getUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().compareTo(email) == 0) {
                return usuario;
            }
        }        
        return null;
    }
    
    public Usuario getUsuarioPorId(int id) {
        List<Usuario> usuarios = getUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }        
        return null;
    }

    
    public void editUsuario(Usuario usuarioEditado) {
        List<Usuario> usuarios = getUsuarios();
        apagarArquivo();

        for (Usuario usuario : usuarios) {
            if (usuario.getId() == usuarioEditado.getId()) {
                usuario.setNome(usuarioEditado.getNome());
                usuario.setEmail(usuarioEditado.getEmail());
                usuario.setSenha(usuarioEditado.getSenha());
            }
            addUsuario(usuario);
        }
    }

    public void deleteUsuario(Usuario usuarioExcluir) {
        List<Usuario> usuarios = getUsuarios();
        apagarArquivo();

        for (Usuario usuario : usuarios) {
            if (usuario.getId() != usuarioExcluir.getId()) {
                addUsuario(usuario);
            }
        }    
    }
    
}
