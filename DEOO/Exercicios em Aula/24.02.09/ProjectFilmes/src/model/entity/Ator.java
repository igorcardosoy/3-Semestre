package model.entity;

public class Ator extends Pessoa{
  private int anoNascimento;
  
    public Ator(String nome, int anoNascimento) {
        super(nome);
        this.anoNascimento = anoNascimento;
    }
    
    public int getAnoNascimento() {
        return anoNascimento;
    }
    
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
}
