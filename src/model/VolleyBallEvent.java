package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class VolleyBallEvent {
	
	private Participant root;
	private Participant first;
	
	public static final String PATH = "";
	
	public VolleyBallEvent(Participant root, Participant first) {
		super();
		this.root = root;
		this.first = first;
	}
	
	public void addToTree(int id, String firstName, String lastName, String email, String gender, int country, String photo, String birthday) {
		Participant newParticipant = new Participant(id,firstName, lastName, email, gender,country, photo, birthday);
		if(root == null) {
			root = newParticipant;
		}else {
			Participant current = root;
			while(current != null) {
				if(current.compareTo(newParticipant)<0) {
					if(current.getLeft()==null) {
						current.setLeft(newParticipant);
					}else {
						current = current.getLeft();
					}
				}else if(current.compareTo(newParticipant)>0) {
					if(current.getRigth()==null) {
						current.setRigth(newParticipant);
					}else {
						current = current.getRigth();
					}
				}else {
					current = current.getLeft();
				}
			}
		}
	}
	
	public void LoadFileAndAddToTree() throws IOException {
		File file = new File(PATH);
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		String line = br.readLine();
		line = br.readLine();
		while(line != null){
			String[] temporalDataArray = line.split(",");
			Participant temporalNewParticipant = new Participant(Integer.parseInt(temporalDataArray[0]),temporalDataArray[1],temporalDataArray[2],temporalDataArray[3],temporalDataArray[4],Integer.parseInt(temporalDataArray[5]),temporalDataArray[6],temporalDataArray[7]);
			line = br.readLine();
		}
		fileReader.close();
		br.close();
	}
	
	public Participant getRoot() {
		return root;
	}
	
	public void setRoot(Participant root) {
		this.root = root;
	}
	
	public Participant getFirst() {
		return first;
	}
	
	public void setFirst(Participant first) {
		this.first = first;
	}
}
