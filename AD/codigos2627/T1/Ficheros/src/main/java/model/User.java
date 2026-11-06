package model;

import java.io.Serializable;

public class User implements Serializable {

    private static final Long serialVersionUID = 1L;

    private String name, surname,mail;

    public User() {
    }

    public User(String name, String surname, String mail) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
    }

    public void showData(){
        System.out.println("name = " + name);
        System.out.println("surname = " + surname);
        System.out.println("mail = " + mail);
    }
    public String toCSV(){
        return String.format("%s,%s,%s",name,surname,mail);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
