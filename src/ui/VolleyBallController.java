package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.VolleyBallEvent;

public class VolleyBallController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField path;

    @FXML
    private Label message;

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
    
    private VolleyBallEvent volleyBallEvent;

    @FXML
    void exportFile(ActionEvent event) {
    	Stage stage = new Stage();
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Resource File");
    	fileChooser.showOpenDialog(stage);
    }

    @FXML
    void loadFile(ActionEvent event) throws IOException {
    	path.setText(volleyBallEvent.LoadFileAndAddToTree());
    	message.setVisible(true);
    }

    @FXML
    void searchParticipant(ActionEvent event) {
    	
    }

    @FXML
    void searchSpectators(ActionEvent event) {
    	
    }

    @FXML
    void initialize() {
    	volleyBallEvent = new VolleyBallEvent();
    	message.setVisible(false);
    }
}
