package org.example.kebab.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import org.example.kebab.utiles.Alerta;
import org.example.kebab.Clases.Clientes;
import org.example.kebab.DAO.ClientesDAO;
import org.example.kebab.Main;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.util.Optional;

public class LoginController {

    @FXML
    private Button bttnEntrar;

    @FXML
    private Button bttnEliminar;

    @FXML
    private TextField idContrasena;

    @FXML
    private TextField idEmail;



    @FXML
    void onEntrarClick(ActionEvent event) {
        String email=idEmail.getText();
        String contrasena = idContrasena.getText();
        if (email.isEmpty() || contrasena.isEmpty()) {
            Alerta.alertaError("Introduce tu email y contraseña");
        } else {
            String contrasenaEncriptada = DigestUtils.sha256Hex(contrasena);
            Clientes cliente = new Clientes(email, contrasenaEncriptada);


            if (ClientesDAO.buscarCliente(email)) {
                if( ClientesDAO.buscarContrasena(contrasenaEncriptada)){
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));
                        Parent root = fxmlLoader.load();
                        MenuController controller = fxmlLoader.getController();

                        Scene scene = new Scene(root);
                        Stage stage = (Stage) bttnEntrar.getScene().getWindow();
                        stage.setScene(scene);

                    } catch (IOException e) {
                        Alerta.alertaError(e.getMessage());
                    }
                }else {
                    Alerta.alertaError("Contraseña incorrecta");
                }

            } else {
                Alerta.alertaError("No existe ese cliente, Registrate");
            }

        }
    }

    @FXML
    void onRegistrateClick(ActionEvent event) {
        String email=idEmail.getText();
        String contrasena = idContrasena.getText();
        if (email.isEmpty() || contrasena.isEmpty()) {
            Alerta.alertaError("Introduce un email y una contraseña para tu nuevo usuario!!");
        } else {
            String contrasenaEncriptada = DigestUtils.sha256Hex(contrasena);
            Clientes cliente = new Clientes(email, contrasenaEncriptada);

            if (ClientesDAO.buscarCliente(email)) {
                Alerta.alertaError("Ya existe este cliente, Inicia sesion");

            } else {
                if (ClientesDAO.insertarCliente(cliente) == 1) {
                    Alerta.alertaInfo("Cliente creado, Inicia sesion");
                }
            }
        }
    }
    @FXML
    void onEliminarClick(ActionEvent event) {
        String email=idEmail.getText();
        String contrasena = idContrasena.getText();
        if (email.isEmpty() || contrasena.isEmpty()) {
            Alerta.alertaError("Introduce un email y una contraseña para eliminar tu usuario!!");
        } else {
            String contrasenaEncriptada = DigestUtils.sha256Hex(contrasena);
            Clientes cliente = new Clientes(email, contrasenaEncriptada);

            if (ClientesDAO.buscarCliente(email) && ClientesDAO.buscarContrasena(contrasenaEncriptada)) {
                if (ClientesDAO.eliminarCliente(cliente) == 1) {
                    Optional<ButtonType> boton = Alerta.alertaWarning("Quieres eiminar el usuario");
                    if (boton.get() == ButtonType.OK) {
                        Alerta.alertaInfo("Cliente eliminado");
                        idEmail.clear();
                        idContrasena.clear();
                    }
                }
            }
        }
    }
}
