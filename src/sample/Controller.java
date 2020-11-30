package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class Controller {
    public TextField username;

    public void loginClick(ActionEvent actionEvent) {
        System.out.println("Korisnicko ime: " + username.getText());
        if (!username.getText().equals("elvir")) {
            username.getStyleClass().add("neispravnoPolje");
        }
        else {
            username.getStyleClass().add("ispravnoPolje");
        }
    }
}
