package org.osvaldoochoa.polimorfismoc3.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.osvaldoochoa.polimorfismoc3.App;
import org.osvaldoochoa.polimorfismoc3.models.Student;

public class GuardarEstudianteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonVer;

    @FXML
    private TextField textFieldLlastName;

    @FXML
    private TextField textFieldMatricula;

    @FXML
    private TextField textFieldName;

    @FXML
    void onMouseClickedButtonVer(MouseEvent event) {
        String name = textFieldName.getText();
        String firstName = textFieldLlastName.getText();
        String matricula = textFieldMatricula.getText();

        if (name.isEmpty() || firstName.isEmpty() || matricula.isEmpty()) {
            mostrarAlertaError("Por favor, rellene todos los campos");
        } else {
            mostrarAlerta("Alumno registrado exitosamente");
            Student student = new Student(name, firstName, matricula);
            App.getControl().addAlumno(student);
            App.getControl().addBaseDatos();
            App.getControl().saveAlumno(student);
        }


    }

    @FXML
    void initialize() {
        assert buttonVer != null : "fx:id=\"buttonVer\" was not injected: check your FXML file 'guardarEstudiante-view.fxml'.";
        assert textFieldLlastName != null : "fx:id=\"textFieldLlastName\" was not injected: check your FXML file 'guardarEstudiante-view.fxml'.";
        assert textFieldMatricula != null : "fx:id=\"textFieldMatricula\" was not injected: check your FXML file 'guardarEstudiante-view.fxml'.";
        assert textFieldName != null : "fx:id=\"textFieldName\" was not injected: check your FXML file 'guardarEstudiante-view.fxml'.";

    }

    public void mostrarAlertaError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Exito");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
