package br.edu.ifsp.arq.arqweb1.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.arq.arqweb1.model.Tarefa;
import br.edu.ifsp.arq.arqweb1.model.Usuario;

public class TarefaDAO {

	private final String arquivoCSV = "/home/aluno/Downloads/tarefas.csv";

	private static TarefaDAO instance;
	
	private TarefaDAO() {
	}
	
	public static TarefaDAO getInstance() {
		if(instance == null) {
			instance = new TarefaDAO();		
		}
		
		return instance;
	}

	public void addTarefa(Tarefa t) {
		try {
			FileWriter fw = new FileWriter(arquivoCSV, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(t);
			pw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 * TODO: Modificar para buscar tarefas de acordo com o Usuário
 * @return
 */
	public List<Tarefa> getTarefas(Usuario u) {
		List<Tarefa> tarefas = new ArrayList();

		try {
			FileReader fr = new FileReader(arquivoCSV);
			BufferedReader reader = new BufferedReader(fr);
			String linha;

			while ((linha = reader.readLine()) != null) {
				String[] partes = linha.split(";");
				if (partes.length == 7) {
					int id = Integer.parseInt(partes[0]);
					String nome = partes[1];
					String descricao = partes[2];
					int uId = Integer.parseInt(partes[3]);
					String uNome = partes[4];
					String uEmail = partes[5];
					String uSenha = partes[6];
					
					if(u.getId() == uId) {
						Usuario user = new Usuario(uId,uNome,uEmail,uSenha);					
						tarefas.add(new Tarefa(id, nome, descricao, user));
					}
				}
			}

			reader.close();
			fr.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tarefas;
	}
	
	public Tarefa buscarTarefaPorId(int id, Usuario u) {
		List<Tarefa> lt = getTarefas(u);

		for (Tarefa tarefa : lt) {
			if (tarefa.getId() == id) {
				return tarefa;
			}
		}
		
		return null;
	}

	public void editTarefa(Tarefa t, Usuario u) {

		List<Tarefa> lt = getTarefas(u);

		for (Tarefa tarefa : lt) {
			if (tarefa.getId() == t.getId()) {
				tarefa.setNome(t.getNome());
				tarefa.setDescricao(t.getDescricao());
				break;
			}
		}
		
		writeListaDeTarefas(lt);
	}

	private void writeListaDeTarefas(List<Tarefa> lt) {
		try {
			FileWriter fw = new FileWriter(arquivoCSV, false);
			PrintWriter pw = new PrintWriter(fw);
			for(Tarefa t : lt) {
				pw.println(t);
			}			
			pw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
