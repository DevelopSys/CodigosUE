package org.example.inicio;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField campoNombre;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Perfecto "+campoNombre.getText()+", has completado la tarea!");
    }
}