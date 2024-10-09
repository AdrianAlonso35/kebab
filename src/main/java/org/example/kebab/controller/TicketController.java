package org.example.kebab.controller;

import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.kebab.Clases.Productos;
import org.example.kebab.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TicketController {


    @FXML
    private Button bttnAtras;

    @FXML
    private TextArea txtaTicket;

    @FXML
    private Button bttnMostrar;

    @FXML
    private TableView<Productos> tbTabla;

    @FXML
    private TableColumn<Productos, String> tcBebida;

    @FXML
    private TableColumn<Productos, String> tcPatatas;

    @FXML
    private TableColumn<Productos, String> tcPlato;

    @FXML
    private TableColumn<Productos, Double> tcPrecioBebida;

    @FXML
    private TableColumn<Productos, Double> tcPrecioPlato;

    @FXML
    private TableColumn<Double, Double> tcTotal;

    ArrayList<Productos> listaProductos2;


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
    @FXML
    void onMostrarClick(ActionEvent event) {

        for (Productos productos : listaProductos2) {
            if (productos.isPatatas()){
                txtaTicket.setText("Plato: "+ productos.getNombrePlato()+ "........"+productos.getPrecioPlato()+"€\nBebida: "+ productos.getNombreBebida()+"........"+productos.getPrecioBebida()+ "€\nPatatas: Si........2.0€" );
            }else {
                txtaTicket.setText("Plato: "+ productos.getNombrePlato()+ "........"+productos.getPrecioPlato()+"€\nBebida: "+ productos.getNombreBebida()+"........"+productos.getPrecioBebida()+"€");
            }
        }
    }
    void metod(ArrayList<Productos> productos2)  {
        listaProductos2 = productos2;
        double total=0;
        for (Productos productos : listaProductos2) {
            if (productos.isPatatas()){
                total= productos.getPrecioPlato() + productos.getPrecioBebida()+ 2.0;
            }else {
                total= productos.getPrecioPlato() + productos.getPrecioBebida();
            }
            productos.setTotal(total);
        }
        cargarTabla();

    }
    public void initialize() {



        tcPlato.setCellValueFactory(new PropertyValueFactory<>("nombrePlato"));
        tcPrecioPlato.setCellValueFactory(new PropertyValueFactory<>("precioPlato"));
        tcBebida.setCellValueFactory(new PropertyValueFactory<>("nombreBebida"));
        tcPrecioBebida.setCellValueFactory(new PropertyValueFactory<>("precioBebida"));
        tcPatatas.setCellValueFactory(data->new ReadOnlyObjectWrapper<>((data.getValue().isPatatas())?"Si":"No"));
        tcTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

    }
    public  void cargarTabla(){
        ObservableList<Productos> productosObservableList = FXCollections.observableList(listaProductos2);
        tbTabla.setItems(productosObservableList);
    }


}
