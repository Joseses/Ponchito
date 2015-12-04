import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.util.Callback;

import java.io.File;
import java.sql.SQLException;

public class Folleto {

    private static final DataFormat SERIALIZED_MIME_TYPE = new DataFormat("application/x-java-serialized-object");
    public Menu menuFile;
    public ToggleGroup file;
    public ScrollPane scroller;
    public MenuBar menuBar;
    public RadioMenuItem[] opciones;
    public TableView table;
    public TableView circuitTable;

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

                        TableColumn ciudad = new TableColumn("Ciudad");
                        ciudad.setCellValueFactory(new PropertyValueFactory<LugarVisitar, String>("ciudad"));

                        TableColumn pais = new TableColumn("País");
                        pais.setCellValueFactory(
                                new PropertyValueFactory<LugarVisitar, String>("pais"));

                        TableColumn descripcion = new TableColumn("Descripción");
                        descripcion.setCellValueFactory(
                                new PropertyValueFactory<LugarVisitar, String>("descripcion"));

                        TableColumn precio = new TableColumn("Precio");
                        precio.setCellValueFactory(
                                new PropertyValueFactory<LugarVisitar, Double>("precio"));

                        table.setItems(data);
                        table.getColumns().addAll(nombre, ciudad, pais, descripcion,precio);
                        table.setEditable(true);

                        table.setRowFactory(tv -> {
                            TableRow<LugarVisitar> row = new TableRow<>();

                            row.setOnDragDetected(event -> {
                                if (! row.isEmpty()) {
                                    Integer index = row.getIndex();
                                    Dragboard db = row.startDragAndDrop(TransferMode.MOVE);
                                    db.setDragView(row.snapshot(null, null));
                                    ClipboardContent cc = new ClipboardContent();
                                    cc.put(SERIALIZED_MIME_TYPE, index);
                                    db.setContent(cc);
                                    event.consume();
                                }
                            });

                            row.setOnDragOver(event -> {
                                Dragboard db = event.getDragboard();
                                if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                                    if (row.getIndex() != ((Integer)db.getContent(SERIALIZED_MIME_TYPE)).intValue()) {
                                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                                        event.consume();
                                    }
                                }
                            });

                            row.setOnDragDropped(event -> {
                                Dragboard db = event.getDragboard();
                                if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                                    int draggedIndex = (Integer) db.getContent(SERIALIZED_MIME_TYPE);
                                    LugarVisitar draggedPerson = (LugarVisitar) table.getItems().remove(draggedIndex);

                                    int dropIndex ;

                                    if (row.isEmpty()) {
                                        dropIndex = table.getItems().size() ;
                                    } else {
                                        dropIndex = row.getIndex();
                                    }

                                    table.getItems().add(dropIndex, draggedPerson);

                                    event.setDropCompleted(true);
                                    table.getSelectionModel().select(dropIndex);
                                    event.consume();
                                }
                            });

                            return row ;
                        });
                        circuitTable.setRowFactory(tv -> {
                            TableRow<LugarVisitar> row = new TableRow<>();

                            row.setOnDragDetected(event -> {
                                if (! row.isEmpty()) {
                                    Integer index = row.getIndex();
                                    Dragboard db = row.startDragAndDrop(TransferMode.MOVE);
                                    db.setDragView(row.snapshot(null, null));
                                    ClipboardContent cc = new ClipboardContent();
                                    cc.put(SERIALIZED_MIME_TYPE, index);
                                    db.setContent(cc);
                                    event.consume();
                                }
                            });

                            row.setOnDragOver(event -> {
                                Dragboard db = event.getDragboard();
                                if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                                    if (row.getIndex() != ((Integer)db.getContent(SERIALIZED_MIME_TYPE)).intValue()) {
                                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                                        event.consume();
                                    }
                                }
                            });

                            row.setOnDragDropped(event -> {
                                Dragboard db = event.getDragboard();
                                if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                                    int draggedIndex = (Integer) db.getContent(SERIALIZED_MIME_TYPE);
                                    LugarVisitar draggedPerson = (LugarVisitar) table.getItems().remove(draggedIndex);

                                    int dropIndex ;

                                    if (row.isEmpty()) {
                                        dropIndex = table.getItems().size() ;
                                    } else {
                                        dropIndex = row.getIndex();
                                    }

                                    table.getItems().add(dropIndex, draggedPerson);

                                    event.setDropCompleted(true);
                                    table.getSelectionModel().select(dropIndex);
                                    event.consume();
                                }
                            });

                            return row ;
                        });
                        //table.getItems().clear();
                        //table.getColumns().clear();


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
