package br.edu.ifsp.arq.arqweb1.model;

import java.io.Serializable;

public class Tarefa implements Serializable {

	private static final long serialVersionUID = 1L;
	private static int contador = 0;

	private int id;
	private String nome;
	private String descricao;
	private Usuario usuario;

	public Tarefa() {
		this.id = ++contador;
	}

	public Tarefa(String n, String d, Usuario u) {
		this();
		this.nome = n;
		this.descricao = d;
		this.usuario = u;
	}

	public Tarefa(int id, String nome, String descricao, Usuario u) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.usuario = u;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/*
	 * TODO: modificar toString para armazenar usuário Criar construtor com usuário
	 */
	@Override
	public String toString() {
		// return this.id + ";" + this.nome + ";" + this.descricao;
		return String.format("%d;%s;%s;%d;%s;%s;%s", this.id, this.nome, this.descricao, 
				this.usuario.getId(),this.usuario.getNome(), this.usuario.getEmail(), this.usuario.getSenha());
	}

}
