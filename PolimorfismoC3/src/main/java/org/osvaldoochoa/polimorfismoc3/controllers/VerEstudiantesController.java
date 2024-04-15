package org.osvaldoochoa.polimorfismoc3.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.osvaldoochoa.polimorfismoc3.App;
import org.osvaldoochoa.polimorfismoc3.models.Sistema;
import org.osvaldoochoa.polimorfismoc3.models.Student;

public class VerEstudiantesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField matriculaBuscarText;

    @FXML
    private TableView<Student> tableBDD1;

    @FXML
    private TableView<Student> tableBDD2;

    @FXML
    private TableView<Student> tableBDD3;

    @FXML
    private TableColumn<Student, String> tableColumnBDD1LastN;

    @FXML
    private TableColumn<Student, String> tableColumnBDD1matricula;

    @FXML
    private TableColumn<Student, String> tableColumnBDD1name;

    @FXML
    private TableColumn<Student, String> tableColumnBDD2LastN;

    @FXML
    private TableColumn<Student, String> tableColumnBDD2matricula;

    @FXML
    private TableColumn<Student, String> tableColumnBDD2name;

    @FXML
    private TableColumn<Student, String> tableColumnBDD3lastN;

    @FXML
    private TableColumn<Student, String> tableColumnBDD3matricula;

    @FXML
    private TableColumn<Student, String> tableColumnBDD3name;

    @FXML
    private Button verButton;

    @FXML
    void onMouseClickedVerButton(MouseEvent event) {
        Sistema registro = App.getControl();
        if (!registro.getEstudiantes().isEmpty()) {

            tableBDD1.getItems().clear();
            tableBDD1.getItems().addAll(registro.getEstudiantes());

            tableBDD2.getItems().clear();
            tableBDD2.getItems().addAll(registro.getEstudiantes());

            tableBDD3.getItems().clear();
            tableBDD3.getItems().addAll(registro.getEstudiantes());
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("La lista se encuentra vacia.");
            alert.showAndWait();
        }

    }

    @FXML
    void initialize() {
        matriculaBuscarText.textProperty().addListener(new ChangeListener<String>() {
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
        tableBDD1.setItems(estudiantesFiltrados);
        tableBDD2.setItems(estudiantesFiltrados);
        tableBDD3.setItems(estudiantesFiltrados);
    }

    private void configurarColumnas() {
        tableColumnBDD1name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tableColumnBDD1LastN.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        tableColumnBDD1matricula.setCellValueFactory(cellData -> cellData.getValue().matriculaProperty());


        tableColumnBDD2name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tableColumnBDD2LastN.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        tableColumnBDD2matricula.setCellValueFactory(cellData -> cellData.getValue().matriculaProperty());


        tableColumnBDD3name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tableColumnBDD3lastN.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
       tableColumnBDD3matricula.setCellValueFactory(cellData -> cellData.getValue().matriculaProperty());
    }

}
