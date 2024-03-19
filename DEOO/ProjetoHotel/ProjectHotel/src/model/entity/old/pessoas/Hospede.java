package model.entity.old.pessoas;

import model.entity.old.Indentificacao;
import model.enums.Estados;
import model.enums.TipoDoc;
import model.enums.TipoItens;
import model.itensCosumo.Consumo;
import model.itensCosumo.ItensConsumo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hospede extends Pessoa {

  // Atributos específicos da classe Hospede
  private String pais;
  private String email;
  private Indentificacao identificacao;
  private String nomeMae;
  private String nomePai;
  private double gastosTelefonicos;
  private List<Consumo> dadosConsumo;
  private List<Consumo> dadosConsumoFrigobar;
  private List<ItensConsumo> itensComprados;
  private Funcionario funcionarioResponsavel;
  private boolean acomodado;

  public Hospede(String nome, int telefone, String cidade, Estados estado, LocalDate dataNascimento, String pais,
                 String email, TipoDoc tipoDoc, int numDoc, String nomeMae, String nomePai, Funcionario funcionarioResponsavel, int senha){
    // Chamando o construtor da classe pai (Pessoa)
    super(nome, telefone, cidade, estado, dataNascimento, senha);
    // Inicializando os atributos específicos da classe Hospede
    this.pais = pais;
    this.email = email;
    this.identificacao = new Indentificacao(numDoc, tipoDoc);
    this.nomeMae = nomeMae;
    this.nomePai = nomePai;
    gastosTelefonicos = 0;
    // Inicializando listas
    this.funcionarioResponsavel = funcionarioResponsavel;
    setItensComprados();
    setDadosConsumo();
  }

  /**
   * Método privado para inicializar a lista de itens comprados
   */
  private void setItensComprados() {
    this.itensComprados = new ArrayList<>(5);
  }

  public boolean isAcomodado() {
    return acomodado;
  }

  public void setAcomodado(boolean acomodado) {
    this.acomodado = acomodado;
  }

  /**
   * Método privado para inicializar as listas de consumo
   */
  private void setDadosConsumo() {
    this.dadosConsumo = new ArrayList<>(5);
    this.dadosConsumoFrigobar = new ArrayList<>(5);
  }

  /**
   * Método privado para verificar se o usuário tem permissão para editar
   * @param key senha do usuário
   * @return true se a senha estiver correta, false caso contrario.
  */
  private boolean canEdit(int key) {
    return key == this.getKey();
  }

  /**
   * Método para registrar o consumo de um item
   * @param dataDoConsumo data do consumo
   * @param nomeFuncionario nome do funcionário
   * @param qntConsumida quantidade consumida
   * @param valorUnitario valor unitário
   * @param codigoItem código do item
   * @param listaItensConsumo lista de itens de consumo
   */
  public void consumirItem(LocalDateTime dataDoConsumo, String nomeFuncionario, int qntConsumida, double valorUnitario,
                           int codigoItem, List<ItensConsumo> listaItensConsumo) {
    ItensConsumo itemConsumido = null;

    // Procura o item na lista de itens disponíveis
    for (ItensConsumo item : listaItensConsumo) {
      if (item.getCodigo() == codigoItem) {
        itemConsumido = item;
        break;
      }
    }

    // Se o item foi encontrado, registra o consumo na lista apropriada
    if (itemConsumido != null) {
      if (itemConsumido.getTipo() == TipoItens.FRIGOBAR) {
        dadosConsumoFrigobar.add(new Consumo(dataDoConsumo, nomeFuncionario, codigoItem, qntConsumida, valorUnitario));
      } else {
        dadosConsumo.add(new Consumo(dataDoConsumo, nomeFuncionario, codigoItem, qntConsumida, valorUnitario));
      }
    }
  }

  public boolean removerItem(ItensConsumo item, int key) {
    // Verifica se o usuário tem permissão para remover itens
    if (canEdit(key)) {
      return itensComprados.remove(item);
    }
    return false;
  }

  public void contabilizarItens() {
      dadosConsumo.addAll(dadosConsumoFrigobar);
      dadosConsumoFrigobar.clear();
  }

  public List<Consumo> getConsumo() {
    return dadosConsumo;
  }

  public List<Consumo> getConsumoFrigobar() {
    return dadosConsumoFrigobar;
  }

  public String getPais() {
    return pais;
  }

  public String getEmail() {
    return email;
  }

  public int getIdentificacaoNumero() {
    return identificacao.getNumero();
  }

  public double getGastosTelefonicos() {
    return gastosTelefonicos;
  }

  public String getIdentificacaoTipo() {
    return identificacao.getTipo();
  }

  public String getNomeMae() {
    return nomeMae;
  }

  public String getNomePai() {
    return nomePai;
  }

  public Funcionario getFuncionarioResponsavel() {
    return funcionarioResponsavel;
  }

  public List<ItensConsumo> getItensComprados() {
    return itensComprados;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setIdentificacao(Indentificacao identificacao) {
    this.identificacao = identificacao;
  }

  public void setNomeMae(String nomeMae) {
    this.nomeMae = nomeMae;
  }

  public void setNomePai(String nomePai) {
    this.nomePai = nomePai;
  }

  public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
    this.funcionarioResponsavel = funcionarioResponsavel;
  }

  public Indentificacao getIdentificacao() {
    return this.identificacao;
  }

  @Override
  protected boolean password(int key) {
    return key == this.getKey();
  }

  @Override
  public String toString() {
    return "Hospede: " + super.getNome() + "\nTelefone: " + super.getTelefone() + "\nCidade: " + super.getCidade()
            + "\nEstado: " + super.getEstado() + "\nData de Nascimento: " + super.getDataNascimento().format(formatterData);


  }

}
