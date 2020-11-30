package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    public TextField loginField;
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
        System.out.println("Korisnicko ime: " + loginField.getText());
        System.out.println("login glasi: " + login.get());
        login.set("default");
    }


    @FXML
    public void initialize() {
        //username.getStyleClass().add("neispravnoPolje");
        loginField.textProperty().addListener((observableValue, s, t1) -> {
                //System.out.printf("%s, %s\n", s, t1);
                loginField.getStyleClass().removeAll("neispravnoPolje");
                loginField.getStyleClass().removeAll("ispravnoPolje");
                if (t1.equals("elvir")) {
                    loginField.getStyleClass().add("ispravnoPolje");
                }
                else if (t1.isEmpty()) {
                    loginField.getStyleClass().removeAll("neispravnoPolje");
                }
                else {
                    loginField.getStyleClass().add("neispravnoPolje");
                }
            }
        );

        loginField.textProperty().bindBidirectional(login);
    }
}
