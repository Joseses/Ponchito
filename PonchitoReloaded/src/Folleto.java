import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Folleto {

    public Menu menuFile;
    public ToggleGroup file;
    public ScrollPane scroller;
    public MenuBar menuBar;
    public RadioMenuItem[] opciones;
    public TableView table;

    public void createMenu(String contexto) {
        Main instancia = Main.getInstance();
        if(contexto.equalsIgnoreCase("agente")) {
            RadioMenuItem sim = new RadioMenuItem("Simulación");
            RadioMenuItem cir = new RadioMenuItem("Crear circuito");
            RadioMenuItem res = new RadioMenuItem("Reservacion");
            sim.setToggleGroup(file);
            cir.setToggleGroup(file);
            res.setToggleGroup(file);
            cir.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent t) {
                    try {
                        //ArrayList<LugarVisitar> lugares = instancia.getLugares();
                        ObservableList<LugarVisitar> data = FXCollections.observableArrayList(instancia.getLugares());
                        TableColumn nombre = new TableColumn("Nombre");
                        nombre.setMinWidth(100);
                        nombre.setCellValueFactory(new PropertyValueFactory<LugarVisitar, String>("nombre"));

                        TableColumn ciudad = new TableColumn("direccion");
                        ciudad.setMinWidth(100);
                        ciudad.setCellValueFactory(
                                new PropertyValueFactory<LugarVisitar, String>("direccion"));

                        TableColumn descripcion = new TableColumn("Descripción");
                        ciudad.setMinWidth(100);
                        ciudad.setCellValueFactory(
                                new PropertyValueFactory<LugarVisitar, String>("descripcion"));

                        TableColumn precio = new TableColumn("Precio");
                        ciudad.setMinWidth(100);
                        ciudad.setCellValueFactory(
                                new PropertyValueFactory<LugarVisitar, Double>("precio"));

                        table.setItems(data);
                        table.getColumns().addAll(nombre, ciudad,descripcion,precio);


                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
            menuFile.getItems().addAll(sim,cir,res);
            opciones = new RadioMenuItem[]{sim, cir, res};
            menuDefaults();
        }
    }

    public void menuDefaults() {
        SeparatorMenuItem separator = new SeparatorMenuItem();
        SeparatorMenuItem separator2 = new SeparatorMenuItem();
        MenuItem cambiarUsuario = new MenuItem("Cambiar usuario");
        MenuItem salir = new MenuItem("Salir");
        salir.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                cerrarPrograma();
            }
        });
        cambiarUsuario.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Main instancia = Main.getInstance();
                try {
                    instancia.gotoMain();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        menuFile.getItems().addAll(separator,cambiarUsuario,separator2,salir);
    }

    public void cerrarPrograma() {
        Main instancia = Main.getInstance();
        instancia.cerrarVentana();
    }

    public void createTable() {
        table.setEditable(true);
        TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn emailCol = new TableColumn("Email");

        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);


    }

}
