package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    public TextField username;
    private SimpleStringProperty login;

    public Controller() {
        login = new SimpleStringProperty("Login");
    }

    public String getLogin() {
        return login.get();
    }

    public SimpleStringProperty loginProperty() {
        return login;
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public void loginClick(ActionEvent actionEvent) {
        System.out.println("Korisnicko ime: " + username.getText());
        System.out.println("login glasi: " + login.get());
        login.set("default");
    }


    @FXML
    public void initialize() {
        //username.getStyleClass().add("neispravnoPolje");
        username.textProperty().addListener((observableValue, s, t1) -> {
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
        );
    }
}
