package org.osvaldoochoa.polimorfismoc3.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.osvaldoochoa.polimorfismoc3.App;

public class PrincipalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonActualizar;

    @FXML
    private Button buttonGuardar;

    @FXML
    private Button buttonVer;

    @FXML
    void onMouseClickedGuardarButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("guardarEstudiante-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void onMouseClickedbuttonActualizar(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("actualizarEstudiante-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }


    @FXML
    void onMouseClickedbuttonVer(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("verEstudiantes-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void initialize() {
        assert buttonActualizar != null : "fx:id=\"buttonActualizar\" was not injected: check your FXML file 'principal-view.fxml'.";
        assert buttonGuardar != null : "fx:id=\"buttonGuardar\" was not injected: check your FXML file 'principal-view.fxml'.";
        assert buttonVer != null : "fx:id=\"buttonVer\" was not injected: check your FXML file 'principal-view.fxml'.";
    }
}


