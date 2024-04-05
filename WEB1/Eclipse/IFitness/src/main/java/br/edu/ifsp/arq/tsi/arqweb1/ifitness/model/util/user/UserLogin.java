package br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.util.user;

import java.util.List;

import br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.User;

public class UserLogin {

	private UserLogin() {}

	public static User login(String email, String password) throws UserNotFoundException {
		List<User> users = UsersReader.read();

		if (users != null) {
			for (User user : users) {
				if (user.getEmail().equals(email) && user.getPassword().equals(PasswordEncrypt.encrypt(password))) {
					return user;
				}
			}
		}
		
		throw new UserNotFoundException("User not found");
	}

}
