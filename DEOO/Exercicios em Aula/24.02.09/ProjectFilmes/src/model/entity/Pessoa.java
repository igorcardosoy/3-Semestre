package model.entity;

public abstract class Pessoa {
    protected String nome;

    protected Pessoa(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}
