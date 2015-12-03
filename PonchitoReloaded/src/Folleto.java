import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;

import java.util.ArrayList;

public class Folleto {

    public Menu menuFile;
    public ToggleGroup file;
    public ScrollPane scroller;
    public MenuBar menuBar;
    public RadioMenuItem[] opciones;

    public void createMenu(String contexto) {
        if(contexto.equalsIgnoreCase("agente")) {
            RadioMenuItem sim = new RadioMenuItem("Simulación");
            RadioMenuItem cir = new RadioMenuItem("Crear circuito");
            RadioMenuItem res = new RadioMenuItem("Reservacion");
            sim.setToggleGroup(file);
            cir.setToggleGroup(file);
            res.setToggleGroup(file);
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

}
