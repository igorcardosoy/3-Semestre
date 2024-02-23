package view;

import dto.ProductDto;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Utils {

  private Utils(){}

  public static MenuOption menu() {
    int option;
    String[] options = {"Cadastrar", "Atualizar", "Listar", "Remover", "Sair"};

    option = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "Sair");

    return MenuOption.values()[option];
  }

  public static ProductDto readProduct() {
    Panel panel = new Panel();

    panel.setLayout(new GridLayout(4, 1));

    JTextField name = new JTextField();
    JTextField description = new JTextField();
    JTextField price = new JTextField();
    JTextField amount = new JTextField();

    panelForm(panel, name, description, price, amount);

    int option = JOptionPane.showConfirmDialog(null, panel, "Cadastrar produto", JOptionPane.OK_CANCEL_OPTION);

    if (option == JOptionPane.OK_OPTION) {
      return new ProductDto(name.getText(), description.getText(), Double.parseDouble(price.getText()), Integer.parseInt(amount.getText()));
    }

    return null;
  }

  private static void panelForm(Panel panel, JTextField name, JTextField description, JTextField price, JTextField amount) {
    panel.add(new Label("Nome:"));
    panel.add(name);

    panel.add(new Label("Descrição:"));
    panel.add(description);

    panel.add(new Label("Preço:"));
    panel.add(price);

    panel.add(new Label("Quantidade:"));
    panel.add(amount);
  }


  public static void showMensage(String msg) {
    JOptionPane.showMessageDialog(null, msg);
  }

  public static ProductDto readUpdate() {
    Panel panel = new Panel();

    panel.setLayout(new GridLayout(5, 1));

    JTextField identifier = new JTextField();
    JTextField name = new JTextField();
    JTextField description = new JTextField();
    JTextField price = new JTextField();
    JTextField amount = new JTextField();

    panel.add(new Label("Identificador:"));
    panel.add(identifier);

    panelForm(panel, name, description, price, amount);

    int option = JOptionPane.showConfirmDialog(null, panel, "Atualizar produto", JOptionPane.OK_CANCEL_OPTION);

    if (option == JOptionPane.OK_OPTION) {
      return new ProductDto(name.getText(), description.getText(), Double.parseDouble(price.getText()), Integer.parseInt(amount.getText()), Integer.parseInt(identifier.getText()));
    }

    return null;
  }

  public static void showList(List<ProductDto> allProducts) {
    StringBuilder sb = new StringBuilder();

    sb.append("------------------------------------------------------------------------\n");

    for (ProductDto product : allProducts) {
      String priceStr = String.format("%.2f", product.price);

      sb.append("Produto: ").append(product.name).append("\n");
      sb.append("Descrição: ").append(product.description).append("\n");
      sb.append("Preço: R$ ").append(priceStr).append("\n");
      sb.append("Quantidade: ").append(product.amount).append("\n");
      sb.append("Identificador: ").append(product.identifier).append("\n");
      sb.append("------------------------------------------------------------------------\n");
    }

    JTextArea textArea = new JTextArea(sb.toString());
    textArea.setEditable(false);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setFont(new Font("Arial", Font.PLAIN, 14));
    textArea.setMargin(new Insets(10, 10, 10, 10));

    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setPreferredSize(new Dimension(400, 300));

    Panel panel = new Panel();
    panel.add(scrollPane);

    JOptionPane.showMessageDialog(null, panel, "Produtos", JOptionPane.PLAIN_MESSAGE);
  }

  public static int removeProduct() {
    Panel panel = new Panel();

    panel.setLayout(new GridLayout(1, 1));

    JTextField identifier = new JTextField();

    panel.add(new Label("Identificador:"));
    panel.add(identifier);

    int option = JOptionPane.showConfirmDialog(null, panel, "Remover produto", JOptionPane.OK_CANCEL_OPTION);

    if (option == JOptionPane.OK_OPTION) {
      return Integer.parseInt(identifier.getText());
    }

    return -1;
  }
}
