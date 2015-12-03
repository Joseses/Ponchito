import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class StartScreen {

    public Text greeText;
    public Button invitadoB;
    public Button clienteB;
    public Button agenteB;
    boolean animated=false;
    TranslateTransition transition = new TranslateTransition(Duration.seconds(0.25), greeText);

    public void onClic(ActionEvent actionEvent) {
        this.greeText.setTranslateY(200);

    }
}
