package dao;

import model.entity.User;

import java.util.List;

public interface UserDao {

  boolean insert(User user);

  User findUserByEmail(String email);

  User findUserByUsername(String username);

  List<User> findAll();

  void updatePassword(String username, String password);

}
