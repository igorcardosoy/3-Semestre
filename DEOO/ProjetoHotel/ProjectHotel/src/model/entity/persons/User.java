package model.entity.persons;

import model.entity.persons.Utils.Address;
import model.entity.persons.Utils.Password;
import model.entity.persons.Utils.Phone;

import java.time.LocalDate;

public abstract class User {

    private final String name;
    private final Address address;
    private final Phone telephone;
    private final LocalDate birthDate;
    private final Password password;

    public User(String name, Address address, Phone telephone, LocalDate birthDate, String password) {
        this.name = name;
        this.address = new Address(address);
        this.telephone = new Phone(telephone);
        this.birthDate = LocalDate.parse(birthDate.toString());
        this.password = new Password(password);
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Phone getTelephone() {
        return telephone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public boolean authenticate(String pwd){
        return password.authenticate(pwd);
    }

    public boolean changePassword(String oldPwd, String newPwd){
        if(authenticate(oldPwd)){
            password.changePassword(newPwd);
            return true;
        }
        return false;
    }
}