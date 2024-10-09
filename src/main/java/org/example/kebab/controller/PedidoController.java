package org.example.kebab.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.kebab.utiles.Alerta;
import org.example.kebab.Clases.Productos;
import org.example.kebab.DAO.ProductosDAO;
import org.example.kebab.Main;

import java.io.IOException;
import java.util.ArrayList;

public class PedidoController {

    @FXML
    private Button bttnHacerPedido;

    @FXML
    private Button bttnAtras;

    @FXML
    private ToggleGroup conjunto;

    @FXML
    private ToggleGroup conjuntoBebida;

    @FXML
    private RadioButton tg2Agua;


    @FXML
    private CheckBox cbPatatas;


    @FXML
    private RadioButton tg2CocaCola;

    @FXML
    private RadioButton tg2Sprite;

    @FXML
    private RadioButton tgDurum;

    @FXML
    private RadioButton tgKebab;

    @FXML
    private RadioButton tgLahmacun;

    @FXML
    private RadioButton tgPatatasCarne;

    @FXML
    void onHacerPedidoClick(ActionEvent event) {
        ArrayList<Productos> listaProductos =new ArrayList<>();
        if (conjunto.getSelectedToggle()==null||conjuntoBebida.getSelectedToggle()==null){
            Alerta.alertaError("Elige un plato y una bebida");

        }else {
            String kebab= "kebab";
            String durum="durum";
            String lahmacun="lahmacun";
            String patatasConCarne="patatas con carne";
            String sprite="sprite";
            String cocaCola="coca cola";
            String agua="agua";

            String nombrePlato="";
            double precioPlato;
            String nombreBebida="";
            double precioBebida;
            Productos productos;


            try {
                if (tgDurum.isSelected()){
                    nombrePlato = durum;
                    precioPlato = ProductosDAO.buscarPrecioPlato(nombrePlato);

                } else if (tgKebab.isSelected()) {
                    nombrePlato= kebab;
                    precioPlato= ProductosDAO.buscarPrecioPlato(nombrePlato);

                } else if (tgLahmacun.isSelected()) {
                    nombrePlato = lahmacun;
                    precioPlato = ProductosDAO.buscarPrecioPlato(nombrePlato);

                } else {
                    nombrePlato = patatasConCarne;
                    precioPlato= ProductosDAO.buscarPrecioPlato(nombrePlato);
                }

                if (tg2Sprite.isSelected()){
                    nombreBebida = sprite;
                    precioBebida= ProductosDAO.buscarPrecioBebida(nombreBebida);

                } else if (tg2CocaCola.isSelected()) {
                    nombreBebida= cocaCola;
                    precioBebida= ProductosDAO.buscarPrecioBebida(nombreBebida);

                } else {
                    nombreBebida = agua;
                    precioBebida = ProductosDAO.buscarPrecioBebida(nombreBebida);
                    System.out.println(precioBebida);

                }
                boolean patatas;
                if (cbPatatas.isSelected()){
                    patatas = true;
                }else {
                    patatas = false;
                }
                productos = new Productos(nombrePlato,precioPlato, nombreBebida, precioBebida,patatas);
                listaProductos.add(productos);
                System.out.println(listaProductos);
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource( "ticket.fxml"));
                Parent root = fxmlLoader.load();
                TicketController ticketController = fxmlLoader.getController();
                ticketController.metod(listaProductos);
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();
            }catch (IOException e){
                System.out.println(e.getMessage());;
            }
        }

    }

    @FXML
    void onAtrasClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
            Stage stage = (Stage) bttnAtras.getScene().getWindow();
            stage.setScene(scene);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
