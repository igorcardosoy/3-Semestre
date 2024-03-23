package model.entity.persons;

import model.entity.Identification.Identification;
import model.entity.persons.Utils.Address;
import model.entity.persons.Utils.Phone;

import java.time.LocalDate;

public class Guest extends User {

    private String email;
    private Identification identification;
    private String motherName;
    private String fatherName;

    public Guest(String name, LocalDate birthDate, Address address, Phone phone, String password, String email, Identification identification, String motherName, String fatherName) {
        super(name, address, phone, birthDate, password);
        this.email = email;
        this.identification = identification;
        this.motherName = motherName;
        this.fatherName = fatherName;
    }

}
