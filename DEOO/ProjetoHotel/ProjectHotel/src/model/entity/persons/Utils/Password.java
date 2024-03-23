package model.entity.persons.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public final class Password {

    private String password;

    public Password(String pwd){
        password = hashPassword(pwd);
    }

    public boolean authenticate(String pwd){
        return password.equals(hashPassword(pwd));
    }

    private static String hashPassword(String pwd){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(pwd.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void changePassword(String newPwd) {
        password = hashPassword(newPwd);
    }
}
