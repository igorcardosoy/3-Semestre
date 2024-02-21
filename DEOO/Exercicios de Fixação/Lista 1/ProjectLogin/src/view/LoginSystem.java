package view;

import dao.*;
import model.entity.User;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LoginSystem {

  private static final UserDao userDao = UserDaoImple.getInstance();

  public static void Run() {
    String title = "Login";
    Panel panel = new Panel();

    panel.setLayout(new GridLayout(5, 2));

    JButton newUser = new JButton("Novo usuario");
    JButton login = new JButton("Fazer login");
    JButton list = new JButton("Listar usuarios");
    JButton update = new JButton("Atualizar senha");

    List<JButton>  jButtons = List.of(newUser, login, list, update);


    for (JButton jButton : jButtons) {
      panel.add(jButton);
    }

    newUser.addActionListener(e -> newUser());
    login.addActionListener(e -> login());
    list.addActionListener(e -> list());
    update.addActionListener(e -> update());

    JOptionPane.showConfirmDialog(null, panel, title, JOptionPane.OK_CANCEL_OPTION);
  }

  private static void list(){
    String title = "Usuarios";
    Panel panel = new Panel();

    panel.setLayout(new GridLayout(userDao.findAll().size(), 1));

    for (User user : userDao.findAll()){
      panel.add(new Label(user.toString()));
    }

    JOptionPane.showMessageDialog(null, panel, title, JOptionPane.INFORMATION_MESSAGE);
  }

  private static void update(){
    String title = "Atualizar senha";
    Panel panel = new Panel();

    panel.setLayout(new GridLayout(3, 2));

    JTextField username = new JTextField();
    JTextField email = new JTextField();

    panel.add(new Label("Username: "));
    panel.add(username);

    panel.add(new Label("Email: "));
    panel.add(email);

    int result = JOptionPane.showConfirmDialog(null, panel, title, JOptionPane.OK_CANCEL_OPTION);

    if (result == JOptionPane.OK_OPTION){
      User user = userDao.findUserByUsername(username.getText());
      if (user != null && user.getEmail().equals(email.getText())){
        String newPassword = JOptionPane.showInputDialog("Digite a nova senha");
        userDao.updatePassword(username.getText(), newPassword);

        JOptionPane.showMessageDialog(null, "Senha atualizada");
      } else {
        JOptionPane.showMessageDialog(null, "Usuario nao encontrado");
      }
    }
  }

  private static void login(){
    String title = "Login";
    Panel panel = new Panel();

    panel.setLayout(new GridLayout(3, 2));

    JTextField username = new JTextField();
    JTextField password = new JTextField();

    panel.add(new Label("Username: "));
    panel.add(username);

    panel.add(new Label("Password: "));
    panel.add(password);

    int result = JOptionPane.showConfirmDialog(null, panel, title, JOptionPane.OK_CANCEL_OPTION);

    if (result == JOptionPane.OK_OPTION){
      if (User.autenticateUser(userDao.findUserByUsername(username.getText()), password.getText())){
        JOptionPane.showMessageDialog(null, "Usuario logado");
      } else {
        JOptionPane.showMessageDialog(null, "Usuario nao encontrado");
      }
    }
  }

  private static void newUser(){
    User user = newUserLabel();
    if (user != null){
      if (userDao.insert(user)){
        JOptionPane.showMessageDialog(null, "Usuario cadastrado");
      } else {
        JOptionPane.showMessageDialog(null, "Usuario ja cadastrado");
      }
    }
  }

  private static User newUserLabel(){
    String title = "Novo usuario";
    Panel panel = new Panel();

    panel.setLayout(new GridLayout(4, 2));

    JTextField username = new JTextField();
    JTextField email = new JTextField();
    JTextField password = new JTextField();

    panel.add(new Label("Username: "));
    panel.add(username);

    panel.add(new Label("Email: "));
    panel.add(email);

    panel.add(new Label("Password: "));
    panel.add(password);

    int result = JOptionPane.showConfirmDialog(null, panel, title, JOptionPane.OK_CANCEL_OPTION);

    if (result == JOptionPane.OK_OPTION){
      return new User(username.getText(), email.getText(), password.getText());
    } else {
      return null;
    }
  }
}
