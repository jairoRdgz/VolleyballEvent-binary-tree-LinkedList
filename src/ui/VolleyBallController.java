package ui;

import java.io.File;
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
import javafx.stage.StageStyle;
import model.Participant;
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
    
    @FXML
    private Label id;

    @FXML
    private Label firstName;

    @FXML
    private Label lastName;

    @FXML
    private Label email;

    @FXML
    private Label gender;

    @FXML
    private Label country;

    @FXML
    private Label birthday;
    
    private VolleyBallEvent volleyBallEvent; 
    
    private FileChooser fileChooser;
    
    private File f;

    @FXML
    void exportFile(ActionEvent event) throws IOException {
  
    	fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Resource File");
    	fileChooser.getExtensionFilters().addAll(
    			new FileChooser.ExtensionFilter("CSV", "*.csv"));
    	f = fileChooser.showOpenDialog(null);
    	path.setText(volleyBallEvent.LoadFileAndAddToTree(f));
    	
    }

    @FXML
    void loadFile(ActionEvent event){
    	if(f!=null)
    		message.setVisible(true);
    	else {
    		message.setVisible(true);
    		message.setText("Sorry we were unnable to load the new gest(s)");
    	}
    }

    @FXML
    void searchParticipant(ActionEvent event) {
    	long time = System.currentTimeMillis();
    	try {
    		int id = Integer.parseInt(idParticipant.getText());
    		showDataInScreen(volleyBallEvent.searchParticipant(id));
    	}catch (NumberFormatException e) {
    		Alert score = new Alert(AlertType.ERROR);
        	score.setTitle(" IV Copa Panamericana de Voleibol Masculino Sub-21");
        	score.initStyle(StageStyle.DECORATED);
        	score.setContentText("Please introduce a number");
        	score.show();
    	}
    	timeParticipant.setText((System.currentTimeMillis()-time)/1000+" segs");
    }

    @FXML
    void searchSpectators(ActionEvent event) {
    	long time = System.currentTimeMillis();
    	try {
    		int id = Integer.parseInt(idSpectators.getText());
    		showDataInScreen(volleyBallEvent.searchSpectator(id));
    	}catch (NumberFormatException e) {
    		Alert score = new Alert(AlertType.ERROR);
        	score.setTitle(" IV Copa Panamericana de Voleibol Masculino Sub-21");
        	score.initStyle(StageStyle.DECORATED);
        	score.setContentText("Please introduce a number");
        	score.show();
    	}
    	
    	timeSpectators.setText((System.currentTimeMillis()-time)/1000+" segs");
    }
    
    public void showDataInScreen(Participant p) {
    	image.setImage(p.getPhoto());
    	id.setText(p.getId()+"");
    	firstName.setText(p.getFirstName());
    	lastName.setText(p.getLastName());
    	email.setText(p.getEmail());
    	gender.setText(p.getGender());
    	country.setText(p.getCountry());
    	birthday.setText(p.getBirthday());
    	volleyBallEvent.amplitud(p);
    }

    @FXML
    void initialize() {
    	volleyBallEvent = new VolleyBallEvent();
    	message.setVisible(false);
    }
}
