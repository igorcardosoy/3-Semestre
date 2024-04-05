package dto.persons;

import dto.persons.Utils.Address;
import dto.persons.Utils.Phone;

import java.time.LocalDate;

public class Employee extends User {


    public Employee(String name, Address address, Phone telephone, LocalDate birthDate, String password) {
        super(name, address, telephone, birthDate, password);
    }
}
