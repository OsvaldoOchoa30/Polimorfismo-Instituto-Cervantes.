package org.osvaldoochoa.polimorfismoc3.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.osvaldoochoa.polimorfismoc3.App;
import org.osvaldoochoa.polimorfismoc3.models.Student;
import org.osvaldoochoa.polimorfismoc3.models.Sistema;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;




public class ActualizarEstudianteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonActualizar;


    @FXML
    private Button buttonBuscar;

    @FXML
    private TextField idBuscador;

    @FXML
    private TableView<Student> tableActualizar;

    @FXML
    private TableColumn<Student, String> tableColoumnMatricula;

    @FXML
    private TableColumn<Student, String> tableColumnLastN;

    @FXML
    private TableColumn<Student, String> tableColumnName;

    @FXML
    private TextField textFieldLastName;

    @FXML
    private TextField textFieldMatricula;

    @FXML
    private TextField textFieldName;


    @FXML
    void OnMouseClickedbuttonBuscar(MouseEvent event) {
        Sistema registro = App.getControl();
        if (!registro.getEstudiantes().isEmpty()) {
            tableActualizar.getItems().clear();
            tableActualizar.getItems().addAll(registro.getEstudiantes());

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("La lista esta vacia.");
            alert.showAndWait();
        }
    }



    @FXML
    void onMouseClickedbuttonActualizar(MouseEvent event) {
        Sistema registro = App.getControl();
        String name = textFieldName.getText();
        String apellido = textFieldLastName.getText();
        String matricula = textFieldMatricula.getText();

        if (name.isEmpty() || apellido.isEmpty() || matricula.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Rellene los campos correctamente.");
            alert.showAndWait();
        } else {
            if (!registro.getEstudiantes().isEmpty()) {
                boolean estudianteEncontrado = false;
                for (Student student : registro.getEstudiantes()) {
                    if (name.equals(student.getName())) {
                        student.setFirstName(apellido);
                        student.setMatricula(matricula);
                        estudianteEncontrado = true;
                        textFieldLastName.clear();
                        textFieldLastName.clear();
                        textFieldMatricula.clear();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("¡Los datos sean actualizado correctamente!.");
                        alert.showAndWait();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("No exite el estudiante , no se puede actualizar.");
                        alert.showAndWait();
                    }
                }
                if (estudianteEncontrado) {
                    tableActualizar.getItems().clear();
                    tableActualizar.getItems().addAll(registro.getEstudiantes());
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("No se ha podido actualizar, la lista se encuentra vacia.");
                alert.showAndWait();
            }
        }
    }


    @FXML
    void initialize() {
       idBuscador.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                buscarEstudiantes(newValue);
            }
        });
        configurarColumnas();
    }

    private void buscarEstudiantes(String matricula) {
        Sistema registro = App.getControl();
        ObservableList<Student> estudiantesFiltrados = FXCollections.observableArrayList();
        for (Student estudiante : registro.getEstudiantes()) {
            if (estudiante.getMatricula().contains(matricula)) {
                estudiantesFiltrados.add(estudiante);
            }
        }
        tableActualizar.setItems(estudiantesFiltrados);
        tableActualizar.setItems(estudiantesFiltrados);
        tableActualizar.setItems(estudiantesFiltrados);
    }

    public void configurarColumnas() {
        tableColumnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tableColumnLastN.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        tableColoumnMatricula.setCellValueFactory(cellData -> cellData.getValue().matriculaProperty());
    }



}
