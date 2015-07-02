package com.annamukhina.model.entities;

import com.annamukhina.view.Constants;

import java.util.Date;

/**
 * @author anna_mukhina
 */
public class Client {
    public static int lastID = 0;
    private final int id;
    private final String surname;
    private final String name;
    private final String middleName;
    private Date dateOfBirth;

    public Client(String surname, String name, String middleName, Date dateOfBirth) {
        lastID++;
        this.id = lastID;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return id + " " + surname + " " + name + " " + middleName + " " + Constants.FORMAT.format(dateOfBirth);
    }
}
