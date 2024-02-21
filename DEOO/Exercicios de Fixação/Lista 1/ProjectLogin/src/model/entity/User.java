package model.entity;

public class User {
  private Long userId;
  private String username;
  private String email;
  private String password;

  public User(String username, String email, String password) {
    this.userId = 0L;
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public static boolean autenticateUser(User user, String password){
    if (user == null){
      return false;
    } else return user.getPassword().equals(password);
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
