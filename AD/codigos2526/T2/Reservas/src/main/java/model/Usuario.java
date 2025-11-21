package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private int id;
    private String nombre, correo;
    private int telefono;
    private int idPerfil;

    public Usuario(String nombre, String correo, int telefono, int idPerfil) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.idPerfil = idPerfil;
    }
}
