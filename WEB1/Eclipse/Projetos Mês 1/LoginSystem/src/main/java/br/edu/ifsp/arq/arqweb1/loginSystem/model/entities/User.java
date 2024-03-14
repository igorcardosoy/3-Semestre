package br.edu.ifsp.arq.arqweb1.loginSystem.model.entities;

public class User {
	
	private String email;
	private String password;

	public User(String email, String password) {	
        this.email = email;
        this.password = password;
	}
	
	public Boolean validatePassword(String password) {
		return this.password.equals(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return email;
	}
	
	

}
