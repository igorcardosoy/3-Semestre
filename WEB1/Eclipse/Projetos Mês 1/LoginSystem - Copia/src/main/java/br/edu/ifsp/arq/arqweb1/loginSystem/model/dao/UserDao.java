package br.edu.ifsp.arq.arqweb1.loginSystem.model.dao;

import br.edu.ifsp.arq.arqweb1.loginSystem.model.entities.User;

public interface UserDao {
	
	public void save(User newUser);

	public User getUser(String email, String password);

	public void remove(String email, String password);

	public void update(User newUser, String email, String password);
	
}
