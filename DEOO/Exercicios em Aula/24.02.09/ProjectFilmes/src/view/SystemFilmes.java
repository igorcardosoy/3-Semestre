package view;

import model.Engine;

import java.util.Scanner;

public class SystemFilmes {

  private static final Engine engine = new Engine();
  private static final Scanner scanner = new Scanner(System.in);

  public static void Start(){

    int escolha;

    do {
      escolha = menu();
    }while (switchMenu(escolha));
  }


  public static boolean switchMenu(int escolha){
    switch (escolha) {
      case 1:
        addFilmeForm();
        break;
      case 2:
        listarFilmes();
        break;
      case 3:
        listarDiretores();
        break;
      case 4:
        listarAtores();
        break;
      case 5:
        listarFilmesDiretor();
        break;
      case 6:
        listarFilmesAtor();
        break;
      case 7:
        listarFilmesNota();
        return false;
    }

    return true;
  }

  private static void listarFilmesNota() {
    System.out.println("Digite a nota: ");
    int nota = scanner.nextInt();
    for (int i = 0; i < engine.getFilmes().size(); i++) {
      if (engine.getFilmes().get(i).getNota() == nota) {
        System.out.println(engine.getFilmes().get(i).toString());
      }
    }
  }

  private static void listarFilmesAtor() {
    scanner.nextLine();
    System.out.println("Digite o nome do ator: ");
    String nomeAtor = scanner.nextLine();
    for (int i = 0; i < engine.getFilmes().size(); i++) {
      for (int j = 0; j < engine.getFilmes().get(i).getElenco().size(); j++) {
        if (engine.getFilmes().get(i).getElenco().get(j).getNome().equals(nomeAtor)) {
          System.out.println(engine.getFilmes().get(i).toString());
        }
      }
    }
  }

  private static void listarFilmesDiretor() {
    scanner.nextLine();
    System.out.println("Digite o nome do diretor: ");
    String nomeDiretor = scanner.nextLine();
    for (int i = 0; i < engine.getFilmes().size(); i++) {
      if (engine.getFilmes().get(i).getDiretor().getNome().equals(nomeDiretor)) {
        System.out.println(engine.getFilmes().get(i).toString());
      }
    }
  }

  private static void listarAtores() {
    for (int i = 0; i < engine.getAtores().size(); i++) {
      System.out.println(engine.getAtores().get(i).toString());
    }
  }

private static void listarDiretores() {
    for (int i = 0; i < engine.getDiretores().size(); i++) {
      System.out.println(engine.getDiretores().get(i).toString());
    }
  }

  private static void listarFilmes(){
    for (int i = 0; i < engine.getFilmes().size(); i++) {
      System.out.println(engine.getFilmes().get(i).toString());
    }
  }

  private static void addFilmeForm(){

    scanner.nextLine();

    System.out.println("Digite o titulo do filme: ");
    String titulo = scanner.nextLine();

    System.out.println("Digite o nome do diretor: ");
    String nomeDiretor = scanner.nextLine();

    System.out.println("Digite o ano de lançamento: ");
    int anoLancamento = scanner.nextInt();

    System.out.println("Digite a nota: ");
    int nota = scanner.nextInt();

    engine.addFilme(titulo, nomeDiretor, anoLancamento, nota);

    System.out.println("Digite a quantidade de atores: ");
    int qtdAtores = scanner.nextInt();



    for (int i = 0; i < qtdAtores; i++) {

      scanner.nextLine();

      System.out.println("Digite o nome do ator: ");
      String nomeAtor = scanner.nextLine();

      System.out.println("Digite o ano de nascimento: ");
      int anoNascimento = scanner.nextInt();

      engine.addAtor(nomeAtor, anoNascimento);
    }

  }

  private static int menu() {

    System.out.println("1 - Adicionar Filme");
    System.out.println("2 - Listar filmes");
    System.out.println("3 - Listar diretores");
    System.out.println("4 - Listar atores");
    System.out.println("5 - Listar filmes de um diretor");
    System.out.println("6 - Listar filmes de um ator");
    System.out.println("7 - Listar filmes por nota");
    System.out.println("8 - Sair");

    return scanner.nextInt();
  }
}
