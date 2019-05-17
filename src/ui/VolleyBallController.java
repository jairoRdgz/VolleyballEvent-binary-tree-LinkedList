package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class VolleyBallController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField path;

    @FXML
    private TextField idSpectators;

    @FXML
    private Label spectatorId;

    @FXML
    private Label timeSpectators;

    @FXML
    private TextField idParticipant;

    @FXML
    private Label participantId;

    @FXML
    private Label timeParticipant;

    @FXML
    private ImageView image;

    @FXML
    private Label data;

    @FXML
    void exportFile(ActionEvent event) {

    }

    @FXML
    void loadFile(ActionEvent event) {

    }

    @FXML
    void searchParticipant(ActionEvent event) {

    }

    @FXML
    void searchSpectators(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert path != null : "fx:id=\"path\" was not injected: check your FXML file 'Voleyball.fxml'.";
        assert idSpectators != null : "fx:id=\"idSpectators\" was not injected: check your FXML file 'Voleyball.fxml'.";
        assert spectatorId != null : "fx:id=\"spectatorId\" was not injected: check your FXML file 'Voleyball.fxml'.";
        assert timeSpectators != null : "fx:id=\"timeSpectators\" was not injected: check your FXML file 'Voleyball.fxml'.";
        assert idParticipant != null : "fx:id=\"idParticipant\" was not injected: check your FXML file 'Voleyball.fxml'.";
        assert participantId != null : "fx:id=\"participantId\" was not injected: check your FXML file 'Voleyball.fxml'.";
        assert timeParticipant != null : "fx:id=\"timeParticipant\" was not injected: check your FXML file 'Voleyball.fxml'.";
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'Voleyball.fxml'.";
        assert data != null : "fx:id=\"data\" was not injected: check your FXML file 'Voleyball.fxml'.";

    }
}
