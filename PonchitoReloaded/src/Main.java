import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main extends Application {
    private Stage stage;
    private static StartScreen startScreen;
    private static Stage follStage;
    private static Folleto folleto;
    public static Puente puente;
    private static Main instance;
    public static String context = "";

    public Main() {
        instance = this;
    }
    public static Main getInstance() {
        return instance;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        gotoMain();
        primaryStage.show();
    }

    public void gotoMain() throws Exception{
        replaceSceneContent("pantallaInicio.fxml");
    }

    public void gotoFolleto(String contexto) throws Exception{
        replaceSceneContent("folleto.fxml");
        context = contexto;
        folleto.createMenu(contexto);
    }

    private Parent replaceSceneContent(String fxml) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent page = fxmlLoader.load(getClass().getResource(fxml).openStream());
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page, 600, 600);
            stage.setTitle("Agencia de viajes Ponchito");
            stage.setResizable(false);
            //scene.getStylesheets().add(Main.class.getResource("demo.css").toExternalForm());
            stage.setScene(scene);
        } else {
            stage.setTitle("Agencia de viajes");
            stage.setResizable(false);
            stage.getScene().setRoot(page);
        }
        if(fxml.contentEquals("pantallaInicio.fxml")) {
            startScreen = (StartScreen) fxmlLoader.getController();
        } else if(fxml.contentEquals("folleto.fxml")) {
            folleto = (Folleto) fxmlLoader.getController();
            follStage = stage;
        }
        stage.sizeToScene();
        return page;
    }

    public static void main(String[] args) throws Exception {
        String pass = "";
        for(int i = 0; i<args.length;i++) {
            pass = pass + args[i];
        }
        puente = new Puente(pass);
        //launch();
        MetaCreador metaCreador = new MetaCreador(puente);
        ArrayList<LugarVisitar> lugares = metaCreador.crearLugar();
        ArrayList<Hotel> hoteles = metaCreador.crearHoteles();
        ArrayList<Circuito> circuitos = metaCreador.crearCircuitos();

        for(int i = 0; i<lugares.size();i++) {
            LugarVisitar lugarVisitar = lugares.get(i);
            System.out.println(lugarVisitar.getNombre());
        }

        for(int i = 0; i<hoteles.size();i++) {
            Hotel hotel = hoteles.get(i);
            System.out.println(hotel.getNombreHotel());
        }

        for(int i = 0; i<circuitos.size();i++) {
            Circuito circuito = circuitos.get(i);
            System.out.println(circuito.getLugarSalida()[0]+"  "+circuito.getLugarLlegada()[0]);
        }

    }

    public void cerrarVentana() {
        follStage.close();
    }
}
