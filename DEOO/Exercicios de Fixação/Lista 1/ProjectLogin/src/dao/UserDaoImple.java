package dao;

import model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImple implements UserDao{

  private final List<User> userList;
  private static UserDaoImple instance;

  private UserDaoImple(){
    userList = new ArrayList<>(5);
  }

  public static UserDao getInstance(){
    if(instance == null){
      instance = new UserDaoImple();
    }

    return instance;
  }

  @Override
  public boolean insert(User user) {
    if (user != null){
      if (findUserByEmail(user.getEmail()) == null && findUserByUsername(user.getUsername()) == null){
        userList.add(user);
        return true;
      }
    }

    return false;
  }

  @Override
  public List<User> findAll(){

    if (!userList.isEmpty()){
      return userList;
    }

    return null;
  }

  @Override
  public User findUserByEmail(String email) {
    for (User u : userList){
      if (u.getEmail().equals(email)){
        return u;
      }
    }

    return null;
  }

  @Override
  public User findUserByUsername(String username) {
    for (User u : userList){
      if (u.getUsername().equals(username)){
        return u;
      }
    }

    return null;
  }

  @Override
  public void updatePassword(String username, String newPassword) {
     int index = 0;

    for (User u : userList){
      if (u.getUsername().equals(username)){
        u.setPassword(newPassword);
        userList.set(index, u);
      }

      index++;
    }
  }
}
