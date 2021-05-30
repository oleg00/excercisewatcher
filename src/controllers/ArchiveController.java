package controllers;

import openCVutils.*;
import resources.Localization;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


public class ArchiveController {

    @FXML
    private Button goBack;

    @FXML
    private ListView<String> archiveListView;

    @FXML
    private Label archiveLabel;

	void updateLocale() {
		ResourceBundle resBundle = ResourceBundle.getBundle("resources/ResourceBundle", Localization.currentLocale);
		goBack.setText(resBundle.getString("go_back"));
		archiveLabel.setText(resBundle.getString("list_of_videos"));
	}

    @FXML
    void initialize() {
		updateLocale();
		loadAllVideos();
    }

    @FXML
    void onGoBack(ActionEvent actionEvent) {
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

	private void loadAllVideos() {
		try (Stream<Path> listOfFiles = Files.walk(Paths.get("videos"))) {
			List<String> listOfFileNames = listOfFiles
				.filter(Files::isRegularFile)
				.map(Path::getFileName)
				.map(Path::toString)
				.collect(Collectors.toList());
			
			archiveListView.getItems().setAll(listOfFileNames);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
