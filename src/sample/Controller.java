package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    public TextField username;

    public void loginClick(ActionEvent actionEvent) {
        System.out.println("Korisnicko ime: " + username.getText());
    }


    @FXML
    public void initialize() {
        //username.getStyleClass().add("neispravnoPolje");
        username.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                //System.out.printf("%s, %s\n", s, t1);
                username.getStyleClass().removeAll("neispravnoPolje");
                username.getStyleClass().removeAll("ispravnoPolje");
                if (t1.equals("elvir")) {
                    username.getStyleClass().add("ispravnoPolje");
                }
                else if (t1.isEmpty()) {
                    username.getStyleClass().removeAll("neispravnoPolje");
                }
                else {
                    username.getStyleClass().add("neispravnoPolje");
                }
            }
        });
    }
}
