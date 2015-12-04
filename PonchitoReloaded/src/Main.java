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
    private static MetaCreador metaCreador;
	public static String context = "";
    public static User user;
    public static Agente agente;
    public static Cliente cliente;

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
        if(contexto.equalsIgnoreCase("Agente")) {
            agente = new Agente();
        } else if(contexto.equalsIgnoreCase("Cliente")) {
            cliente = new Cliente();
        } else {
            user = new User();
        }
		folleto.createMenu(contexto);
	}

	private Parent replaceSceneContent(String fxml) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader();
		Parent page = fxmlLoader.load(getClass().getResource(fxml).openStream());
		Scene scene = stage.getScene();
		if (scene == null) {
			scene = new Scene(page, 1000, 600);
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
        for (String arg : args) {
            pass = pass + arg;
        }
		puente = new Puente(pass);
        metaCreador = new MetaCreador(puente);
        Agente.metaCreador = metaCreador;
        launch();
	}

	public void cerrarVentana() {
		follStage.close();
	}

    public ArrayList<LugarVisitar> getLugares() throws SQLException {
        return agente.getLugares();
    }
}
