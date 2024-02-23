package model;
import java.util.ArrayList;
import java.util.List;

import model.entity.Ator;
import model.entity.Diretor;
import model.entity.Filme;

public class Engine {

    private List<Filme> filmes;
    private List<Ator> atores;
    private List<Diretor> diretores;

    public Engine() {
        filmes = new ArrayList<>(10);
        atores = new ArrayList<>(10);
        diretores = new ArrayList<>(10);
    }

    public void addFilme(String titulo, String nomeDiretor, int
    anoLancamento, int nota) {

        boolean isCadastrado = false;
        Diretor diretor = null;

        for (Diretor diretorCadastrado : diretores){
            if (nomeDiretor.equals(diretorCadastrado.getNome())) {
                isCadastrado = true;
                diretor = diretorCadastrado;
                break;
            }
        }

        if (!isCadastrado){
            diretor = new Diretor(nomeDiretor);
            diretores.add(diretor);
        }

        filmes.add(new Filme(titulo, diretor, anoLancamento, nota));
    }

    public void addAtor(String nome, int anoNascimento) {

        boolean isCadastrado = false;
        Ator ator = null;

        for (Ator atorCadastrado : atores){
            if (nome.equals(atorCadastrado.getNome())) {
                isCadastrado = true;
                ator = atorCadastrado;
                break;
            }
        }

        if (!isCadastrado){
            ator = new Ator(nome, anoNascimento);
            atores.add(ator);
        }

        filmes.getLast().addAtor(ator);
    }

    private void addDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public List<Diretor> getDiretores() {
        return diretores;
    }
}
