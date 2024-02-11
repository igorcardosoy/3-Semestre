package model;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filme {
  private String titulo;
  private Diretor diretor;
  private List<Ator> elenco;
  private int anoLancamento;
  private int nota;

  public Filme(String titulo, Diretor diretor, int anoLancamento, int nota) {
    this.titulo = titulo;
    this.diretor = diretor;
    this.anoLancamento = anoLancamento;
    this.nota = nota;
    this.elenco = new ArrayList<>(5);
  }

  public String getTitulo() {
    return titulo;
  }

  public Diretor getDiretor() {
    return diretor;
  }

  public List<Ator> getElenco() {
    return elenco;
  }

  public int getAnoLancamento() {
    return anoLancamento;
  }

  public int getNota() {
    return nota;
  }

  public void addAtor(Ator ator){
    elenco.add(ator);
  }


  @Override
  public String toString() {
    return "Filme{" +
            "titulo='" + titulo + '\'' +
            ", diretor=" + diretor +
            ", elenco=" + elenco +
            ", anoLancamento=" + anoLancamento +
            ", nota=" + nota +
            '}';
  }
}
