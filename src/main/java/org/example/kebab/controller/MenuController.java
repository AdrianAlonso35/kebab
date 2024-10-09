package org.example.kebab.controller;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.kebab.utiles.Alerta;
import org.example.kebab.Main;

import java.io.IOException;


public class MenuController {

    @FXML
    private Button bttnAtras;

    @FXML
    private Button bttnIngresos;

    @FXML
    private Button bttnPedido;

    @FXML
    void onAtrasClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource( "login.fxml"));
            Parent root = fxmlLoader.load();
            LoginController controller = fxmlLoader.getController();

            Scene scene = new Scene(root);
            Stage stage = (Stage) bttnAtras.getScene().getWindow();
            stage.setScene(scene);
        }catch (IOException e){
            Alerta.alertaError(e.getMessage());
        }

    }

    @FXML
    void onIngresosClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource( "login.fxml"));
            Parent root = fxmlLoader.load();
            LoginController controller = fxmlLoader.getController();

            Scene scene = new Scene(root);
            Stage stage = (Stage) bttnIngresos.getScene().getWindow();
            stage.setScene(scene);
        }catch (IOException e){
            Alerta.alertaError(e.getMessage());
        }
    }

    @FXML
    void onPedidoClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource( "pedido.fxml"));
            Parent root = fxmlLoader.load();
            PedidoController controller = fxmlLoader.getController();

            Scene scene = new Scene(root);
            Stage stage = (Stage) bttnPedido.getScene().getWindow();
            stage.setScene(scene);
        }catch (IOException e){
            Alerta.alertaError(e.getMessage());
        }
    }

}
