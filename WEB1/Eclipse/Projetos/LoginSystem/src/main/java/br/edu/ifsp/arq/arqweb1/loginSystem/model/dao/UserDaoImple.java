package br.edu.ifsp.arq.arqweb1.loginSystem.model.dao;

import java.util.LinkedList;
import java.util.List;

import br.edu.ifsp.arq.arqweb1.loginSystem.model.entities.User;

public class UserDaoImple implements UserDao {
	
	private List<User> userList;
	private static UserDaoImple instance;
	
  private UserDaoImple(){
	    userList = new LinkedList<>();
	    
	    userList.add(new User("igor@gmail.com", "123456"));
	    userList.add(new User("eduardo@gmail.com", "654321"));
  }

  public static UserDao getInstance(){
    if(instance == null){
      instance = new UserDaoImple();
    }

    return instance;
  }


	@Override
	public void save(User newUser) {
		userList.add(newUser);
	}

	@Override
	public User getUser(String email, String password) {

		for (User user : userList) {
			if (user.getEmail().equals(email) && user.validatePassword(password)) {
				return user;
			}
		}
		
		return null;
	}

	@Override
	public void remove(String email, String password) {
		userList.remove(getUser(email, password));
	}

	@Override
	public void update(User newUser, String email, String password) {
		User user = getUser(email, password);
		
		if (user.validatePassword(password)) {
			user = newUser;
			userList.remove(getUser(email, password));
			userList.add(user);
		}
	}
	
	

}
