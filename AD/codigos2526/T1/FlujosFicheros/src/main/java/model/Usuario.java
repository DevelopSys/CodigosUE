package model;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
    private static Long serialVersionUID = 1L;
    private int id;
    private String nombre, apellido, correo, dni;
    private int telefono;
    public Usuario(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
