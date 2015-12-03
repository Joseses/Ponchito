import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    private Stage stage;
    private static StartScreen startScreen;
    public static Puente puente;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        gotoMain();
        primaryStage.show();
    }

    private void gotoMain() throws Exception{
        replaceSceneContent("pantallaInicio.fxml");
    }

    private Parent replaceSceneContent(String fxml) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent page = fxmlLoader.load(getClass().getResource(fxml).openStream());
        Scene scene = stage.getScene();
        if(fxml.contentEquals("pantallaInicio.fxml")) {
            startScreen = (StartScreen) fxmlLoader.getController();
        }
        if (scene == null) {
            scene = new Scene(page, 600, 600);
            stage.setTitle("Agencia de viajes Ponchito");
            stage.setResizable(false);
            //scene.getStylesheets().add(Main.class.getResource("demo.css").toExternalForm());
            stage.setScene(scene);
        } else {
            stage.setTitle("Buscador");
            stage.setResizable(false);
            stage.getScene().setRoot(page);
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
        launch();
    }
}
