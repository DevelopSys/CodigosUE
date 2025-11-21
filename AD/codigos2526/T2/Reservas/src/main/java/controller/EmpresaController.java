package controller;

import dao.UsuarioDAOImp;
import model.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmpresaController {

    private UsuarioDAOImp usuarioDAOImp;

    public void darAltaUsuario(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        String correo = "";
        boolean fallo = false;

        usuarioDAOImp = new UsuarioDAOImp();
        // aplico la logica del negocio
        // compruebo si tengo guardada toda la documentacion antes de darle de alta
        // envio los papeles a la SS para que conste en alta
        // envio a la gestoria toda la documentacion
        // lo guardo en base de datos
        do {
            try {
                if (fallo) {
                    usuario.setCorreo(correo);
                }
                usuarioDAOImp.insertarUsuario(usuario);
                fallo = false;
            } catch (SQLException e) {
                System.out.println("Correo duplicado");
                System.out.println("Indica un correo nuevo");
                correo = scanner.next();
                fallo = true;
            }
        } while (fallo);

        System.out.println("Usuario insertado correctamente");

    }

    public void despedirUsuario() {

    }

    public void buscarUsuario() {
        // logica de negocio de obtencio de los usuarios
        usuarioDAOImp = new UsuarioDAOImp();
        ArrayList<Usuario> lista = usuarioDAOImp.listarUsuarios();
        // mando un correo a todos los usuarios
        for (Usuario item : lista) {
            System.out.println(item);
        }
    }
}
