package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {

    private Long id;
    private String name;
    private String mail;
    private int phone;

    public Alumno(String name, String mail, int phone) {
        this.name = name;
        this.mail = mail;
        this.phone = phone;
    }

    public Alumno(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    public void toData(){
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("mail = " + mail);
        System.out.println("phone = " + phone);
    }
}
