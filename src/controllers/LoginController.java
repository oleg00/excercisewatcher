package controllers;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import resources.Localization;

public class LoginController {
    @FXML
    private Button loginButton;

    @FXML
    private PasswordField loginPasswordField;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField loginUsernameField;

    @FXML
    private Button langButton;

    @FXML
    void initialize() {
		updateLocale();

        langButton.setOnAction(event -> changeLocale());
        loginButton.setOnAction(this::login);
    }

    /**
     * Updates login fields locale.
     */
    void updateLocale() {
		ResourceBundle resBundle = ResourceBundle.getBundle("resources/ResourceBundle", Localization.currentLocale);

		loginButton.setText(resBundle.getString("login"));
		usernameLabel.setText(resBundle.getString("username"));
        passwordLabel.setText(resBundle.getString("password"));
        langButton.setText(Localization.currentLocale.getLanguage().toUpperCase());
	}

    /**
     * Changes locale from eng to ukr and vice-versa.
     */
    void changeLocale() {
        if (Localization.currentLocale == Localization.UKRAINE) {
			Localization.setCurrentLocale(Localization.ENGLISH);
		} else {
			Localization.setCurrentLocale(Localization.UKRAINE);
		}
		updateLocale();
    }

    /**
     * Login page switching to the main page.
     * @param actionEvent
     */
    void login(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader mainPage = new FXMLLoader(getClass().getResource("../pages/main.fxml"));
        Parent mainPane;
        try {
            mainPane = mainPage.load();
            primaryStage.setScene(new Scene(mainPane));
        } catch (IOException e) {
            e.printStackTrace();
            // System.out.println("test");
        }
    }
}
