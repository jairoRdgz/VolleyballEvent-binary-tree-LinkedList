package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    	try {
    		int id = Integer.parseInt(idParticipant.getText());
    	}catch (NumberFormatException e) {
    		Alert score = new Alert(AlertType.ERROR);
        	score.setTitle(" IV Copa Panamericana de Voleibol Masculino Sub-21");
        	score.initStyle(StageStyle.DECORATED);
        	score.setContentText("Please introduce a number");
        	score.show();
    	}
    }

    @FXML
    void searchSpectators(ActionEvent event) {
    	try {
    		int id = Integer.parseInt(idSpectators.getText());
    	}catch (NumberFormatException e) {
    		Alert score = new Alert(AlertType.ERROR);
        	score.setTitle(" IV Copa Panamericana de Voleibol Masculino Sub-21");
        	score.initStyle(StageStyle.DECORATED);
        	score.setContentText("Please introduce a number");
        	score.show();
    	}
    	
    }

    @FXML
    void initialize() {
    	volleyBallEvent = new VolleyBallEvent();
    	message.setVisible(false);
    }
}
