package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
    private String gender, email, phone, nat;

    public Usuario(String gender, String email) {
        this.gender = gender;
        this.email = email;
    }

    public void mostrarDatos(){
        System.out.println("gender = " + gender);
        System.out.println("email = " + email);
        System.out.println("phone = " + phone);
        System.out.println("nat = " + nat);
    }


}
